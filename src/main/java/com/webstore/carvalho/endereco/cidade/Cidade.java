package com.webstore.carvalho.endereco.cidade;

import com.webstore.carvalho.endereco.estado.Estado;
import com.webstore.carvalho.endereco.pais.Pais;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Cidade {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String nome;

    @Getter @Setter
    @JoinColumn
    @ManyToOne
    private Pais pais;

    @Getter @Setter
    @JoinColumn
    @ManyToOne
    private Estado estado;

    public Cidade(){}
}
