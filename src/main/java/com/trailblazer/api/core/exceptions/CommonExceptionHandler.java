package com.trailblazer.api.core.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;

import com.trailblazer.api.core.entities.BtResponse;

/**
 * @author azaz.akhtar
 *
 */
public class CommonExceptionHandler implements ExceptionMapper<Throwable> {

	public static final Logger LOGGER = Logger.getLogger(CommonExceptionHandler.class);
	
	@Override
	public Response toResponse(Throwable throwable) {
		String errorMessage = throwable.getMessage();
		if (errorMessage == null) {
			String className = throwable.getClass().getName();
			errorMessage = "[(NullPointerException)]: in class " + className + ". Please see log for more details";
		}
		LOGGER.error(throwable);
		return Response.ok(new BtResponse<>(false, errorMessage))
				.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
	}

}
