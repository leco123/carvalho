package com.webstore.carvalho.produto;

import com.webstore.carvalho.produto.model.Produto;
import com.webstore.carvalho.usuario.model.Usuario;
import com.webstore.carvalho.util.persitence.CRUD;
import com.webstore.carvalho.util.persitence.ConsultaEntidade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ProdutoResource {

    @Inject
    private CRUD<Usuario> crud;

    @Inject
    private ConsultaEntidade<Produto> consultaProduto;

    public List<Produto> consultarListaComTodosOsProdutos() {
        return consultaProduto.obterTodos();
    }

}
