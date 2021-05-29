package com.webstore.carvalho.resource.usuario;

import com.webstore.carvalho.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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