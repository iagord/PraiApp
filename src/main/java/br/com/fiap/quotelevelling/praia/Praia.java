package br.com.fiap.quotelevelling.praia;

import br.com.fiap.quotelevelling.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PRAIA")
public class Praia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_praia;

    @Column(name = "NOME_PRAIA")
    private String nome_praia;

    @Column(name = "DESC_PRAIA")
    private String desc_praia;

    @Column(name = "LIMPEZA_PRAIA")
    private double tot_limpeza_praia;

    @Column(name = "ESTRUTURA_PRAIA")
    private double tot_estrutura_praia;

    @Column(name = "SINALIZACAO_PRAIA")
    private double tot_sinalizacao_praia;

    @Column(name = "MONITORAMENTO_PRAIA")
    private double tot_monitoramento_praia;

    @Column(name = "POLUICAO_PRAIA")
    private double tot_poluicao_praia;

    @Column(name = "CONSERVACAO_AMBIENTAL_PRAIA")
    private double tot_conservacao_praia;

    @Column(name = "TOTAL_PRAIA")
    private double total_praia;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_PRAIA_ENDERECO")
    )
    private Endereco endereco;

}
