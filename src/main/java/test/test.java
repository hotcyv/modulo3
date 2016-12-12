package test;

import javax.persistence.EntityManager;

import br.com.sematec.livraria.modelo.Usuario;
import br.com.sematec.livraria.util.JPAUtil;

public class test {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Usuario u1 = new Usuario("admin@admin.com", "admin", false);
		Usuario u2 = new Usuario("diretor@sematecsolucoes.com.br", "diretor", true);

		manager.persist(u1);
		manager.persist(u2);

		manager.getTransaction().commit();

		manager.close();

	}

}
