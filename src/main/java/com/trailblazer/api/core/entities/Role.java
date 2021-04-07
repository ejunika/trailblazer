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
@Table(name = "roles")
@XmlRootElement
public class Role extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "role_name")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
