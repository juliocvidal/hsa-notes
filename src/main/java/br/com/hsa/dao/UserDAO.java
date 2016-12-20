package br.com.hsa.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hsa.models.User;

public class UserDAO implements Serializable {

	@Inject
	private EntityManager em;

	public void save(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public boolean login(String email, String password) {
		User user = em.createQuery("select u from User u where u.email = :email and u.password = :password", User.class)
				.setParameter("email", email).setParameter("password", password).getSingleResult();
		return user != null;
	}

}
