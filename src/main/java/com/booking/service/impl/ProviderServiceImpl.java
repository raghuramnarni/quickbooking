package com.booking.service.impl;

import com.booking.domain.Provider;
import com.booking.form.ProviderDetailsForm;
import com.booking.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * Created by raghuramn on 6/22/16.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

	@Override
	public Provider createProvider(ProviderDetailsForm form){
		Provider provider = new Provider(form);
		return provider;
	}
}
