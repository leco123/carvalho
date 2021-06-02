package com.webstore.carvalho.unidade.model;

import com.webstore.carvalho.endereco.endereco.Endereco;
import com.webstore.carvalho.endereco.tipo.TipoEndereco;
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

    @Setter @Getter
    private Boolean principal;

    @JoinColumn
    @ManyToOne
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    public Unidade(){}

}
