package com.trailblazer.api.core.rest.services;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.User;

/**
 * @author M A AKHTAR
 *
 */
@WebService
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AuthService {

	/**
	 * @param user
	 * @return
	 */
	@POST
	@Path("/login")
	Response login(User user);

	/**
	 * @return
	 */
	@GET
	@Path("/logout")
	Response logout();

	/**
	 * @param user
	 * @return
	 */
	@POST
	@Path("/signup")
	Response signup(User user);

}
