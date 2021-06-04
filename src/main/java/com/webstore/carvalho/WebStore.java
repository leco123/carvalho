package com.webstore.carvalho;

import com.webstore.carvalho.produto.model.Produto;
import com.webstore.carvalho.produtocategoria.model.CategoriaProduto;
import com.webstore.carvalho.util.persitence.CRUD;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WebStore {

    public static void main(String[] args) {
        CRUD<Object> crud = new CRUD<>();

        List<CategoriaProduto> listCategoria  = new ArrayList<>();

        CategoriaProduto smartphone = new CategoriaProduto();
        CategoriaProduto notebook = new CategoriaProduto();

        smartphone.setNome("Smartphone Outro");
        notebook.setNome("Notebook Outro");

        listCategoria.add(smartphone);
        listCategoria.add(notebook);

        Produto produto = new Produto();
        produto.setNome("Notebook Acer Nitro");
        produto.setDescricao(" Notebook Top Acer Nitro 1050");
        produto.setPreco(new BigDecimal(5905.26));
        produto.setCategoriaProduto(listCategoria);

        crud.abrirTransacao()
            .incluir(produto)
            .fecharTransacao()
            .fecharConexao();
    }
}
