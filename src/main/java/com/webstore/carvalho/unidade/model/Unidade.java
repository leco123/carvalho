package com.webstore.carvalho.unidade.model;

import com.webstore.carvalho.endereco.endereco.Endereco;
import com.webstore.carvalho.endereco.tipo.TipoEndereco;
import com.webstore.carvalho.util.model.Moeda;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Unidade que representa entidade "unidade" também pode ser definido como
 * Estabelecimento, instituição entre outros.
 */
@Entity
@ApiModel(description = "Unidade/Estabelecimento")
@SequenceGenerator(schema = "principal", name = "seq_unidade", sequenceName = "seq_unidade_api", allocationSize = 1)
public class Unidade {

    @ApiModelProperty("Indentificador")
    @Getter
    @Id
    @Column(name = "unidadeId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidade")
    private Long id;

    @ApiModelProperty("Nome da Unidade")
    @Setter @Getter
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty("Unidade principal")
    @Setter @Getter
    @Column(nullable = false)
    private Boolean principal;

    @ApiModelProperty("Email principal da Unidade")
    @Getter @Setter
    @Email
    @Column(nullable = false)
    private String email;

    @ApiModelProperty("Endereço da Unidade")
    @JoinColumn(name = "enderecoId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Endereco endereco;

    @ApiModelProperty("Tipo de Endereço")
    @Getter @Setter
    @JoinColumn(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @ApiModelProperty(name = "Moeda")
    @Getter @Setter
    @JoinColumn(name = "moedaId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Moeda moeda;

    @ApiModelProperty("Unidade ativa no sistema")
    @Getter @Setter
    @Column(nullable = false)
    private Boolean ativo = true;

    public Unidade(){}

}
