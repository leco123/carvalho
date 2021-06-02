package com.webstore.carvalho.usuario.model;

import com.webstore.carvalho.usuario.EscopoPerfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "PERFIL")
@Entity
public class Perfil {
    
    @Column(name = "PERFILID")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String nome;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private EscopoPerfil escopoPerfil;

    @Getter @Setter
    @Column(name = "datacadastro")
    private LocalDateTime datacadastro = LocalDateTime.now();

    @Getter @Setter
    private Boolean ativo = true;

    public Perfil(){}
}