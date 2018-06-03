package com.trailblazer.api.core.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.trailblazer.api.core.entities.BtResponse;

/**
 * @author azaz.akhtar
 *
 */
public class CommonExceptionHandler implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable throwable) {
		return Response.ok(new BtResponse<>(false, throwable.getMessage()))
				.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
	}

}
