package com.webstore.carvalho.util.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Moeda, representa a entidade "moeda", exemplo REAL, EURO, DÓLAR...
 */
@ApiModel(description = "Moeda")
@Entity
@SequenceGenerator(schema = "principal", name = "seq_moeda", sequenceName = "seq_moeda_api", allocationSize = 1)
public class Moeda {

    @ApiModelProperty(name = "Identificação")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_moeda")
    @Column(name = "moedaId")
    @Getter
    private Long id;

    @ApiModelProperty(name = "Sigla da Moeda")
    @Getter @Setter
    @Column(nullable = false, length = 6, unique = true)
    private String sigla;

    @ApiModelProperty(name = "Nome da Moeda")
    @Getter @Setter
    @Column(nullable = false)
    private String nome;

    public Moeda(){}

}
