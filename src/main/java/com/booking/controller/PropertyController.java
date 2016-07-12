package com.booking.controller;

import com.booking.dao.ProviderDAO;
import com.booking.domain.Provider;
import com.booking.form.PropertyPhotoUploadForm;
import com.booking.form.ProviderSearchForm;
import com.booking.modal.ProviderResponse;
import com.booking.response.APIResponse;
import com.booking.response.Success;
import com.booking.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	APIResponse uploadPhoto(PropertyPhotoUploadForm form) {
		Map<String, Object> data = new HashMap<String, Object>();
		propertyService.uploadPhotos(form.getFile(), form.getPropertyId());
		return new Success(data);
	}

	/**
	 * Upload document
	 */
	@RequestMapping(value = "/uploadDocument", method = RequestMethod.POST)
	public @ResponseBody
	APIResponse uploadDocuments(PropertyPhotoUploadForm form) {
		Map<String, Object> data = new HashMap<String, Object>();
		propertyService.uploadDocuments(form.getFile(), form.getPropertyId());
		return new Success(data);
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	APIResponse providerDetails(HttpServletRequest request,
										 HttpServletResponse response, @RequestBody ProviderSearchForm form) {

		Map<String, Object> data = new HashMap<String, Object>();
		ProviderDAO dao = new ProviderDAO();
		Provider provider = dao.find(form.getProviderId());
		ProviderResponse modelProvider = new ProviderResponse(provider);
		data.put("provider", modelProvider);
		return new Success(data);
	}


}
