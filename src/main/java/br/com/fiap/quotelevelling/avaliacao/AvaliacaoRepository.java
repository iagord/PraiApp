package br.com.fiap.quotelevelling.avaliacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.quotelevelling.praia.Praia;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

    List<Avaliacao> findByPraia(Praia praia);

}
