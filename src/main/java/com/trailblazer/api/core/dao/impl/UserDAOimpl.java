package com.trailblazer.api.core.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.trailblazer.api.core.dao.UserDAO;
import com.trailblazer.api.core.entities.User;

public class UserDAOimpl extends CommonDAOimpl<User, Long> implements UserDAO {

	@Override
	public User getUserByEmailId(String emailId) {
		User user = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<User> criteriaQuery = null;
		Root<User> root = null;
		Query<User> query = null;
		try (Session session = getSessionFactory().openSession()) {
			builder = session.getCriteriaBuilder();
			criteriaQuery = builder.createQuery(User.class);
			root = criteriaQuery.from(User.class);
			criteriaQuery.where(builder.equal(root.get("emailId"), emailId));
			criteriaQuery.select(root);
			query = session.createQuery(criteriaQuery);
			user = query.uniqueResult();
		}
		return user;
	}

	@Override
	public User blockUser(Long userId) {
		return null;
	}

	@Override
	public User activateUser(Long userId) {
		return null;
	}
	
}
