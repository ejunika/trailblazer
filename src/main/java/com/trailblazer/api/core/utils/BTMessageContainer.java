package com.trailblazer.api.core.utils;

/**
 * @author azaz.akhtar
 *
 */
public class BTMessageContainer {

	public static final String TOKEN_MISSING_MESSAGE = "No JWT token found in request headers";
	public static final String LOGOUT_SUCCESS_MESSAGE = "Successfully logout";
	public static final String SIGNUP_SUCCESS_MESSAGE = "User registered successfully";
	public static final String SIGNUP_FAILURE_MESSAGE = "Error while registration";
	public static final String DUPLICATE_USER_EXCEPTION_MESSAGE = "An user with same emailId already exists";
	public static final String DUPLICATE_USERNAME_EXCEPTION_MESSAGE = "Username is not available";
	
	private BTMessageContainer() {
		super();
	}
	
}
