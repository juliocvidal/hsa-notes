package br.com.hsa.models.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsanotes");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(EntityManager manager) {
		manager.close();
	}
}