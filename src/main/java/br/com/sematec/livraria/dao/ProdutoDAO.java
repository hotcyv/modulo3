package br.com.sematec.livraria.dao;

import java.math.BigDecimal;
import br.com.sematec.livraria.modelo.Produto;

public class ProdutoDAO extends DAO<Produto>{
	
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

	@Override
	void geraDados() {
		geraIdEAdiciona(new Produto("Caneta", "https://goo.gl/YLkbZm", new BigDecimal(5.5)));
		geraIdEAdiciona(new Produto("Livro", "https://goo.gl/G8EDI1", new BigDecimal(15.5)));
		geraIdEAdiciona(new Produto("Geladeira", "https://goo.gl/bk5FzT", new BigDecimal(25.5)));
		geraIdEAdiciona(new Produto("XBOX", "https://goo.gl/jG4mzZ", new BigDecimal(52.5)));
	}
}