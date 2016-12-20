package br.com.hsa.resources;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hsa.dao.UserDAO;
import br.com.hsa.models.User;
import br.com.hsa.models.UserSession;
import br.com.hsa.services.UserSessionService;

@Path("/login")
public class UserSessionsResources implements Serializable {

	@Inject
	private UserSessionService userSessionService;
	
	@Inject
	private UserDAO userDAO;

	@POST
	@Path("")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	public Response login(User user) {

		try {
			UserSession userSession = userSessionService.createSession(user);
			return Response.ok().entity(userSession.withNextStepsAfterLogin()).build();
 		} catch (NotAuthorizedException e){
 			return Response.status(403).build();
 		}
	}
}
