package com.trailblazer.api.core.dao;

import java.io.Serializable;
import java.util.List;

import com.trailblazer.api.core.entities.AbstractEntity;

/**
 * @author azaz.akhtar
 *
 * @param <E>
 * @param <I>
 */
public interface CommonDAO<E extends AbstractEntity, I extends Serializable> {

	/**
	 * @param entity
	 * @return
	 */
	E add(E entity);

	/**
	 * @param entity
	 * @return
	 */
	E update(E entity);

	/**
	 * @param id
	 * @param entity
	 * @return
	 */
	E update(Long id, E entity);

	/**
	 * @param entity
	 * @return
	 */
	E addOrUpdate(E entity);

	/**
	 * @param entityId
	 * @return
	 */
	E get(I entityId);

	/**
	 * @param offset
	 * @param limit
	 * @param rsl
	 * @return
	 */
	List<E> getAll(Integer offset, Integer limit, List<Byte> rsl);

	/**
	 * @param entity
	 * @return
	 */
	E delete(E entity);

	/**
	 * @param id
	 * @return
	 */
	E delete(I id);

	/**
	 * Changed the record status of the entity to deleted
	 * @param id
	 * @return
	 */
	E vertualDelete(I id);

}
