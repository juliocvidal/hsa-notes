package br.com.hsa.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hsa.models.Note;

public class NoteDAO implements Serializable {

	@Inject
	private EntityManager em;// = new JPAUtil().getEntityManager();
	
	public void save(Note note){
		em.getTransaction().begin();
		em.persist(note);
		em.getTransaction().commit();
	}

	public Note getById(Long id) {
		return em.find(Note.class, id);
	}

}
