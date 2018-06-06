package com.trailblazer.api.core.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.trailblazer.api.core.entities.User;

public class RestAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtUtil jwtUtil;

	public JwtUtil getJwtUtil() {
		return jwtUtil;
	}

	public void setJwtUtil(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) {
		//
	}
	
	
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
		List<GrantedAuthority> grantedAuthorities = null;
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		String token = jwtAuthenticationToken.getToken();
		User parsedUser = jwtUtil.parseToken(token);
		if (parsedUser == null) {
			throw new JwtTokenMalformedException("JWT token is not valid");
		}
        System.out.println("@@@@@@@@@"+SecurityContextHolder.getContext());
        
		grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRoles());
		
		return new AuthenticatedUser(parsedUser.getEntityId(), parsedUser.getUsername(), token, grantedAuthorities);
	}
	

}
