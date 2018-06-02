package com.trailblazer.api.core.rest.services.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.rest.services.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public Response get(Integer offset, Integer limit, List<Byte> rsl) {
		return null;
	}

	@Override
	public Response post(User entity) {
		return null;
	}

	@Override
	public Response get(Long id) {
		return null;
	}

	@Override
	public Response delete(Long id) {
		return null;
	}

	@Override
	public Response put(Long id, User entity) {
		return null;
	}

}
