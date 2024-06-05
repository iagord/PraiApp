package br.com.fiap.quotelevelling.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ENDERECO")
public class Endereco {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private Long id_endereco;

    @Column(name = "RUA_ENDERECO")
    private String rua_endereco;

    @Column(name = "CID_ENDERECO")
    private String cidade_endereco;

    @Column(name = "UF_ENDERECO")
    private String uf_endereco;

}
