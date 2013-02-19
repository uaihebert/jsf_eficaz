package dao;

import model.Cidade;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(eager = true)
@ApplicationScoped
/**
 * Este DAO está como ManagedBean para utilizar
 * os recursos de injeção de Dependência.
 *
 * Um DAO não deve ser um ManagedBean na vida real.
 *
 * Foi utilizado neste projeto como ManagedBean para facilitar
 * a utilização por parte dos leitores do livro.
 * */
public class CidadeDAO {
    @PersistenceContext(unitName = "jsfPU")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    @PostConstruct
    private void init() {
        List<Cidade> cidades = new ArrayList<Cidade>();

        for (int i = 0; i < 1000; i++) {
            cidades.add(new Cidade("CIDADE_" + (i + 1), "ESTADO_" + (i + 1), i * 33, i * 15, i * 3150, i * 4570, i * 75, i * 4.35d));
        }

        try {
            userTransaction.begin();
            persist(cidades);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void persist(List<Cidade> cidades) {

        for (Cidade cidade : cidades) {
            entityManager.persist(cidade);
        }

        entityManager.flush();
    }

    public List<Cidade> listAll() {
        TypedQuery<Cidade> query = entityManager.createQuery("select c from Cidade c", Cidade.class);
        return query.getResultList();
    }

    public List<Cidade> buscaPorPaginacao(int posicaoPrimeiraLinha, int maximoPorPagina) {
        return buscaPorPaginacao(posicaoPrimeiraLinha, maximoPorPagina, null, null, null);
    }

    public Cidade findById(int id) {
        return entityManager.find(Cidade.class, id);
    }

    public List<Cidade> findByNameLike(String valorPesquisado, int limitarTamanhoResultado) {
        TypedQuery<Cidade> query = entityManager.createQuery("select c from Cidade c where c.nome like :nome", Cidade.class);
        query.setParameter("nome", "%" + valorPesquisado + "%");

        if(limitarTamanhoResultado > 0){
            query.setMaxResults(limitarTamanhoResultado);
        }

        return query.getResultList();
    }

    public int countAll(Map<String, String> filtros) {
        String jpql = "select count(c) from Cidade c ";

        jpql = adicionarParametros(filtros, jpql);

        TypedQuery<Long> query =
                entityManager.createQuery(jpql, Long.class);

        popularParametros(query, filtros);

        return query.getSingleResult().intValue();
    }

    public List<Cidade> buscaPorPaginacao(int posicaoPrimeiraLinha,
                                          int maximoPorPagina,
                                          String ordernarPeloCampo,
                                          String ordernarAscOuDesc,
                                          Map<String, String> filtros){
        String jpql = "select c from Cidade c ";

        jpql = adicionarParametros(filtros, jpql);

        if(ordernarPeloCampo != null && !ordernarPeloCampo.isEmpty()){

            if(ordernarAscOuDesc.contains("DESC")){
                ordernarAscOuDesc = "DESC";
            } else{
                ordernarAscOuDesc = "ASC";
            }

            jpql += " ORDER BY c."
                    + ordernarPeloCampo
                    + " "
                    + ordernarAscOuDesc;
        }
// metodo buscarPorPaginacao
TypedQuery<Cidade> query =
        entityManager.createQuery(jpql, Cidade.class);

popularParametros(query, filtros);

query.setFirstResult(posicaoPrimeiraLinha);
query.setMaxResults(maximoPorPagina);
return query.getResultList();
    }

    // Evitando SQL Injection
    private void popularParametros(TypedQuery<?> query,
                                   Map<String,
                                   String> filtros) {
        for (Map.Entry<String, String> entry : filtros.entrySet()) {
            query.setParameter(entry.getKey(),
                               "%" + entry.getValue() + "%");
        }
    }

    private String adicionarParametros(Map<String, String> filtros,
                                       String jpql) {
        if(filtros != null && !filtros.isEmpty()){
            jpql += " where ";
            for (Map.Entry<String, String> entry : filtros.entrySet()) {
                 jpql += entry.getKey() + " like :" + entry.getKey() + " and ";
            }

            //remove ultimo and desnecessario
            jpql = jpql.substring(0, jpql.length() - 4);
        }

        return jpql;
    }
}