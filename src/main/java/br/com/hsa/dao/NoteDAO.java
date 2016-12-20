package br.com.hsa.dao;

import java.io.Serializable;
import java.util.Collection;

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
	
	public void edit(Note note){
		em.getTransaction().begin();
		em.merge(note);
		em.getTransaction().commit();
	}
	
	public Collection<Note> list(){
		String qlString = "select n from Note n";
		return em.createQuery(qlString, Note.class).getResultList();
	}
	
	public void delete(Long id){
		
	}

}
