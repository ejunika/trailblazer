package com.trailblazer.api.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.trailblazer.api.core.dao.CommonDAO;
import com.trailblazer.api.core.entities.AbstractEntity;
import com.trailblazer.api.core.exceptions.EntityNotFoundException;
import com.trailblazer.api.core.utils.RecordStatus;

/**
 * @author azaz.akhtar
 *
 * @param <E>
 * @param <I>
 */
public abstract class CommonDAOimpl<E extends AbstractEntity, I extends Serializable> extends HibernateDaoSupport
		implements CommonDAO<E, I> {
	public static final Logger LOGGER = Logger.getLogger(CommonDAOimpl.class);
	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public CommonDAOimpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public E add(E entity) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (transaction != null) {
				Date currentDate = new Date();
				entity.setCreatedAt(currentDate);
				entity.setUpdatedAt(currentDate);
				entity.setRecordStatus(RecordStatus.NEW);
				session.save(entity);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error(e);
		}
		return entity;
	}

	@Override
	public E update(E entity) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (transaction != null) {
				entity.setUpdatedAt(new Date());
				session.update(entity);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error(e);
		}
		return entity;
	}

	@Override
	public E update(Long id, E entity) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (transaction != null) {
				entity.setUpdatedAt(new Date());
				entity.setEntityId(id);
				session.update(entity);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error(e);
		}
		return entity;
	}

	@Override
	public E addOrUpdate(E entity) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (transaction != null) {
				entity.setUpdatedAt(new Date());
				session.saveOrUpdate(entity);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error(e);
		}
		return entity;
	}

	@Override
	public E get(I entityId) {
		E entity = null;
		try (Session session = getSessionFactory().openSession()) {
			entity = session.get(entityClass, entityId);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return entity;
	}

	@Override
	public List<E> getAll(Integer offset, Integer limit, List<Byte> rsl) {
		List<E> entities = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<E> criteriaQuery = null;
		Root<E> root = null;
		Query<E> query = null;
		try (Session session = getSessionFactory().openSession()) {
			builder = session.getCriteriaBuilder();
			criteriaQuery = builder.createQuery(entityClass);
			root = criteriaQuery.from(entityClass);
			if (rsl != null && !rsl.isEmpty()) {
				criteriaQuery.where(root.get("recordStatus").in(rsl));
			}
			builder.asc(root.get("createdAt"));
			criteriaQuery.select(root);
			query = session.createQuery(criteriaQuery);
			if (offset != null) {
				query.setFirstResult(offset);
			}
			if (limit != null) {
				query.setMaxResults(limit);
			}
			entities = query.list();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return entities;
	}

	@Override
	public E delete(E entity) {
		try (Session session = getSessionFactory().openSession()) {
			session.delete(entity);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return entity;
	}

	@Override
	public E delete(I id) {
		E entity = null;
		try {
			entity = entityClass.newInstance();
			entity.setEntityId((Long) id);
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.error(e);
		}
		return delete(entity);
	}

	@Override
	public E vertualDelete(I id) {
		E entity = get(id);
		if (entity != null) {
			entity.setRecordStatus(RecordStatus.DELETED);
			update(entity);
		} else {
			throw new EntityNotFoundException();
		}
		return entity;
	}

	@Override
	public List<E> getAll() {
		return getAll(null, null, null);
	}

}
