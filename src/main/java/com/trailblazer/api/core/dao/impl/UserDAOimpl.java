package com.trailblazer.api.core.dao.impl;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trailblazer.api.core.dao.UserDAO;
import com.trailblazer.api.core.entities.Password;
import com.trailblazer.api.core.entities.User;
import com.trailblazer.api.core.utils.RecordStatus;

/**
 * @author azaz.akhtar
 *
 */
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

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<User> criteriaQuery = null;
		Root<User> root = null;
		Query<User> query = null;
		try (Session session = getSessionFactory().openSession()) {
			builder = session.getCriteriaBuilder();
			criteriaQuery = builder.createQuery(User.class);
			root = criteriaQuery.from(User.class);
			criteriaQuery.where(builder.equal(root.get("username"), username));
			criteriaQuery.select(root);
			query = session.createQuery(criteriaQuery);
			user = query.uniqueResult();
		}
		return user;
	}

	@Override
	public User signup(User user, Password password) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (transaction != null) {
				Date currentDate = new Date();
				user.setCreatedAt(currentDate);
				user.setUpdatedAt(currentDate);
				user.setRecordStatus(RecordStatus.NEW);
				password.setCreatedAt(currentDate);
				password.setUpdatedAt(currentDate);
				password.setRecordStatus(RecordStatus.ACTIVE);
				session.save(user);
				password.setCreatedBy(user);
				password.setUpdatedBy(user);
				session.save(password);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error(e);
		}
		return user;
	}

}
