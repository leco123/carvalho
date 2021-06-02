package com.webstore.carvalho.endereco.tipo;

public enum TipoEndereco {

    RESIDENCIA("Endreço Residêncial"),
    EMPRESA("Enderço Empresarial");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
