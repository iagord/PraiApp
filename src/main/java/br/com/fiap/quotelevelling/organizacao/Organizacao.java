package br.com.fiap.quotelevelling.organizacao;

import java.io.Serializable;

import br.com.fiap.quotelevelling.endereco.Endereco;
import br.com.fiap.quotelevelling.responsavel.Responsavel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ORGANIZACAO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Organizacao implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORGANIZACAO")
    private Long id_organizacao;

    @Column(name = "NM_ORGANIZACAO")
    private String nome_organizacao;

    @Column(name = "DESC_ORGANIZACAO")
    private String descricao_organizacao;

    @Column(name = "TP_ORGANIZACAO")
    private String tipo_organizacao;

    @Column(name = "CNPJ_ORGANIZACAO", nullable = false)
    @NotBlank
    @Size(min = 14 ,  max = 14, message = "Um CNPJ deve conter 14 digítos")
    private String cnpj_organizacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_ORGANIZACAO_ENDERECO")
    )
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_RESPONSAVEL",
            referencedColumnName = "ID_RESPONSAVEL",
            foreignKey = @ForeignKey(name = "FK_ORGANIZACAO_RESPONSAVEL")
    )
    private Responsavel responsavel;
}
