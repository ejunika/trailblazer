package com.trailblazer.api.core.exceptions;

import com.trailblazer.api.core.utils.TbMessageContainer;

public class UnavailableUsernameExeption extends TbException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnavailableUsernameExeption() {
		super(TbMessageContainer.DUPLICATE_USERNAME_EXCEPTION_MESSAGE);
	}

}
