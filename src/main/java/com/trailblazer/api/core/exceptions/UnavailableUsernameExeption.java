package com.trailblazer.api.core.exceptions;

import com.trailblazer.api.core.utils.BTMessageContainer;

public class UnavailableUsernameExeption extends BtException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnavailableUsernameExeption() {
		super(BTMessageContainer.DUPLICATE_USERNAME_EXCEPTION_MESSAGE);
	}

}
