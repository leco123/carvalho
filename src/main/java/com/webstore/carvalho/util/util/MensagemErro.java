package com.webstore.carvalho.util.util;

public enum MensagemErro {

    ER_PERSISTIR_DADO("Opsss, Não foi possível salvar, tente mais tarde ou entre em contato com atendimento!");

    private  String descricao;

    MensagemErro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
