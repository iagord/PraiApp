package br.com.fiap.quotelevelling.responsavel;


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
@Table(name = "TB_RESPONSAVEL")
public class Responsavel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_responsavel;

    @Column(name = "NM_RESPONSAVEL")
    private String nome_responsavel;

    @NotBlank
    @Size(min = 11 ,  max = 11, message = "Um CPF deve conter 11 digítos")
    @Column(name = "CPF_RESPONSAVEL", nullable = false)
    private String cpf_responsavel;

}