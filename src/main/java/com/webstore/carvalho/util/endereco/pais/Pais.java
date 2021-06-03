package com.webstore.carvalho.util.endereco.pais;

import com.webstore.carvalho.util.endereco.continente.Continente;
import com.webstore.carvalho.util.model.Moeda;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model País, representa a entidade do "pais" como Brasil, Alemanhã, Japão, US...
 */
@Entity
@ApiModel(description = "País")
@SequenceGenerator(schema = "principal", name = "seq_pais", sequenceName = "seq_pais_api",allocationSize = 1)
public class Pais {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "paisId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pais")
    private Long id;

    @ApiModelProperty(name = "Nome do País")
    @Column(nullable = false)
    @Setter @Getter
    private String nome;

    @ApiModelProperty(name = "Código do País")
    @Setter @Getter
    @Column(nullable = false, unique = true)
    private Integer codigoPais;

    @ApiModelProperty(name = "Sigla do País")
    @Column(nullable = false, unique = true, length = 4)
    @Getter @Setter
    private String Sigla;

    @ApiModelProperty(name = "Continente do País")
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Continente continente;

    @ApiModelProperty(name = "Moeda oficial do País")
    @Getter @Setter
    @JoinColumn(nullable = false, name = "moedaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Moeda moeda;

    public Pais(){}
}
