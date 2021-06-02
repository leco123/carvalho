package com.webstore.carvalho.endereco.pais;

import com.webstore.carvalho.endereco.continente.Continente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Pais {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String nome;

    @Setter @Getter
    private Integer codigoPais;

    @Enumerated(EnumType.STRING)
    private Continente continente;

    public Pais(){}
}
