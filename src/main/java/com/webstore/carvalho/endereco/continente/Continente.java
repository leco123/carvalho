package com.webstore.carvalho.endereco.continente;

public enum Continente {

    CONTINENTEAMERICANDO("Continente Americano"),
    CONTINENTEEUROPEU("Continente Europeu"),
    CONTINENTEASIATICO("Continente Asiático"),
    CONTINENTEAFRICANO("Continente Africano"),
    CONTINENTEOCEANIA("Continente Oceania"),
    CONTINENTEANTARTIDA("Continente Antártida");

    private String descricao;

    Continente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
