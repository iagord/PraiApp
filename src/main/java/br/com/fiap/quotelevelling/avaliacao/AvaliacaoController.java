package br.com.fiap.quotelevelling.avaliacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.quotelevelling.praia.Praia;
import br.com.fiap.quotelevelling.praia.PraiaRepository;
import br.com.fiap.quotelevelling.user.User;
import jakarta.validation.Valid;


@Controller
@RequestMapping("avaliacoes")
public class AvaliacaoController {
    

    @Autowired
    AvaliacaoRepository repository;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PraiaRepository praiaRepository;


    @GetMapping
    public String index(Model model, @AuthenticationPrincipal DefaultOAuth2User user){
        model.addAttribute("avaliacoes", repository.findAll());
        model.addAttribute("user", user.getAttribute("name"));
        model.addAttribute("avatar", user.getAttribute("avatar_url"));
        return "avaliacao/index";
    }

    @GetMapping("new")
    public String form(Avaliacao material){
        return "avaliacao/form";
    }

    @PostMapping
    public String insert(@Valid Avaliacao avaliacao, BindingResult result, RedirectAttributes redirect, @AuthenticationPrincipal DefaultOAuth2User user){
        if (result.hasErrors()) return "avaliacao/form";
        User logado = (User) user;
        avaliacao.setUser(logado);
        repository.save(avaliacao);

        // Buscar todas as avaliações da mesma praia
        Praia praia = avaliacao.getPraia();
        List<Avaliacao> avaliacoes = repository.findByPraia(praia);

        // Calcular as médias
        double totLimpeza = avaliacoes.stream().mapToDouble(Avaliacao::getLimpeza_avaliacao).average().orElse(0.0);
        double totEstrutura = avaliacoes.stream().mapToDouble(Avaliacao::getEstrutura_avaliacao).average().orElse(0.0);
        double totSinalizacao = avaliacoes.stream().mapToDouble(Avaliacao::getSinalizacao_avaliacao).average().orElse(0.0);
        double totMonitoramento = avaliacoes.stream().mapToDouble(Avaliacao::getMonitoramento_avaliacao).average().orElse(0.0);
        double totPoluicao = avaliacoes.stream().mapToDouble(Avaliacao::getPoluicao_avaliacao).average().orElse(0.0);
        double totConservacao = avaliacoes.stream().mapToDouble(Avaliacao::getConservacao_avaliacao).average().orElse(0.0);
        double totalPraia = (totLimpeza + totEstrutura + totSinalizacao + totMonitoramento + totPoluicao + totConservacao) / 6;

        // Atualizar a entidade Praia
        praia.setTot_limpeza_praia(totLimpeza);
        praia.setTot_estrutura_praia(totEstrutura);
        praia.setTot_sinalizacao_praia(totSinalizacao);
        praia.setTot_monitoramento_praia(totMonitoramento);
        praia.setTot_poluicao_praia(totPoluicao);
        praia.setTot_conservacao_praia(totConservacao);
        praia.setTotal_praia(totalPraia);

        praiaRepository.save(praia); // Salvar as atualizações na entidade Praia

        redirect.addFlashAttribute("message", messageSource.getMessage("avaliacao.create", null , LocaleContextHolder.getLocale()));
        return "redirect:/avaliacoes";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        var material = repository.findById(id);

        if (material.isEmpty()){
            redirect.addFlashAttribute("message", "Erro ao apagar. Material não encontrado");
            return "redirect:/avaliacoes";
        }

        try {
            repository.deleteById(id);
            redirect.addFlashAttribute("message", messageSource.getMessage("avaliacao.delete", null, LocaleContextHolder.getLocale()));
        } catch (DataIntegrityViolationException e) {
            redirect.addFlashAttribute("error", "Erro ao apagar. Material está associado a uma cotação e não pode ser deletado.");
        }
        return "redirect:/avaliacoes";
    }
}

