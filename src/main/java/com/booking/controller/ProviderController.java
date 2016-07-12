package com.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.ProviderDAO;
import com.booking.domain.Provider;
import com.booking.form.ProviderPhotoUploadForm;
import com.booking.form.ProviderSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.booking.form.ProviderEnrollmentForm;
import com.booking.modal.ProviderResponse;
import com.booking.response.APIResponse;
import com.booking.response.Success;
import com.booking.service.ProviderService;

/**
 * Created by raghuramn on 6/17/16.
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	ProviderService providerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	APIResponse list(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> data = new HashMap<String, Object>();
		return new Success(data);
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	APIResponse enroll(HttpServletRequest request,
			HttpServletResponse response, @RequestBody ProviderEnrollmentForm form) {

		Map<String, Object> data = new HashMap<String, Object>();
		Provider provider = providerService
				.createProvider(form);
		ProviderResponse modelProvider = new ProviderResponse(provider);
		data.put("provider", modelProvider);
		return new Success(data);
	}

	/**
	 * Upload single file
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	APIResponse uploadFileHandler(ProviderPhotoUploadForm form) {
		Map<String, Object> data = new HashMap<String, Object>();
		providerService.createProviderPhoto(form.getFile(), form.getProviderId());
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
