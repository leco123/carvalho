package com.webstore.carvalho.produto.model;

import com.webstore.carvalho.produtocategoria.model.CategoriaProduto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "PRODUTOS", schema = "public")
@Entity
public class Produto {

    @Column(name = "PRODUTOID")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String nome;

    @Getter @Setter
    @Column(nullable = false)
    private String descricao;

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal preco;

    @Getter @Setter
    @JoinColumn(name = "CATEGORIAPRODUTOID")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private CategoriaProduto categoriaProduto;

    @Getter @Setter
    @Column(name = "datacadastro")
    private LocalDateTime datacadastro = LocalDateTime.now();

    @Getter @Setter
    private Boolean ativo = true;

    public Produto(){}

}