package br.com.treinamento.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("exemploEmpresa");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
