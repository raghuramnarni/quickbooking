package com.booking.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 7/8/16.
 */
public class PropertyDocumentUploadForm {

	MultipartFile file;
	long providerId;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
}
