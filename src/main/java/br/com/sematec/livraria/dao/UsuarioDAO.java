package br.com.sematec.livraria.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import br.com.sematec.livraria.modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	private static final long serialVersionUID = 1L;

	public static synchronized UsuarioDAO getInstance() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	private static UsuarioDAO instancia;

	private UsuarioDAO() {
		super(Usuario.class);
		geraDados();
	}

	public Usuario getUsuario(Usuario usuario) {

		Usuario usuarioBanco;
		Query query = em.createQuery("select u from Usuario u where u.email=:pEmail and u.senha=:pSenha");
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		try {
			usuarioBanco = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return usuarioBanco;

	}

	void geraDados() {

		Query query = em.createQuery("select u from Usuario u");
		if (query.getResultList().size() == 0) {

			adiciona(new Usuario("admin@admin.com", "admin", false));
			adiciona(new Usuario("diretor@sematecsolucoes.com.br", "diretor", true));

		}

	}

}
