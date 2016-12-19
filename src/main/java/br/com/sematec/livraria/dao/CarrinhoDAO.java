package br.com.sematec.livraria.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.sematec.livraria.modelo.Carrinho;
import br.com.sematec.livraria.modelo.Usuario;

public class CarrinhoDAO extends DAO<Carrinho>{

	private static final long serialVersionUID = 1L;

	private static CarrinhoDAO carrinho;

	private CarrinhoDAO() {
		super(Carrinho.class);
	}

	public static synchronized CarrinhoDAO getInstance() {
		if (carrinho == null) {
			carrinho = new CarrinhoDAO();
		}
		return carrinho;
	}

	private Carrinho buscaCarrinho(Long idUsuario) {
		Carrinho carrinhoBanco = null;
		Query query = em.createQuery("select c from Carrinho c where c.usuario.id=:pIdUsuario");
		query.setParameter("pIdUsuario", idUsuario);

		try {
			carrinhoBanco = (Carrinho) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return carrinhoBanco;
	}

	public Carrinho adicionaCarrinho(Usuario usuario) {
		Carrinho carrinhoBanco = this.buscaCarrinho(usuario.getId());
		if (carrinhoBanco == null) {
			carrinhoBanco = new Carrinho();
			carrinhoBanco.setUsuario(usuario);
			carrinhoBanco = (Carrinho) atualiza(carrinhoBanco);
		}
		return carrinhoBanco;
	}


}
