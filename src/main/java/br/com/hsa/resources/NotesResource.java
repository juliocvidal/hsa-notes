package br.com.hsa.resources;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hsa.models.Note;
import br.com.hsa.models.infra.JPAUtil;

@Path("/notes")
public class NotesResource implements Serializable {
	
	private EntityManager em = new JPAUtil().getEntityManager();
	
	@Path("")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Note save(){
		Note note = new Note();
		em.getTransaction().begin();
		em.persist(note);
		em.getTransaction().commit();      
		em.close();
		return note;
	}

}
