package br.com.fiap.quotelevelling.avaliacao;

import br.com.fiap.quotelevelling.praia.Praia;
import br.com.fiap.quotelevelling.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_AVALIACAO")
public class Avaliacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avaliacao;

    @Column(name = "LIMPEZA_AVALIACAO")
    private double limpeza_avaliacao;

    @Column(name = "ESTRUTURA_AVALIACAO")
    private double estrutura_avaliacao;

    @Column(name = "SINALIZACAO_AVALIACAO")
    private double sinalizacao_avaliacao;

    @Column(name = "MONITORAMENTO_AVALIACAO")
    private double monitoramento_avaliacao;

    @Column(name = "POLUICAO_AVALIACAO")
    private double poluicao_avaliacao;

    @Column(name = "CONSERVACAO_AMBIENTAL_AVALIACAO")
    private double conservacao_avaliacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_USER",
            referencedColumnName = "ID_USER",
            foreignKey = @ForeignKey(name = "FK_AVALIACAO_USER")
    )
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_PRAIA",
            referencedColumnName = "ID_PRAIA",
            foreignKey = @ForeignKey(name = "FK_AVALIACAO_PRAIA")
    )
    private Praia praia;

}