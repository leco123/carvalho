package com.webstore.carvalho.produtocategoria.model;

import com.webstore.carvalho.produto.model.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Categoria do Produto que representa entidade "categoriaproduto"
 */

@ApiModel(description = "Categoria do Produto")
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_categoria_produto", sequenceName = "seq_categoria_produto_api", allocationSize = 1)
@Entity
public class CategoriaProduto {

    @ApiModelProperty(name = "Identificação da Categoria")
    @Column(name = "categoriaProdutoId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
    private Long id;

    @ApiModelProperty(name = "Nome da Categoria do Produto")
    @Column(nullable = false)
    @Getter @Setter
    private String nome;

    @ApiModelProperty(name = "Data e Hora do Cadastro da Categoria")
    @Getter @Setter
    @Column(nullable = false)
    private LocalDateTime datahoracadastro = LocalDateTime.now();

    @ApiModelProperty(name = "Categoria Ativa")
    @Column(nullable = false)
    @Getter @Setter
    private Boolean ativo = true;

    @ApiModelProperty(name = "Lista de Produtos")
    @ManyToMany(mappedBy = "categoriaProduto")
    @Column(name = "produtoId")
    @Getter @Setter
    private List<Produto> produto;

    public CategoriaProduto(){}
}