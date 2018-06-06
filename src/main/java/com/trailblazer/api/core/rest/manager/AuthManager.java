package com.trailblazer.api.core.rest.manager;

import com.trailblazer.api.core.dao.PasswordDAO;
import com.trailblazer.api.core.dao.UserDAO;
import com.trailblazer.api.core.entities.Password;
import com.trailblazer.api.core.entities.SignupRequest;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.exceptions.DuplicateUserException;
import com.trailblazer.api.core.exceptions.UnavailableUsernameExeption;
import com.trailblazer.api.core.rest.services.LoginRequest;
import com.trailblazer.api.core.security.JwtUtil;

/**
 * @author azaz.akhtar
 *
 */
public class AuthManager {

	private UserDAO userDAO;
	
	private PasswordDAO passwordDAO;
	
	private JwtUtil jwtUtil;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @param user
	 * @return {@link Boolean} true if user registered else false
	 */
	public Boolean signup(SignupRequest signupRequest) {
		Boolean result = false;
		User user = null;
		if (!isDuplicateUser(signupRequest.getUser().getEmailId())) {
			if (isUsernameAvailable(signupRequest.getUser().getUsername())) {
				user = userDAO.signup(signupRequest.getUser(), signupRequest.getPassword());
				if (user.getEntityId() != null) {
					result = true;
				}
			} else {
				throw new UnavailableUsernameExeption();
			}
		} else {
			throw new DuplicateUserException();
		}
		return result;
	}

	/**
	 * Checks if the user is duplicate based on emailId
	 * 
	 * @param emailId
	 * @return {@link Boolean} true if user is duplicate else false
	 */
	private Boolean isDuplicateUser(String emailId) {
		Boolean result;
		User user = userDAO.getUserByEmailId(emailId);
		if (user != null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Checks avaiblity of username
	 * 
	 * @param username
	 * @return {@link Boolean} true if username is not associated with existing user
	 *         else false
	 */
	private Boolean isUsernameAvailable(String username) {
		Boolean result;
		User user = userDAO.getUserByUsername(username);
		if (user != null) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	public String doLogin(LoginRequest loginRequest) {
		String emailId = loginRequest.getEmailId();
		User user = userDAO.getUserByEmailId(emailId);
		String accessToken = null;
		Password password = passwordDAO.getActivePasswordByUserId(user.getEntityId());
		if (password.getPasswordHash().equals(loginRequest.getPassword())) {
			accessToken = jwtUtil.generateToken(user);			
		}
		return accessToken;
	}

	public JwtUtil getJwtUtil() {
		return jwtUtil;
	}

	public void setJwtUtil(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	public PasswordDAO getPasswordDAO() {
		return passwordDAO;
	}

	public void setPasswordDAO(PasswordDAO passwordDAO) {
		this.passwordDAO = passwordDAO;
	}

}
