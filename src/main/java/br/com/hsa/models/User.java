package br.com.hsa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User implements Cloneable {
	
	public static final String URI = "/users/";
	
	@Id
	private String email;
	
	private String name;
	
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Note> notes = new ArrayList<Note>();
	
	private String activeToken;
	
	@Transient
	private List<Link> links = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String getActiveToken() {
		return activeToken;
	}

	public void setActiveToken(String activeToken) {
		this.activeToken = activeToken;
	}
	
	public User withNextSteps() {
		try {
			User user = (User) this.clone();
			user.links.add(new Link("login", UserSession.URI, "POST"));
			user.links.add(new Link("remember_password", User.URI, "GET"));
			return user;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
		
	}

}
