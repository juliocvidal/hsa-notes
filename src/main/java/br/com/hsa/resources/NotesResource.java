package br.com.hsa.resources;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hsa.dao.NoteDAO;
import br.com.hsa.models.Note;

@Path("/notes")
public class NotesResource implements Serializable {
	
	@Inject
	private NoteDAO noteDAO;
	
	@Path("")
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Note save(){
		Note note = new Note();
		noteDAO.save(note);
		return note;
	}
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Note get(@PathParam("id") Long id){
		return noteDAO.getById(id);
	}

}
