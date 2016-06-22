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

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Created 31-Mar-2013 8:15:30 PM
 * 
 * @author skumardk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Success extends APIResponse {

  @JsonProperty
  private Map<String, Object> data;
  public static final Success EMPTY = new Success();

  /**
   * Constructor for success response with status and data.
   * 
   * @param status
   * @param data
   */
  public Success(Map<String, Object> data) {
    super(ResponseStatus.Status.OK);
    this.data = data;
  }

  /**
   * Empty success response
   */
  public Success() {
    super(ResponseStatus.Status.OK);
    this.data = new HashMap<String, Object>();
  }
}
