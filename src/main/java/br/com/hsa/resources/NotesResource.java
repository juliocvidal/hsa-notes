package br.com.hsa.resources;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hsa.dao.NoteDAO;
import br.com.hsa.models.Note;

@Path("/notes")
public class NotesResource implements Serializable {
	
	@Inject
	private NoteDAO noteDAO;
	
	@Path("")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response save(Note note){
		noteDAO.save(note);
		try {
			return Response.created(new URI(note.URI + note.getId())).entity(note).build();
		} catch (URISyntaxException e) {
			return Response.serverError().entity(e).build();
		}
	}
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Note get(@PathParam("id") Long id){
		return noteDAO.getById(id);
	}

}
