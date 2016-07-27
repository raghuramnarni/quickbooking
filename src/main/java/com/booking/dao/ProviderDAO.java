package com.booking.dao;

import com.booking.db.DAO;
import com.booking.domain.Provider;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by raghuramn on 6/18/16.
 */
public class ProviderDAO extends DAO<Provider> {

	public Provider findByEmail(String email){
		Criteria criteria = getPrimarySession().createCriteria(Provider.class, "provider");
		criteria.add(Restrictions.eq("email", email));
		return  (Provider) criteria.uniqueResult();
	}

	public Provider findByEmailAndPassword(String email, String password){
		Criteria criteria = getPrimarySession().createCriteria(Provider.class, "provider");
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		return  (Provider) criteria.uniqueResult();
	}

}
