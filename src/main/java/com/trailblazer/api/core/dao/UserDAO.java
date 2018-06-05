package com.trailblazer.api.core.dao;

import com.trailblazer.api.core.entities.Password;
import com.trailblazer.api.core.entities.User;

public interface UserDAO extends CommonDAO<User, Long> {

	public User getUserByEmailId(String emailId);
	
	public User getUserByUsername(String username);

	public User blockUser(Long userId);

	public User activateUser(Long userId);
	
	public User signup(User user, Password password);

}
