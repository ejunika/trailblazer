package com.trailblazer.api.core.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.trailblazer.api.core.entities.BTResponse;

/**
 * @author azaz.akhtar
 *
 */
public class BTExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		return Response.ok(new BTResponse<>(false, exception.getMessage()))
				.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
	}

}