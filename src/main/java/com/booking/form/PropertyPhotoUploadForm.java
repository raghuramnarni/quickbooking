package com.booking.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 7/8/16.
 */
public class PropertyPhotoUploadForm {

	MultipartFile file;
	long propertyId;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
}
