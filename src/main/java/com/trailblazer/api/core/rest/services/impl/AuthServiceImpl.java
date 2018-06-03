package com.trailblazer.api.core.rest.services.impl;

import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.BTResponse;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.rest.services.AuthService;
import com.trailblazer.api.core.utils.BTMessageContainer;

/**
 * @author azaz.akhtar
 *
 */
public class AuthServiceImpl implements AuthService {

	@Override
	public Response login(User user) {
		return null;
	}

	@Override
	public Response logout() {
		return Response.ok(new BTResponse<>(true, BTMessageContainer.LOGOUT_SUCCESS_MESSAGE)).build();
	}

	@Override
	public Response signup(User user) {
		return null;
	}

}
