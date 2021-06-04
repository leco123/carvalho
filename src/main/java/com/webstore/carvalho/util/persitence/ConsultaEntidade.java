package com.webstore.carvalho.util.persitence;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsultaEntidade <Entidade> {

    @Inject
    private CRUD<Entidade> crud;

    public Entidade obterPorID(Object id) {
        return crud.getEntityManager()
                   .find(crud.getClasse(), id);
    }

    /**
     * Obter todos os registros
     * @return
     */
    public List<Entidade> obterTodos() {
        return this.obterTodos(10000, 0);
    }

    /**
     * Obter registro por quantidade
     * @param qtd quantidade máxima de registro mostrar no banco
     * @param comeca Começa a contar a partir de qual registro
     * @return List<Entidade> Lista de registro
     */
    public List<Entidade> obterTodos(int qtd, int comeca) {
        if (crud.getClasse() == null) {
            throw new UnsupportedOperationException("Opsss! Classe é nula!");
        }

        String jpql = "SELECT e FROM "+crud.getClasse().getName() +" e ";
        TypedQuery<Entidade> query = crud.getEntityManager().createQuery(jpql, crud.getClasse());
        query.setMaxResults(qtd);
        query.setFirstResult(comeca);
        return query.getResultList();
    }

    /**
     * Consultar Registro
     * @param nomeConsulta
     * @param params
     * @return
     */
    public List<Entidade> consultar(String nomeConsulta, Object... params) {
        TypedQuery<Entidade> query = crud.getEntityManager().createNamedQuery(nomeConsulta, crud.getClasse());

        for (int i = 0; i < params.length; i+=2) {
            query.setParameter(params[i].toString(), params[i+1]);
        }
        return query.getResultList();
    }

    /**
     * Consultar um registro
     * @param nomeConsulta
     * @param params
     * @return
     */
    public Entidade consultarUm(String nomeConsulta, Object... params) {
        List<Entidade> lista = (List<Entidade>) consultar(nomeConsulta, params);
        return lista.isEmpty() ? null : lista.get(0);
    }

}
