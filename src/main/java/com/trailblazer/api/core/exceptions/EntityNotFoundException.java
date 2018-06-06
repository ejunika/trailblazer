package com.trailblazer.api.core.exceptions;

public class EntityNotFoundException extends TbException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException() {
		super("The entity you are trying to fetch does not exists");
	}

}
