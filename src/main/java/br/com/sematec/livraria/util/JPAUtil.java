package br.com.sematec.livraria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexao-mysql");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
