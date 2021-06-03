package com.webstore.carvalho.util.endereco.estado;

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
 * Classe Model que representa o "Estado" de um País
 */
@ApiModel(description = "Estado do País")
@SequenceGenerator(schema = "principal", name = "seq_estado", sequenceName = "seq_estado_api", allocationSize = 1)
@Entity
public class Estado {

    @ApiModelProperty(name = "Identificador")
    @Getter
    @Id
    @Column(name = "estadoId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estado")
    private Long id;

    @ApiModelProperty(name = "Nome do Estado")
    @Column(nullable = false)
    @Setter @Getter
    private String nome;

    @ApiModelProperty(name = "Código da Área")
    @Column(nullable = false, length = 3)
    @Getter @Setter
    private Integer ddd;

    @ApiModelProperty(name = "País onde fica localizado o estado")
    @Getter @Setter
    @JoinColumn(name = "paisId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;

    public Estado(){}
}
