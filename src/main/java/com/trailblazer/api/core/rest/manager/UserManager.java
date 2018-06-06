package com.trailblazer.api.core.rest.manager;

import java.util.List;

import com.trailblazer.api.core.dao.UserDAO;
import com.trailblazer.api.core.entities.User;

/**
 * @author azaz.akhtar
 *
 */
public class UserManager {

	private UserDAO userDAO;

	public List<User> getAllUsers(Integer offset, Integer limit, List<Byte> rsl) {
		return userDAO.getAll(offset, limit, rsl);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
