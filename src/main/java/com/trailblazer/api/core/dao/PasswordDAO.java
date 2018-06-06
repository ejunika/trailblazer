package com.trailblazer.api.core.dao;

import com.trailblazer.api.core.entities.Password;

public interface PasswordDAO extends CommonDAO<Password, Long>{

	Password getActivePasswordByUserId(Long userId);
	
}
