package com.trailblazer.api.core.rest.manager;

import java.util.List;

import com.trailblazer.api.core.dao.UserDAO;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.entities.UserGroup;
import com.trailblazer.api.core.utils.TbUtils;

/**
 * @author azaz.akhtar
 *
 */
public class UserManager {

	private UserDAO userDAO;

	public List<User> getAllUsers(Integer offset, Integer limit, List<Byte> rsl) {
		List<User> users = userDAO.getAll(offset, limit, rsl);
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				if (user.getUserGroups() != null) {
					StringBuilder roles = new StringBuilder();
					if (user.getUserGroups() != null) {
						for (UserGroup userGroup : user.getUserGroups()) {
							if (userGroup != null) {
								roles.append(TbUtils.getCommaSeparatedRoles(userGroup.getRoles()));
							}
						}
						user.setRoles(roles.toString());
					}
				}
				user.setUserGroups(null);
			}
		}
		return users;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
