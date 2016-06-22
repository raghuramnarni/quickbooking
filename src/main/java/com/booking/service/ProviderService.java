package com.booking.service;

import com.booking.domain.Provider;
import com.booking.form.ProviderDetailsForm;

/**
 * Created by raghuramn on 6/22/16.
 */
public interface ProviderService {

	public Provider createProvider(ProviderDetailsForm form);
}
