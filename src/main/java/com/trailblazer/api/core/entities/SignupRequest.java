package com.trailblazer.api.core.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author azaz.akhtar
 *
 */
@XmlRootElement
public class SignupRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;

	private Password password;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

}
