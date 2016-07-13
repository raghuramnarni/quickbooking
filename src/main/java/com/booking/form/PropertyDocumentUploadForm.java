package com.booking.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by raghuramn on 7/8/16.
 */
public class PropertyDocumentUploadForm {

	MultipartFile file;
	@NotNull(message = "Please enter propertyId")
	Long propertyId;

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
