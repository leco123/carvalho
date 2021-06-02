package com.webstore.carvalho.endereco.endereco;

import com.webstore.carvalho.endereco.bairro.Bairro;
import com.webstore.carvalho.endereco.cidade.Cidade;
import com.webstore.carvalho.endereco.estado.Estado;
import com.webstore.carvalho.endereco.pais.Pais;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Endereco {

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

    @Getter @Setter
    @JoinColumn
    @ManyToOne
    private Cidade cidade;

    @Getter @Setter
    @JoinColumn
    @ManyToOne
    private Bairro bairro;

    private long cep;

    private String numero;

    public Endereco(){}

}
