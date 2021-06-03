package com.webstore.carvalho.endereco.cidade;

import com.webstore.carvalho.endereco.estado.Estado;
import com.webstore.carvalho.endereco.pais.Pais;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model que representa a "Cidade/Município" de um Estado o Provincia
 */
@ApiModel(description = "Cidade do Estado")
@SequenceGenerator(schema = "principal", name = "seq_cidade", sequenceName = "seq_cidade_api", allocationSize = 1)
@Entity
public class Cidade {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "cidadeId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cidade")
    private Long id;

    @ApiModelProperty(name = "Nome da Cidade")
    @Column(nullable = false)
    @Setter @Getter
    private String nome;

    @ApiModelProperty(name = "País de Localização")
    @Getter @Setter
    @JoinColumn(name = "paisId", nullable = false)
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização da Cidade")
    @Getter @Setter
    @JoinColumn(name = "estadoId")
    @ManyToOne
    private Estado estado;

    public Cidade(){}
}
