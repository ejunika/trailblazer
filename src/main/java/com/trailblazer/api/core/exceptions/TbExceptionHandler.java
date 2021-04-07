package com.trailblazer.api.core.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.trailblazer.api.core.entities.BtResponse;

/**
 * @author azaz.akhtar
 *
 */
public class TbExceptionHandler implements ExceptionMapper<TbException> {

	@Override
	public Response toResponse(TbException btException) {
		return Response.ok(new BtResponse<>(false, btException.getMessage()))
				.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
	}

}