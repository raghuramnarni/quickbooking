package com.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booking.form.ProviderDetailsForm;
import com.booking.modal.Provider;
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
	public @ResponseBody APIResponse list(HttpServletRequest request,
																				HttpServletResponse response) {

		Map<String, Object> data = new HashMap<String, Object>();
		return new Success(data);
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody APIResponse enroll(HttpServletRequest request,
																				HttpServletResponse response, @RequestBody ProviderDetailsForm form) {

		Map<String, Object> data = new HashMap<String, Object>();
		com.booking.domain.Provider provider = providerService.createProvider(form);
		Provider modelProvider = new Provider(provider);
		data.put("provider", modelProvider);
		return new Success(data);
	}

}
