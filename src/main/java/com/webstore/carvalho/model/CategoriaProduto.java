package com.webstore.carvalho.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ")";
    }
}