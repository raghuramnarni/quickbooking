package com.booking.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 7/8/16.
 */
public class ProviderPhotoUploadForm {

	MultipartFile providerPic;

	@NotEmpty(message = "Please enter propertyId")
	Long providerId;

	public MultipartFile getProviderPic() {
		return providerPic;
	}

	public void setProviderPic(MultipartFile providerPic) {
		this.providerPic = providerPic;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
}
