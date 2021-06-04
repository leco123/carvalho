package com.webstore.carvalho.usuario;

import com.webstore.carvalho.usuario.model.Usuario;
import com.webstore.carvalho.util.persitence.CRUD;
import com.webstore.carvalho.util.persitence.ConsultaEntidade;
import io.swagger.annotations.ApiModelProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RequestScoped
public class UsuarioResource {

    @Inject
    private CRUD<Usuario> crud;

    @Inject
    private ConsultaEntidade<Usuario> consultaUsuario;

    public void adicionarUsuario(Usuario usuario) {
        try {
            crud.incluirAtomico(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Opss, não foi possível salvar, tente novamente ou entre em contato com nosso atendimento!");
        }
    }

    public List<Usuario> consultarTodosUsuarios() {
        return consultaUsuario.obterTodos();
    }
}