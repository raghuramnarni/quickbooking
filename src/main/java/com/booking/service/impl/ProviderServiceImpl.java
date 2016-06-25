package com.booking.service.impl;

import com.booking.dao.ProviderDAO;
import com.booking.domain.Provider;
import com.booking.form.ProviderDetailsForm;
import com.booking.service.ProviderService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.booking.dao.PropertyDAO;
import com.booking.modal.Property;

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
		ProviderDAO<Provider> providerDAO = new ProviderDAO<Provider>();
		HashSet<com.booking.domain.Property> properties = new HashSet<com.booking.domain.Property>();
		for(Property property : form.getProperties()){
			com.booking.domain.Property domainProperty = new com.booking.domain.Property(property);
			PropertyDAO<com.booking.domain.Property> propertyDAO = new PropertyDAO<com.booking.domain.Property>();
			domainProperty.setProvider(provider);
			propertyDAO.save(domainProperty);
			properties.add(domainProperty);
		}
		provider.setProperties(properties);
		providerDAO.save(provider);
		return provider;
	}
}
