package br.com.fiap.quotelevelling.praia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.fiap.quotelevelling.avaliacao.AvaliacaoRepository;


@Controller
@RequestMapping("praias")
public class PraiaController {
    
    @Autowired
    PraiaRepository praiaRepository;

    @Autowired
    AvaliacaoRepository materialRepository;

    @Autowired
    MessageSource messageSource;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal DefaultOAuth2User user){
        model.addAttribute("praias", praiaRepository.findAll());
        model.addAttribute("user", user.getAttribute("name"));
        model.addAttribute("avatar", user.getAttribute("avatar_url"));
        return "praia/index";
    }
}