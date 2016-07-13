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
    getErrorsFromFieldErrors(errors);
    getGlobalErrors(errors);
  }

  /**
   * @param errors
   */
  private void getErrorsFromFieldErrors(org.springframework.validation.Errors errors) {
    if(errors != null){
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      // multiple such fields in a bean, hence ArrayList
      this.errors = new ArrayList<Map<String, List<String>>>();
      for(Iterator<FieldError> iterator = errors.getFieldErrors().iterator(); iterator
              .hasNext(); ){
        FieldError error = (FieldError) iterator.next();
        List<String> list = map.get(error.getField());
        if(list == null){
          list = new ArrayList<String>();
        }

        String message = buildMessageFromError(error);
        if(message!=null){
          list.add(message);
        }
        map.put(error.getField(), list);
      }
      this.errors.add(map);
    }
  }

  private String buildMessageFromError(ObjectError error){
    if(error!=null){
      // build error message from error code and message arguments
      if(error.getCode() != null){
        String errorMessage = error.getDefaultMessage();
        if(errorMessage != null && !errorMessage.equals(error.getCode())){
          return errorMessage;
        }
      }
      // error message is not built, use default message or use error code
      if(error.getDefaultMessage() != null){
        return error.getDefaultMessage();
      } else{
        return error.getCode();
      }
    }
    return null;

  }

  private void getGlobalErrors(org.springframework.validation.Errors errors) {
    if(errors != null){
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      // multiple such fields in a bean, hence ArrayList
      if(this.errors == null){
        this.errors = new ArrayList<Map<String, List<String>>>();
      }
      List<String> list = new ArrayList<String>();
      for(Iterator<ObjectError> iterator = errors.getGlobalErrors().iterator(); iterator.hasNext(); ){
        ObjectError error = iterator.next();
        boolean messageSet = false;
        String message = buildMessageFromError(error);
        // build error message from error code and message arguments
        if(message != null){
          list.add(message);
        }
      }
      // global errors are on request/object level. GLOBAL_ERROR key is just our name convention
      map.put(GLOBAL_ERROR, list);
      this.errors.add(map);
    }
  }


}
