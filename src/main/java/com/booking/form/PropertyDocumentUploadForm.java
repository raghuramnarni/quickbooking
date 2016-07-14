package com.booking.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by raghuramn on 7/8/16.
 */
public class PropertyDocumentUploadForm {

	MultipartFile certificate;
	MultipartFile serviceTax;
	MultipartFile panCard;
	MultipartFile aadharCard;
	@NotNull(message = "Please enter propertyId")
	Long propertyId;


	public long getPropertyId() {
		return propertyId;
	}

	public MultipartFile getCertificate() {
		return certificate;
	}

	public void setCertificate(MultipartFile certificate) {
		this.certificate = certificate;
	}

	public MultipartFile getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(MultipartFile serviceTax) {
		this.serviceTax = serviceTax;
	}

	public MultipartFile getPanCard() {
		return panCard;
	}

	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}

	public MultipartFile getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public MultipartFile[] getFiles(){
		MultipartFile[] files = new MultipartFile[4];
		files[0] = this.getCertificate();
		files[1] = this.getServiceTax();
		files[2] = this.getPanCard();
		files[3] = this.getAadharCard();
		return files;
	}


}
