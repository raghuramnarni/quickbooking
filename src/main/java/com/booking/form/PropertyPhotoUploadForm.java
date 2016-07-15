package com.booking.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by raghuramn on 7/8/16.
 */
public class PropertyPhotoUploadForm {

	MultipartFile[] propertyPics;
	@NotNull(message = "Please enter propertyId")
	Long propertyId;

	public MultipartFile[] getPropertyPics() {
		return propertyPics;
	}

	public void setPropertyPics(MultipartFile[] propertyPics) {
		this.propertyPics = propertyPics;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
}
