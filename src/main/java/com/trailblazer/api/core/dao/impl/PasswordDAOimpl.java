package com.trailblazer.api.core.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.trailblazer.api.core.dao.PasswordDAO;
import com.trailblazer.api.core.entities.Password;
import com.trailblazer.api.core.entities.User;

public class PasswordDAOimpl extends CommonDAOimpl<Password, Long> implements PasswordDAO {

	private PasswordDAO passwordDAO;
	
	@Override
	public Password getActivePasswordByUserId(Long userId) {
		Password password = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<Password> criteriaQuery = null;
		Root<Password> root = null;
		Query<Password> query = null;
		try (Session session = getSessionFactory().openSession()) {
			builder = session.getCriteriaBuilder();
			criteriaQuery = builder.createQuery(Password.class);
			root = criteriaQuery.from(Password.class);
			criteriaQuery.where(builder.equal(root.get("createdBy"), new User(userId)));
			criteriaQuery.select(root);
			query = session.createQuery(criteriaQuery);
			password = query.uniqueResult();
		}
		return password;
	}

	public PasswordDAO getPasswordDAO() {
		return passwordDAO;
	}

	public void setPasswordDAO(PasswordDAO passwordDAO) {
		this.passwordDAO = passwordDAO;
	}

}
