package com.trailblazer.api.core.utils;

import java.util.Set;

import com.trailblazer.api.core.entities.Role;

public class TbUtils {
	
	private TbUtils() {
		super();
	}

	public static String getCommaSeparatedRoles(Set<Role> roles) {
		StringBuilder result = new StringBuilder();
		for (Role role : roles) {
			if (role != null && RecordStatus.ACTIVE.equals(role.getRecordStatus())) {
				result.append(role.getRoleName() + ",");
			}
		}
		return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
	}
	
}
