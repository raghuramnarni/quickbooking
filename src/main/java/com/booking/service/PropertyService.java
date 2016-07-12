package com.booking.service;

import com.booking.domain.Property;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 6/25/16.
 */
public interface PropertyService {

	//public Property createProperty();
	public void uploadPhotos(MultipartFile file, Long propertyId);
	public void uploadDocuments(MultipartFile file, Long propertyId);

}
