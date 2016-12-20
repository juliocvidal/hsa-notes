package br.com.hsa.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hsa.models.UserSession;

public class UserSessionDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(UserSession userSession){
		em.getTransaction().begin();
		em.persist(userSession);
		em.getTransaction().commit();
	}

}
