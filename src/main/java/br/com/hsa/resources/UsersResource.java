package br.com.hsa.resources;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hsa.dao.UserDAO;
import br.com.hsa.models.User;

@Path("/users")
public class UsersResource implements Serializable {
	
	@Inject
	private UserDAO userDAO;
	
	@Path("")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	public Response signUp(User user){
		
		userDAO.save(user);
		User savedUser = user.withNextSteps();
		
		try {
			return Response.created(new URI(user.URI)).entity(savedUser).build();
		} catch (URISyntaxException e) {
			return Response.serverError().entity(e).build();
		}
	}

}
