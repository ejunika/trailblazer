package com.trailblazer.api.core.exceptions;

public class TbException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TbException() {
		
	}

	public TbException(String message) {
		super(message);
	}

}
