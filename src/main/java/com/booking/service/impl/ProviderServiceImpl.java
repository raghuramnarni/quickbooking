package com.booking.service.impl;

import com.booking.dao.ProviderDAO;
import com.booking.db.DBService;
import com.booking.domain.Provider;
import com.booking.form.ProviderDetailsForm;
import com.booking.service.ProviderService;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 * Created by raghuramn on 6/22/16.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

	@SuppressWarnings("unchecked")
	@Override
	public Provider createProvider(ProviderDetailsForm form){
		Provider provider = new Provider(form);
	/*	Session session = DBService.initDBSession();
		session.beginTransaction();
		session.save(provider);
		session.getTransaction().commit();*/
		ProviderDAO<Provider> providerDAO = new ProviderDAO<Provider>();
		providerDAO.save(provider);
		return provider;
	}
}
