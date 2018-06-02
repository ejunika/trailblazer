package com.trailblazer.api.core.rest.services;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author M A AKHTAR
 *
 * @param <E>
 */
@WebService
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CommonService<E> {

	/**
	 * @param offset
	 * @param limit
	 * @param rsl
	 * @return
	 */
	@GET
	@Path("/")
	Response get(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit,
			@QueryParam("rsl") List<Byte> rsl);

	/**
	 * @param entity
	 * @return
	 */
	@POST
	@Path("/")
	Response post(E entity);

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	Response get(@PathParam("id") Long id);

	/**
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	Response delete(@PathParam("id") Long id);

	/**
	 * @param id
	 * @param entity
	 * @return
	 */
	@PUT
	@Path("/{id}")
	Response put(@PathParam("id") Long id, E entity);

}