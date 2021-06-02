package com.webstore.carvalho.produtocategoria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "CATEGORIAPRODUTO", schema = "public")
@Entity
public class CategoriaProduto {

    @Column(name = "CATEGORIAPRODUTOID")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    @Column(name = "datacadastro")
    private LocalDateTime datacadastro = LocalDateTime.now();

    @Getter @Setter
    private Boolean ativo = true;

    public CategoriaProduto(){}
}