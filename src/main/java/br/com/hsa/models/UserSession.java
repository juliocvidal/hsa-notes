package br.com.hsa.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserSession {
	
	public static final String URI = "/login";

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private boolean active;
	
	private String token;

	@Temporal(TemporalType.DATE)
	private Calendar started = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar finished = Calendar.getInstance();
	
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

}
