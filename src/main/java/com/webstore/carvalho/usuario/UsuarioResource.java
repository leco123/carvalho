package com.webstore.carvalho.usuario;

import com.webstore.carvalho.usuario.model.Usuario;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApiResponse(description = "Usuários do Sistema")
@Path("/usuarios")
public class UsuarioResource {

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        // Usuario.adicionar(usuario);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void listar(){
        //return Usuario.listAll();
    }

}