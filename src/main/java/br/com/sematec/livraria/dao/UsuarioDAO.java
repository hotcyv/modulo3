package br.com.sematec.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.sematec.livraria.modelo.Usuario;
import br.com.sematec.livraria.util.JPAUtil;

public class UsuarioDAO {

	public static synchronized UsuarioDAO getInstance() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	private static UsuarioDAO instancia;

	private UsuarioDAO() {
		geraDados();
	}

	public Usuario getUsuario(Usuario usuario) {

		EntityManager manager = new JPAUtil().getEntityManager();
		Query query2 = manager.createQuery("select u from Usuario u where u.email=:pEmail");
		query2.setParameter("pEmail", usuario.getEmail());

		Usuario usuarioBanco = (Usuario) query2.getSingleResult();
		manager.close();

		return usuarioBanco;

		//
		// Long i = 0l;
		// boolean retorno = false;
		// while (!retorno && i < LISTA.size()) {
		// if (StringUtils.equalsIgnoreCase(LISTA.get(i).getEmail(),
		// usuario.getEmail())
		// && StringUtils.equalsIgnoreCase(LISTA.get(i).getSenha(),
		// usuario.getSenha())) {
		// return LISTA.get(i);
		// }
		// i++;
		// }
		// return null;
	}

	void geraDados() {

		EntityManager manager = new JPAUtil().getEntityManager();

		Query query = manager.createQuery("select * from Usuario u");
		if (query.getResultList().size() == 0) {

			manager.getTransaction().begin();

			Usuario u1 = new Usuario("admin@admin.com", "admin", false);
			Usuario u2 = new Usuario("diretor@sematecsolucoes.com.br", "diretor", true);

			manager.persist(u1);
			manager.persist(u2);

			manager.getTransaction().commit();
		}

		manager.close();
	}
}
