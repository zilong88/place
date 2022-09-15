package com.one.place.exceptions;

import com.one.place.enums.ApiErrors;

public class ApiException extends RuntimeException{
  private static final long serialVersionUID = 5710943804942607092L;
  private static final Object[] EMPTY_ARGS_HOLDER = {};

  private final ApiErrors error;

  private Object[] argsHolder = EMPTY_ARGS_HOLDER;

  public ApiException(ApiErrors error) {
    this.error = error;
  }

  public ApiException(ApiErrors error, Object... params) {
    this.argsHolder = params;
    this.error = error;
  }

  public ApiException(ApiErrors error, Throwable t) {
    super(t);
    this.error = error;
  }

  public ApiErrors getError(){
    return error;
  }

  public Object[] getArgsHolder(){
    return argsHolder;
  }

}
