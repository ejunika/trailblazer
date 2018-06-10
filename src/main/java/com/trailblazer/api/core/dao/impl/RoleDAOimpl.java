package com.trailblazer.api.core.dao.impl;

import java.util.List;

import com.trailblazer.api.core.dao.RoleDAO;
import com.trailblazer.api.core.entities.Role;
import com.trailblazer.api.core.entities.UserGroup;

public class RoleDAOimpl extends CommonDAOimpl<Role, Long> implements RoleDAO {

	@Override
	public List<Role> getRolesByUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
