package com.webstore.carvalho.usuario;

public enum EscopoPerfil {

    SUPERUSER("Escopo Super Usuário"),
    ADMINISTRADOR("Escopo Administrador"),
    VISITANTE("Escopo Visitante");

    private String descricao;

    EscopoPerfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

