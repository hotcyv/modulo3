package br.com.sematec.livraria.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.sematec.livraria.modelo.Carrinho;
import br.com.sematec.livraria.modelo.Item;
import br.com.sematec.livraria.modelo.Produto;

public class CarrinhoDAO extends DAO<Carrinho>{

	private static CarrinhoDAO carrinho;

	private final static Map<String, Carrinho> CARRINHOS = new HashMap<>();

	private CarrinhoDAO() {
		super(Carrinho.class);
	}

	public static synchronized CarrinhoDAO getInstance() {
		if (carrinho == null) {
			carrinho = new CarrinhoDAO();
		}
		return carrinho;
	}

	private Carrinho buscaCarrinho(String idUsuario) {
		Carrinho carrinho = null;
		carrinho = CARRINHOS.get(idUsuario);
		return carrinho;
	}

	public Carrinho adicionaCarrinho(String idUsuario) {
		Carrinho carrinho = this.buscaCarrinho(idUsuario);
		if (carrinho == null) {
			carrinho = new Carrinho();
			if (!CARRINHOS.containsKey(idUsuario)) {
				CARRINHOS.put(idUsuario, carrinho);
			}
		}
		return carrinho;
	}

	@Override
	void geraDados() {
		// TODO Auto-generated method stub
		
	}

}
