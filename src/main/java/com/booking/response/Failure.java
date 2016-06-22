/*
 * Copyright 2006-2010 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package com.booking.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.*;

/**
 * 
 * Created 31-Mar-2013 8:15:54 PM
 * 
 * @author skumardk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Failure extends APIResponse {

  private static final String GLOBAL_ERROR = "GLOBAL_ERROR";

  @JsonProperty
  private String errorAlert;
  @JsonProperty
  private List<Map<String, List<String>>> errors;
  /*
   * This is for developer purpose only. In case there is an exception, developer would be
   * able to see exception stack trace. Not used in front end.
   */
  @JsonProperty
  private String exceptionStackTrace;

  /**
   * @param bindingResult
   */
  public Failure(BindingResult bindingResult) {
    super(ResponseStatus.Status.FAIL);
  }

  /**
   * @param status
   * @param errors
   */
  public Failure(ResponseStatus.Status status, org.springframework.validation.Errors errors) {
    super(status);
  }

}
