package com.booking.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class DAO<T> {

	protected Session getPrimarySession() {
		return DBService.initDBSession();
	}

	public Serializable save(T object) {
		try {
			Session session = getPrimarySession();
			session.beginTransaction();
			Serializable objectId = session.save(object);
			session.getTransaction().commit();
			session.close();
			return objectId;
		} catch (ConstraintViolationException ex) {
			throw ex;
		}
	}

	protected Class getObjectType() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] typeArguments = type.getActualTypeArguments();

		assert typeArguments.length == 1;

		return (Class)typeArguments[0];
	}

	/**
	 * @param
	 */
	public void saveOrUpdate(T object) {
		try {
			Session session = getPrimarySession();
			session.beginTransaction();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
		} catch (ConstraintViolationException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	public T find(Serializable objectId, T object) {
		Session session = getPrimarySession();
		return (T) session.get(object.getClass(), objectId);
	}

	public T find(Serializable objectId) {
		Session session = getPrimarySession();
		return (T) session.get(this.getObjectType(), objectId);
	}
}
