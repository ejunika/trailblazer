package com.trailblazer.api.core.exceptions;

import com.trailblazer.api.core.utils.TbMessageContainer;

public class DuplicateUserException extends TbException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateUserException() {
		super(TbMessageContainer.DUPLICATE_USER_EXCEPTION_MESSAGE);
	}
	
	public DuplicateUserException(String message) {
		super(message);
	}
}