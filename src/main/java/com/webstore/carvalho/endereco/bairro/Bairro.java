package com.webstore.carvalho.endereco.bairro;

import com.webstore.carvalho.endereco.cidade.Cidade;
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
 * Classe Model que representa o "Bairro" de uma Cidade/Município
 */
@ApiModel(description = "Bairro do Município")
@SequenceGenerator(schema = "principal", name = "seq_bairro", sequenceName = "seq_bairro_api", allocationSize = 1)
@Entity
public class Bairro {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "bairroId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bairro")
    private Long id;

    @ApiModelProperty(name = "Nome do Bairro")
    @Column(nullable = false)
    @Setter @Getter
    private String nome;

    @ApiModelProperty(name = "País de Localização do Bairro")
    @Getter @Setter
    @JoinColumn(nullable = false, name = "paisId")
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização do Bairro")
    @Getter @Setter
    @JoinColumn(nullable = false, name = "estadoId")
    @ManyToOne
    private Estado estado;

    @ApiModelProperty(name = "Cidade de Localização do Bairro")
    @Getter @Setter
    @JoinColumn(nullable = false, name = "cidadeId")
    @ManyToOne
    private Cidade cidade;

    public Bairro(){}
}
