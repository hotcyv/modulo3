package br.com.sematec.livraria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.sematec.livraria.modelo.Produto;
import br.com.sematec.livraria.modelo.Usuario;
import br.com.sematec.livraria.util.JPAUtil;

public class ProdutoDAO {

	private static ProdutoDAO instancia;
	private EntityManager manager;
	private List<Produto> produtos;

	public static synchronized ProdutoDAO getInstance() {
		if (instancia == null) {
			instancia = new ProdutoDAO();
		}
		return instancia;
	}

	private ProdutoDAO() {
		manager = new JPAUtil().getEntityManager();
		geraDados();
	}

	void geraDados() {

		Query query = manager.createQuery("select p from Produto p");
		if (query.getResultList().size() == 0) {

			manager.getTransaction().begin();

			Produto p1 = new Produto("Caneta", "https://goo.gl/YLkbZm", new BigDecimal(5.5));
			Produto p2 = new Produto("Livro", "https://goo.gl/G8EDI1", new BigDecimal(15.5));
			Produto p3 = new Produto("Geladeira", "https://goo.gl/bk5FzT", new BigDecimal(25.5));
			Produto p4 = new Produto("XBOX", "https://goo.gl/jG4mzZ", new BigDecimal(52.5));

			manager.persist(p1);
			manager.persist(p2);
			manager.persist(p3);
			manager.persist(p4);

			manager.getTransaction().commit();
		}
	}

	public Produto buscaPorId(Long idProduto) {
		Produto produtoBanco;
		Query query = manager.createQuery("select p from Produto p where p.id=:pIdProduto");
		query.setParameter("pIdProduto", idProduto);

		try {

			produtoBanco = (Produto) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

		return produtoBanco;
	}

	public List<Produto> listaTodos() {
		Query query = manager.createQuery("select p from Produto p");
		produtos = query.getResultList();

		return produtos;
	}
	
	@Override
	protected void finalize() throws Throwable {
		manager.close();
		super.finalize();
	}

}