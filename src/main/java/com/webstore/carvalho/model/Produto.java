package com.webstore.carvalho.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "PRODUTOS", schema = "public")
@Entity
public class Produto {

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

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoriaProduto=" + categoriaProduto +
                '}';
    }
}