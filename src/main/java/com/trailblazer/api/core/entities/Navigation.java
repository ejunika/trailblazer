package com.trailblazer.api.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "navigations")
@XmlRootElement
public class Navigation extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "parent")
	private Navigation parent;

	@Column(name = "nav_name")
	private String navName;

	@Column(name = "nav_url")
	private String navUrl;

	@Column(name = "nav_type")
	private Byte navType;

	@Column(name = "nav_icon_image_path")
	private String navIconImagePath;

	@Column(name = "nav_icon_class_name")
	private String navIconClassName;
	
	@Column(name = "has_children")
	private boolean hasChildren;

	public Navigation getParent() {
		return parent;
	}

	public void setParent(Navigation parent) {
		this.parent = parent;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getNavUrl() {
		return navUrl;
	}

	public void setNavUrl(String navUrl) {
		this.navUrl = navUrl;
	}

	public Byte getNavType() {
		return navType;
	}

	public void setNavType(Byte navType) {
		this.navType = navType;
	}

	public String getNavIconImagePath() {
		return navIconImagePath;
	}

	public void setNavIconImagePath(String navIconImagePath) {
		this.navIconImagePath = navIconImagePath;
	}

	public String getNavIconClassName() {
		return navIconClassName;
	}

	public void setNavIconClass(String navIconClassName) {
		this.navIconClassName = navIconClassName;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

}
