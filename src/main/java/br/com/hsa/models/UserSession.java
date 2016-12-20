package br.com.hsa.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class UserSession {
	
	public static final String URI = "/login";
	public static final String URI_LOGOUT = "/logout";

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private boolean active;
	
	private String token;

	@Temporal(TemporalType.DATE)
	private Calendar started = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar finished = Calendar.getInstance();

	@Transient
	private User user;
	
	@Transient
	private List<Link> links = new ArrayList<Link>();
	
	/**
	 * @deprecated for frameworks only
	 */
	public UserSession(){
		// for frameworks only
	}
	
	public UserSession(User loggedUser) {
		this.user = loggedUser;
		this.active = true;
		this.token = loggedUser.getId() + String.valueOf(System.currentTimeMillis());
		this.user.setActiveToken(token);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Calendar getStarted() {
		return started;
	}

	public void setStarted(Calendar started) {
		this.started = started;
	}

	public Calendar getFinished() {
		return finished;
	}

	public void setFinished(Calendar finished) {
		this.finished = finished;
	}

	public UserSession withNextStepsAfterLogin() {
		try {
			UserSession user = (UserSession) this.clone();
			user.links.add(new Link("logout", UserSession.URI_LOGOUT, "DELETE"));
			user.links.add(new Link("remember_password", User.URI + User.URI_REMEMBER_PASSWORD + "/" + user.getId(), "GET"));
			user.links.add(new Link("create_note", Note.URI_CREATE, "POST"));
			user.links.add(new Link("retrieve_notes", Note.URI_RETRIEVE + "/" + user.getId(), "GET"));
			return user;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
	}

}
