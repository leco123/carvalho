package com.webstore.carvalho.usuario;

import com.webstore.carvalho.usuario.model.Usuario;
import com.webstore.carvalho.util.persitence.ConsultaEntidade;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApiModel(value = "Usuario", description = "Usuários da Aplicação")
@Path("/v1/api/usuario")
public class UsuarioService {

    @Inject
    private UsuarioResource usuarioResource;

    @ApiModelProperty("Inclusão de Usuário")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        usuarioResource.adicionarUsuario(usuario);
    }

    @ApiModelProperty("Lista de Usuários")
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar() {
        return usuarioResource.consultarTodosUsuarios();
    }

}
