package br.com.hsa.services;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;

import br.com.hsa.dao.UserDAO;
import br.com.hsa.dao.UserSessionDAO;
import br.com.hsa.models.User;
import br.com.hsa.models.UserSession;

public class UserSessionService {
	
	@Inject
	private UserDAO userDAO;
	
	@Inject
	private UserSessionDAO userSessionDAO;
	
	public UserSession createSession(User user){
		if (userDAO.login(user.getEmail(), user.getPassword())){
			UserSession userSession = new UserSession(user);
			userSessionDAO.save(userSession);
			return userSession;
		} else{
			throw new NotAuthorizedException(user);
		}
	}

}
