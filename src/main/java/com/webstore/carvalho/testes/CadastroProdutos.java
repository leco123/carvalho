package com.webstore.carvalho.testes;

import com.webstore.carvalho.produtocategoria.model.CategoriaProduto;
import com.webstore.carvalho.produto.model.Produto;
import com.webstore.carvalho.util.persitence.CRUD;

import java.math.BigDecimal;

public class CadastroProdutos {

    public static void main(String[] args) {
        CRUD<Object> crud = new CRUD<>();

        CategoriaProduto catEletrodomesticos = new CategoriaProduto();
        catEletrodomesticos.setNome("Eletrodomésticos");

        Produto produto = new Produto();
        produto.setNome("Celuar Xaiomi MI 9");
        produto.setDescricao(" Ótimo celular aqui vai a descrição do produto");
        produto.setPreco(new BigDecimal(500));
        produto.setCategoriaProduto(catEletrodomesticos);

        crud.abrirTransacao()
                .incluir(catEletrodomesticos)
                .incluir(produto)
                .fecharTransacao()
                .fecharConexao();
    }
}
