package com.booking.db;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class DAO<T> {

	protected Session getPrimarySession() {
		return DBService.initDBSession();
	}

	public Serializable save(T object) {
		try {
			Session session = getPrimarySession();
			Serializable objectId = session.save(object);
			session.flush();
			return objectId;
		} catch (ConstraintViolationException ex) {
			throw ex;
		}
	}

	/**
	 * @param
	 */
	public void saveOrUpdate(T object) {
		try {
			Session session = getPrimarySession();
			session.saveOrUpdate(object);
			session.flush();
		} catch (ConstraintViolationException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	public T find(Serializable objectId, T object) {
		Session session = getPrimarySession();
		return (T) session.get(object.getClass(), objectId);
	}
}