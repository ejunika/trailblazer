package com.trailblazer.api.core.rest.services.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.BtResponse;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.rest.services.UserService;
import com.trailblazer.api.core.utils.BTMessageContainer;

/**
 * @author azaz.akhtar
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public Response get(Integer offset, Integer limit, List<Byte> rsl) {
		User u = new User();
		u.setEmailId("akhtar.azaz@live.com");
		u.setUsername("ejunika");
		u.setFirstName("Md Azaz");
		u.setLastName("Akhtar");
		return Response.ok(new BtResponse<User>(true, BTMessageContainer.RETRIVE_USER_MESSAGE, u)).build();
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
