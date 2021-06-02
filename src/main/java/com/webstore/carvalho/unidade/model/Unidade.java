package com.webstore.carvalho.unidade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Unidade {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String nome;

    public Unidade(){}

}
