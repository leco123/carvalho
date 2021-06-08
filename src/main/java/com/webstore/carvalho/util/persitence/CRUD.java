package com.webstore.carvalho.util.persitence;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

//@ApplicationScoped
public class CRUD <Entidade> {

    /**
     * CICLO DE VIDA JPA
     *   NEW -> TRANSIENT -> persist() -> MANANGED -> commit()/flush() -> BD
     *                      MANANGED <- DETACHED -> closed()/clear()
     * Imagem representando ciclo devida JPA
     * https://image.slidesharecdn.com/cefet-2013-04-130408163740-phpapp01/95/mapeamento-objetorelacional-com-java-persistence-api-11-638.jpg?cb=1365439124
     */


    //private static EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;
    private Class<Entidade> classe;

    /*
     * Bloco static, carrega junto com a classe
     *
    static {
        try {
        //    emf = Persistence.createEntityManagerFactory("webstorecarvalho");
        } catch (Exception e) {
            System.out.println("Opsss!!!! Falha na conexão com a base de dados!!!");
        }
    }*/

    public CRUD() {
        this(null);
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public Class<Entidade> getClasse() {
        return classe;
    }

    public CRUD(Class<Entidade> classe) {
        this.classe = classe;
        // em = emf.createEntityManager();
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
        // só para garantir que a entidade esta manager
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
