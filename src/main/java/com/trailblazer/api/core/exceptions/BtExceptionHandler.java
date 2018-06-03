package com.trailblazer.api.core.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.trailblazer.api.core.entities.BtResponse;

/**
 * @author azaz.akhtar
 *
 */
public class BtExceptionHandler implements ExceptionMapper<BtException> {

	@Override
	public Response toResponse(BtException btException) {
		return Response.ok(new BtResponse<>(false, btException.getMessage()))
				.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
	}

}