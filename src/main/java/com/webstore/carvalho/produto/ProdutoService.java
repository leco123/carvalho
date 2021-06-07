package com.webstore.carvalho.produto;

import com.webstore.carvalho.produto.model.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;


@ApiModel(value = "Produtos", description = "Produtos")
@Path("/v1/api/produto")
public class ProdutoService {

    @Inject
    private ProdutoResource produtoResource;

    @ApiModelProperty(name = "Retorna lista com todos os produtos")
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> obterListaComTodosOsProdutos() {
        return produtoResource.consultarListaComTodosOsProdutos();
    }
    /*
    @ApiModelProperty(name = "Valor Total dos produtos listados")
    @Path("/valor/totalprodutos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal valorTotalDosProdutosListados() {
        return produtoResource.consultarListaComTodosOsProdutos()
                .stream()
                .map(p -> p.getPreco())
                .reduce(0.0, (t, p) -> t + p);
                //.doubleValue();
    }

    */

}
