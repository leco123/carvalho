package com.webstore.carvalho.model;

import com.webstore.carvalho.util.persitence.EscopoPerfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "PERFIL")
@Entity
public class Perfil {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private EscopoPerfil escopoPerfil;

}