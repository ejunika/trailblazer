package com.trailblazer.api.core.rest.services.impl;

import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.BtResponse;
import com.trailblazer.api.core.entities.SignupRequest;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.rest.manager.AuthManager;
import com.trailblazer.api.core.rest.services.AuthService;
import com.trailblazer.api.core.utils.BTMessageContainer;

/**
 * @author azaz.akhtar
 *
 */
public class AuthServiceImpl implements AuthService {
	
	private AuthManager authManager;

	@Override
	public Response login(User user) {
		return null;
	}

	@Override
	public Response logout() {
		return Response.ok(new BtResponse<>(true, BTMessageContainer.LOGOUT_SUCCESS_MESSAGE)).build();
	}

	@Override
	public Response signup(SignupRequest signupRequest) {
		if (authManager.signup(signupRequest)) {
			return Response.ok(new BtResponse<>(true, BTMessageContainer.SIGNUP_SUCCESS_MESSAGE)).build();
		} else {
			return Response.ok(new BtResponse<>(true, BTMessageContainer.SIGNUP_FAILURE_MESSAGE)).build();
		}
	}

	public AuthManager getAuthManager() {
		return authManager;
	}

	public void setAuthManager(AuthManager authManager) {
		this.authManager = authManager;
	}

}
