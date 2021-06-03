package com.webstore.carvalho.usuario;

import com.webstore.carvalho.usuario.model.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.annotation.security.PermitAll;
import javax.persistence.SequenceGenerator;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApiModel(value = "Usuario", description = "Usuários")

@Path("/usuarios")
public class UsuarioResource {

    @ApiModelProperty("Inclusão de Usuário")
    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        // Usuario.adicionar(usuario);
    }

    @ApiModelProperty("Lista de Usuários")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void listar(){
        //return Usuario.listAll();
    }

}