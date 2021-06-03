package com.webstore.carvalho.util.endereco.endereco;

import com.webstore.carvalho.util.endereco.bairro.Bairro;
import com.webstore.carvalho.util.endereco.cidade.Cidade;
import com.webstore.carvalho.util.endereco.estado.Estado;
import com.webstore.carvalho.util.endereco.pais.Pais;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model que representa o "Endereço" de Localização de Uma Instituição, Empresa ou Pessoa
 */
@ApiModel(description = "Endereço")
@SequenceGenerator(schema = "principal", name = "seq_endereco", sequenceName = "seq_endereco_api", allocationSize = 1)
@Entity
public class Endereco {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "enderecoId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
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

    @ApiModelProperty(name = "Bairro de Localização")
    @Getter @Setter
    @JoinColumn(nullable = false, name = "bairroId")
    @ManyToOne
    private Bairro bairro;

    @ApiModelProperty(name = "CEP-Código de Endereçamento Postal")
    @Getter @Setter
    @Column(nullable = false)
    private long cep;

    @ApiModelProperty(name = "Número do Endereço")
    @Getter @Setter
    private String numero;

    @ApiModelProperty(name = "Coordenada Geográfica de Latitude")
    @Getter @Setter
    private String latitude;

    @ApiModelProperty(name = "Coordenada Geográfica de Longitude")
    @Getter @Setter
    private String Longitude;

    public Endereco(){}

}
