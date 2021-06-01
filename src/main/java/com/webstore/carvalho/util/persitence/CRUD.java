package com.webstore.carvalho.util.persitence;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class CRUD <Entidade> {

    /**
     * CICLO DE VIDA JPA
     *   NEW -> TRANSIENT -> persist() -> MANANGED -> commit()/flush() -> BD
     *                      MANANGED <- DETACHED -> closed()/clear()
     * Imagem representando ciclo devida JPA
     * https://image.slidesharecdn.com/cefet-2013-04-130408163740-phpapp01/95/mapeamento-objetorelacional-com-java-persistence-api-11-638.jpg?cb=1365439124
     */


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

    public CRUD() {
        this(null);
    }

    public CRUD(Class<Entidade> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    /**
     * Abrir transação e retorna um método encadeado
     * ex: this.abrirTransacao().abrirTransacao().abrirTransacao()...
     * quantas vezes for necessário
     * @return Object DAO<E>
     */
    public CRUD<Entidade> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    /**
     * Fechar transação e retorna um método encadeado
     * ex: this.fecharTransacao().fecharTransacao().fecharTransacao()...
     * quantas vezes for necessário
     * @return Object DAO<Entidade>
     */
    public CRUD<Entidade> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    /**
     * Incluir entidade a ser persistida
     * @return Object DAO<Entidade>
     * @param entidade
     */
    public CRUD<Entidade> incluir(Entidade entidade) {
        em.persist(entidade);
        return this;
    }

    /**
     * Incluir entidade a ser persistida
     * @return Object DAO<Entidade>
     */
    public CRUD<Entidade> incluirAtomico(Entidade entidade) {
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
     * Só deve ser usado quando estiver com estado DETACHED
     * @param entidade
     * @return
     */
    public Entidade atualizar(Entidade entidade) {
        // devido não saber o estado da entidade, se faz necessário reatribuir o objeto (entidade)
        entidade = em.merge(entidade);
        return entidade;
    }

    public void remover(Entidade entidade) {
        // devido não saber o estado da entidade, se faz necessário reatribuir o
        // objeto (entidade) e definilo como estado manager,
        // pra isso basta setar objeto como manager e depois remover
        entidade = em.merge(entidade);
        em.remove(entidade);
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