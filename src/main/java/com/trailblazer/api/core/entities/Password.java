package com.trailblazer.api.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author azaz.akhtar
 *
 */
@Entity
@Table(name = "passwords")
@XmlRootElement
public class Password extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "password_hash")
	private String passwordHash;

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
