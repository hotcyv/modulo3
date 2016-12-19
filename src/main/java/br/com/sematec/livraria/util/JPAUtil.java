package br.com.sematec.livraria.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {

	private static EntityManager instancia = null;

	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao-mysql");

	public static synchronized EntityManager getEntityManager() {
		if (instancia == null) {
			instancia = emf.createEntityManager();
		}
		return instancia;
	}
}