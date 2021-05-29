package com.webstore.carvalho.util.persitence;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class Persistir <Entidade> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<Entidade> classe;

    /*
     * Bloco static, carrega junto com a classe
     * */
    static {
        try {
            emf = Persistence.createEntityManagerFactory("webstorecarvalho");
        } catch (Exception e) {
            System.out.println("Opsss!!!! Falha na conexão com a base de dados!!!");
        }
    }

    public Persistir() {
        this(null);
    }

    public Persistir(Class<Entidade> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    /**
     * Abrir transação e retorna um método encadeado
     * ex: this.abrirTransacao().abrirTransacao().abrirTransacao()...
     * quantas vezes for necessário
     * @return Object DAO<E>
     */
    public Persistir<Entidade> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    /**
     * Fechar transação e retorna um método encadeado
     * ex: this.fecharTransacao().fecharTransacao().fecharTransacao()...
     * quantas vezes for necessário
     * @return Object DAO<Entidade>
     */
    public Persistir<Entidade> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    /**
     * Incluir entidade a ser persistida
     * @return Object DAO<Entidade>
     * @param entidade
     */
    public Persistir<Entidade> incluir(Entidade entidade) {
        em.persist(entidade);
        return this;
    }

    /**
     * Incluir entidade a ser persistida
     * @return Object DAO<Entidade>
     */
    public Persistir<Entidade> incluirAtomico(Entidade entidade) {
        return this.abrirTransacao()
                .incluir(entidade)
                .fecharTransacao();
    }

    public Entidade obterPorID(Object id) {
        return em.find(classe, id);
    }

    /**
     *
     * @return
     */
    public List<Entidade> obterTodos() {
        return this.obterTodos(10, 0);
    }

    /**
     * Obter todos os registros
     * @param qtd
     * @param deslocamento
     * @return
     */
    public List<Entidade> obterTodos(int qtd, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from "+classe.getName() +" e";
        TypedQuery<Entidade> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtd);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    /**
     * Consultar Registro
     * @param nomeConsulta
     * @param params
     * @return
     */
    public List<Entidade> consultar(String nomeConsulta, Object... params) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeConsulta, classe);
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

    /**
     * Limpar Conexão
     */
    public void clearConexao() {
        em.clear();
    }

    /**
     * Fechar conexão
     */
    public void fecharConexao() {
        em.close();
    }
}
