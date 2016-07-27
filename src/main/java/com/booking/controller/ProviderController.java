package com.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.ProviderDAO;
import com.booking.domain.Provider;
import com.booking.form.ProviderPhotoUploadForm;
import com.booking.form.ProviderSearchForm;
import com.booking.response.*;
import com.booking.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.booking.form.ProviderEnrollmentForm;
import com.booking.modal.ProviderResponse;
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
			HttpServletResponse response, @RequestBody @javax.validation.Valid ProviderEnrollmentForm form,
			BindingResult result) {
		if(result.hasErrors()){
			return new Failure(ResponseStatus.Status.FAIL, result);
		}

		ProviderDAO providerDAO = new ProviderDAO();
		if(providerDAO.findByEmail(form.getEmail()) != null){
			return new Failure(ResponseStatus.Status.FAIL, "This email is already exists");
		}

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
	APIResponse uploadFileHandler(HttpServletRequest request,
																HttpServletResponse response, @javax.validation.Valid ProviderPhotoUploadForm form,
																BindingResult result) {
		if(result.hasErrors()){
			return new Failure(ResponseStatus.Status.FAIL, result);
		}
		Map<String, Object> data = new HashMap<String, Object>();
		providerService.createProviderPhoto(form.getProviderPic(), form.getProviderId());
		return new Success(data);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	APIResponse providerDetails(HttpServletRequest request,
										 HttpServletResponse response, @RequestBody @javax.validation.Valid ProviderSearchForm form) {

		Map<String, Object> data = new HashMap<String, Object>();
		ProviderDAO dao = new ProviderDAO();
		Provider provider = dao.findByEmailAndPassword(form.getEmail(), form.getPassword());
		ProviderResponse modelProvider = new ProviderResponse(provider);
		data.put("provider", modelProvider);
		return new Success(data);
	}


}
