package br.com.sematec.livraria.dao;

import java.math.BigDecimal;
import javax.persistence.Query;

import br.com.sematec.livraria.modelo.Produto;

public class ProdutoDAO extends DAO<Produto> {

	private static final long serialVersionUID = 1L;
	private static ProdutoDAO instancia;

	public static synchronized ProdutoDAO getInstance() {
		if (instancia == null) {
			instancia = new ProdutoDAO();
		}
		return instancia;
	}

	private ProdutoDAO() {
		super(Produto.class);
		geraDados();
	}

	void geraDados() {

		Query query = em.createQuery("select p from Produto p");
		if (query.getResultList().size() == 0) {

			adiciona(new Produto("Caneta", "https://goo.gl/YLkbZm", new BigDecimal(5.5)));
			adiciona(new Produto("Livro", "https://goo.gl/G8EDI1", new BigDecimal(15.5)));
			adiciona(new Produto("Geladeira", "https://goo.gl/bk5FzT", new BigDecimal(25.5)));
			adiciona(new Produto("XBOX", "https://goo.gl/jG4mzZ", new BigDecimal(52.5)));

		}
	}

}