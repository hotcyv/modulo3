package br.com.sematec.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.sematec.livraria.util.JPAUtil;

public class DAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;
	protected EntityManager em;

	public DAO(Class<T> classe) {
		this.classe = classe;
		this.em = JPAUtil.getEntityManager();
	}

	public void adiciona(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public Object atualiza(T t) {
		Object obj = null;
		em.getTransaction().begin();
		obj = em.merge(t);
		em.getTransaction().commit();
		return obj;
	}

	public T buscaPorId(Long id) {
		T instancia = em.find(classe, id);
		return instancia;
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		return lista;
	}

	public void remove(T t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
	}
}