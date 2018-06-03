package com.trailblazer.api.core.exceptions;

import com.trailblazer.api.core.utils.BTMessageContainer;

public class DuplicateUserException extends BtException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateUserException() {
		super(BTMessageContainer.DUPLICATE_USER_EXCEPTION_MESSAGE);
	}
	
	public DuplicateUserException(String message) {
		super(message);
	}
}