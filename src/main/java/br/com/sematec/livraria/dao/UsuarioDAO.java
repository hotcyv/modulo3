package br.com.sematec.livraria.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	private EntityManager manager;

	private UsuarioDAO() {
		manager = new JPAUtil().getEntityManager();
		geraDados();
	}

	public Usuario getUsuario(Usuario usuario) {

		Usuario usuarioBanco;
		Query query = manager.createQuery("select u from Usuario u where u.email=:pEmail and u.senha=:pSenha");
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		try {

			usuarioBanco = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

		// manager.close();

		return usuarioBanco;

	}

	void geraDados() {

		Query query = manager.createQuery("select u from Usuario u");
		if (query.getResultList().size() == 0) {

			manager.getTransaction().begin();

			Usuario u1 = new Usuario("admin@admin.com", "admin", false);
			Usuario u2 = new Usuario("diretor@sematecsolucoes.com.br", "diretor", true);

			manager.persist(u1);
			manager.persist(u2);

			manager.getTransaction().commit();
		}

		// manager.close();
	}

	public Usuario buscaPorId(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Usuario> listaTodos() {

		Query query = manager.createQuery("select u from Usuario u");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) query.getResultList();
		// manager.close();

		return usuarios;
	}

	public void remove(Usuario usuario) {
		manager.getTransaction().begin();
		Usuario usuarioMerge = manager.merge(usuario);
		manager.remove(usuarioMerge);
		manager.getTransaction().commit();

	}

	@Override
	protected void finalize() throws Throwable {
		manager.close();
		super.finalize();
	}

	public void atualiza(Usuario usuario) {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		
	}

	public void adiciona(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
	}
}
