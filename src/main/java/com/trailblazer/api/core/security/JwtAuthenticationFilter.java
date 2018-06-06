package com.trailblazer.api.core.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.trailblazer.api.core.utils.BTMessageContainer;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	
	public JwtAuthenticationFilter() {
        super("/**");
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/**"));
    }
	
	@Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new JwtTokenMissingException(BTMessageContainer.TOKEN_MISSING_MESSAGE);
        }

        String authToken = header.substring(7);

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
        System.out.println("getAuthenticationManager() :"+authRequest.getAuthorities());
        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        System.out.println(authResult.getAuthorities());
        System.out.println(authResult.isAuthenticated());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        
        chain.doFilter(request, response);
    }
    
}
