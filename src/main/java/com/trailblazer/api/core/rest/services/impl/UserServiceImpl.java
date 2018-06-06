package com.trailblazer.api.core.rest.services.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.BtResponse;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.rest.manager.UserManager;
import com.trailblazer.api.core.rest.services.UserService;
import com.trailblazer.api.core.utils.TbMessageContainer;

/**
 * @author azaz.akhtar
 *
 */
/**
 * @author azaz.akhtar
 *
 */
public class UserServiceImpl implements UserService {
	
	private UserManager userManager;

	@Override
	public Response get(Integer offset, Integer limit, List<Byte> rsl) {
		List<User> users = userManager.getAllUsers(offset, limit, rsl);
		return Response.ok(new BtResponse<User>(true, TbMessageContainer.RETRIVE_USER_MESSAGE, users)).build();
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
		return Response.ok(new BtResponse<User>(true, TbMessageContainer.DELETE_MESSAGE)).build();
	}

	@Override
	public Response put(Long id, User entity) {
		return null;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
