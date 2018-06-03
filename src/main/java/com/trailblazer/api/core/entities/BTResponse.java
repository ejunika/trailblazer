package com.trailblazer.api.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BTResponse<E extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean status;
	private String infoMessage;
	private List<E> data;

	public BTResponse() {
		super();
	}

	public BTResponse(Boolean status, String infoMessage, List<E> data) {
		super();
		this.status = status;
		this.infoMessage = infoMessage;
		this.data = data;
	}

	public BTResponse(Boolean status, String infoMessage) {
		super();
		this.status = status;
		this.infoMessage = infoMessage;
	}

	public BTResponse(Boolean status, String infoMessage, E entity) {
		super();
		this.status = status;
		this.infoMessage = infoMessage;
		this.data = new ArrayList<>();
		this.data.add(entity);
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}
}
