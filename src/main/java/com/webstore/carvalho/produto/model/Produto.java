package com.webstore.carvalho.produto.model;

import com.webstore.carvalho.produtocategoria.model.CategoriaProduto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "Produto")
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_produto", sequenceName = "seq_produto_api", allocationSize = 1)
@Entity
public class Produto {

    @ApiModelProperty(name = "Identificação do Produto")
    @Column(name = "produtoId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @ApiModelProperty(name = "Nome do Produto")
    @Getter @Setter
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "Descrição do Produto")
    @Getter @Setter
    @Column(nullable = false)
    private String descricao;

    @ApiModelProperty(name = "Preço do Produto")
    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal preco;

    @ApiModelProperty(name = "Descrição do Produto")
    @Getter @Setter
    @ManyToMany(cascade = CascadeType.PERSIST)
    @Column(name = "categoriaId")
    @JoinTable(name = "rel_categoria_produto", schema = "principal")
    private List<CategoriaProduto> categoriaProduto;

    @ApiModelProperty(name = "Data do cadastro")
    @Getter @Setter
    @Column(name = "datacadastro")
    private LocalDateTime datacadastro = LocalDateTime.now();

    @ApiModelProperty(name = "Produto Ativo")
    @Getter @Setter
    private Boolean ativo = true;

    public Produto(){}

}