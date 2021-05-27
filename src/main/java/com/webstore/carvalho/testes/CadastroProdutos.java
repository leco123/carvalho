package com.webstore.carvalho.testes;

import com.webstore.carvalho.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProdutos {

    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Celuar Xaiomi MI 9");
        produto.setDescricao(" Ótimo celular aqui vai a descrição do produto");
        produto.setPreco(new BigDecimal(800));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("webstorecarvalho");
        EntityManager  em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }
}
