package com.booking.service;

import com.booking.domain.Provider;
import com.booking.domain.ProviderImageFile;
import com.booking.form.ProviderEnrollmentForm;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 6/22/16.
 */
public interface ProviderService {

	public Provider createProvider(ProviderEnrollmentForm form);

	public ProviderImageFile createProviderPhoto(MultipartFile file, long providerId);
}
