package com.booking.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Created by raghuramn on 6/17/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {

	@JsonProperty
	private int statusCode;
	@JsonProperty
	private String status;

	public APIResponse(ResponseStatus.Status status) {
		this.status = status.name();
		this.statusCode = ResponseStatus.getStatusCodeByStatus(status);
	}
}
