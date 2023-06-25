package infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.MateriaPrima;

import java.util.List;

public class DAO<T> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<T> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("calculadora_precificacao");
        } catch (Exception e) {
            e.printStackTrace();
            //loggar -> log4j
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<T> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<T> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<T> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<T> incluir(T entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<T> incluirCompleto(T entidade) {
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public List<T> consultarTodos() {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe nula");
        }
        String jpql = "SELECT e FROM " + classe.getName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setMaxResults(20);
        query.setFirstResult(0);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    public DAO<T> atualizarMateriaPrima(T entidade) {
        this.abrirTransacao();
        em.merge(entidade);
        this.fecharTransacao();
        return this;
    }

    public void fecharDAO() {
        em.close();
    }

}
