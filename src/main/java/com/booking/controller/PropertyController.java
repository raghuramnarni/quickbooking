package com.booking.controller;

import com.booking.form.PropertyDocumentUploadForm;
import com.booking.form.PropertyPhotoUploadForm;
import com.booking.response.APIResponse;
import com.booking.response.Failure;
import com.booking.response.ResponseStatus;
import com.booking.response.Success;
import com.booking.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghuramn on 6/17/16.
 */
@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;


	/**
	 * Upload photo
	 */
	@RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
	public @ResponseBody
	APIResponse uploadPhoto(HttpServletRequest request,
													HttpServletResponse response, @javax.validation.Valid PropertyPhotoUploadForm form,
													BindingResult result) {
		Map<String, Object> data = new HashMap<String, Object>();
		if(result.hasErrors()){
			return new Failure(ResponseStatus.Status.FAIL, result);
		}
		for(MultipartFile file : form.getPropertyPics()){
			propertyService.uploadPhotos(file, form.getPropertyId());
		}
		return new Success(data);
	}

	/**
	 * Upload document
	 */
	@RequestMapping(value = "/uploadDocument", method = RequestMethod.POST)
	public @ResponseBody
	APIResponse uploadDocuments(HttpServletRequest request,
															HttpServletResponse response, @javax.validation.Valid PropertyDocumentUploadForm form,
															BindingResult result) {

		if(result.hasErrors()){
			return new Failure(ResponseStatus.Status.FAIL, result);
		}

		Map<String, Object> data = new HashMap<String, Object>();
		for(MultipartFile file : form.getFiles()){
			propertyService.uploadDocuments(file, form.getPropertyId());
		}
		return new Success(data);
	}

}
