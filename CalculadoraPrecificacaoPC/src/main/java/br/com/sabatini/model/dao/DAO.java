//package br.com.sabatini.infrastructure;
//
//import jakarta.persistence.*;
//import br.com.sabatini.model.materiaprima.MateriaPrima;
//
//
//import java.util.List;
//
//public class DAO<T> {
//
//    private static EntityManagerFactory emf;
//    private final EntityManager em;
//    private final Class<T> classe;
//
//    static {
//        try {
//            emf = Persistence.createEntityManagerFactory("calculadora_precificacao");
//        } catch (Exception e) {
//            e.printStackTrace();
//            //loggar -> log4j
//        }
//    }
//
//    public DAO() {
//        this(null);
//    }
//
//    public DAO(Class<T> classe) {
//        this.classe = classe;
//        em = emf.createEntityManager();
//    }
//
//    public DAO<T> abrirTransacao() {
//        em.getTransaction().begin();
//        return this;
//    }
//
//    public DAO<T> fecharTransacao() {
//        em.getTransaction().commit();
//        return this;
//    }
//
//    public DAO<T> incluir(MateriaPrima entidade) {
//        em.persist(entidade);
//        return this;
//    }
//
//    public DAO<T> incluirCompleto(MateriaPrima entidade) {
//        return this.abrirTransacao().incluir(entidade).fecharTransacao();
//    }
//
//    public List<T> consultarTodos() {
//
//        if(classe == null) {
//            throw new UnsupportedOperationException("Classe nula");
//        }
//        String jpql = "SELECT e FROM " + classe.getName() + " e";
//        TypedQuery<T> query = em.createQuery(jpql, classe);
////        query.setMaxResults(20);
////        query.setFirstResult(0);
//        return query.getResultList();
//    }
//
//    public DAO<T> atualizarEntidade(T entidade) {
//        abrirTransacao();
//        em.merge(entidade);
//        fecharTransacao();
//        return this;
//    }
//
//    public void excluirEntidade(T entidade) {
//        abrirTransacao();
//        em.remove(entidade);
//        fecharTransacao();
//    }
//
//    public void fecharDAO() {
//        em.close();
//    }
//
//}
