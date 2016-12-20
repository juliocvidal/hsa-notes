package br.com.hsa.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hsa.models.User;

public class UserDAO implements Serializable{
	
	@Inject
	private EntityManager em;

	public void save(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

}
