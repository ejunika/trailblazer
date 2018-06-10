package com.trailblazer.api.core.utils;

import java.util.Set;

import org.springframework.util.DigestUtils;

import com.trailblazer.api.core.entities.Role;

/**
 * @author azaz.akhtar
 *
 */
public class TbUtils {
	
	/**
	 * 
	 */
	public static final String MD5SALT = "Trail Blazer's user's credentials are very secure!!";
	
	private TbUtils() {
		super();
	}

	/**
	 * @param roles
	 * @return
	 */
	public static String getCommaSeparatedRoles(Set<Role> roles) {
		StringBuilder result = new StringBuilder();
		for (Role role : roles) {
			if (role != null && RecordStatus.ACTIVE.equals(role.getRecordStatus())) {
				result.append(role.getRoleName() + ",");
			}
		}
		return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
	}
	
	/**
	 * @param password
	 * @return
	 */
	public static String getPasswordHash(String password) {
		if (password != null) {
			password += MD5SALT;
			for (int i = 0; i < 1; i++) {
				password = DigestUtils.md5DigestAsHex(password.getBytes());
			}
		}
		return password;
	}
	
}
