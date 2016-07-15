package com.booking.service.impl;

import com.booking.dao.ProviderDAO;
import com.booking.dao.ProviderImageFileDAO;
import com.booking.domain.Provider;
import com.booking.domain.ProviderImageFile;
import com.booking.form.ProviderEnrollmentForm;
import com.booking.service.ProviderService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;

import com.booking.dao.PropertyDAO;
import com.booking.modal.Property;

import com.booking.util.PhotoUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 6/22/16.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

	@SuppressWarnings("unchecked")
	@Override
	public Provider createProvider(ProviderEnrollmentForm form){
		Provider provider = new Provider(form);
		ProviderDAO providerDAO = new ProviderDAO();
		HashSet<com.booking.domain.Property> properties = new HashSet<com.booking.domain.Property>();
		providerDAO.save(provider);
		for(Property property : form.getProperties()){
			com.booking.domain.Property domainProperty = new com.booking.domain.Property(property);
			PropertyDAO propertyDAO = new PropertyDAO();
			domainProperty.setProvider(provider);
			propertyDAO.save(domainProperty);
			properties.add(domainProperty);
		}
		provider.setProperties(properties);
		providerDAO.saveOrUpdate(provider);
		return provider;
	}

	@Override
	public ProviderImageFile createProviderPhoto(MultipartFile file, long providerId){
		if (!file.isEmpty()) {
			try {

				// Create the file on server
				File serverFile = PhotoUtil.uploadPhoto(file, providerId);

				ProviderDAO providerDAO = new ProviderDAO();
				Provider provider = providerDAO.find(providerId);
				ProviderImageFile imageFile = new ProviderImageFile(file.getName(), serverFile.getPath(), provider);
				ProviderImageFileDAO providerImageFileDAO = new ProviderImageFileDAO();
				providerImageFileDAO.save(imageFile);
				return imageFile;
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		} else {
			return null;
		}
		return null;
	}
}
