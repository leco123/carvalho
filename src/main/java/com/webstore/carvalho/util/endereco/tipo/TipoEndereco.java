package com.webstore.carvalho.util.endereco.tipo;

public enum TipoEndereco {

    RESIDENCIA("Endereço Residêncial"),
    EMPRESA("Endereço Empresarial");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
