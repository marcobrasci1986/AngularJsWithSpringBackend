package com.realdolmen.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public abstract class AbstractDAO<ID extends Serializable, ENTITY> {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AbstractDAO.class);

	@PersistenceContext(unitName="marcoPU")
	protected EntityManager em;

	private Class<ENTITY> entityClass;

	@SuppressWarnings("unchecked")
	public Class<ENTITY> getEntityClass() {
		if (entityClass != null) {
			return entityClass;
		}

		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) type;
		entityClass = (Class<ENTITY>) paramType.getActualTypeArguments()[1];
		return entityClass;
	}
	
	public ENTITY create(ENTITY entity) {

		try {
			em.persist(entity);
			em.flush();
			em.refresh(entity);

		} catch (RollbackException constraintViolationException) {
			System.out.println("Exception: " + constraintViolationException);
		}
		return entity;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public ENTITY find(ID key) {
		return em.find(getEntityClass(), key);
	}

	public ENTITY update(ENTITY entity) {
		return em.merge(entity);
	}

	public void delete(ENTITY entity) {
		em.remove(em.merge(entity));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public long count() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(getEntityClass())));
		return em.createQuery(cq).getSingleResult().longValue();
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<ENTITY> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ENTITY> cq = cb.createQuery(getEntityClass());
		cq.select(cq.from(getEntityClass()));
		List<ENTITY> resultList = em.createQuery(cq).getResultList();
		LOGGER.info("Found {} number of records", resultList.size());
		return resultList;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<ENTITY> findRange(int from, int to) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ENTITY> cq = cb.createQuery(getEntityClass());
		cq.select(cq.from(getEntityClass()));
		TypedQuery<ENTITY> q = em.createQuery(cq);
		q.setMaxResults(to - from);
		q.setFirstResult(from);
		return q.getResultList();
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<ENTITY> findByNamedQuery(String namedQuery, int resultLimit) {
		return this.em.createNamedQuery(namedQuery).setMaxResults(resultLimit).getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

}
