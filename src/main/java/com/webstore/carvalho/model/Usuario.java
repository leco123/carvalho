package com.webstore.carvalho.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Usuario {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false, name = "nome")
    private String nome;

    @Getter @Setter
    @Email
    private String email;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

}
