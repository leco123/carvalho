package com.webstore.carvalho.endereco.estado;

import com.webstore.carvalho.endereco.pais.Pais;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String nome;

    private Integer ddd;

    private Pais pais;

    public Estado(){}
}
