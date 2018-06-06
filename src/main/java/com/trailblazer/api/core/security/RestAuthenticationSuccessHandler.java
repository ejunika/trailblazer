package com.trailblazer.api.core.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println(" Authorities  : "+authentication.getAuthorities());
		// We do not need to do anything extra on REST authentication success, because
		// there is no page to redirect to
		
//		for (GrantedAuthority grantedAuthority: authentication.getAuthorities()) {
//			if ("ROLE_ADMIN".equals(grantedAuthority.getAuthority())) {
//				
//			}
//		}
//		
//		response.sendRedirect(request.getPathInfo());
		
//		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		PrintWriter out = response.getWriter();
//		
//		String causedBy = "Not authorized";
//		
//		out.print("{\"status\":false,\"infoMessage\":\"" + causedBy + "\"}");
		
	}

}
