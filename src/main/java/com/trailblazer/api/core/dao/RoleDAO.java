package com.trailblazer.api.core.dao;

import java.util.List;

import com.trailblazer.api.core.entities.Role;
import com.trailblazer.api.core.entities.UserGroup;

public interface RoleDAO extends CommonDAO<Role, Long> {

	List<Role> getRolesByUserGroup(UserGroup userGroup);

}
