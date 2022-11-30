package com.one.place.im.core.exception;

public class ImDecodeException extends ImException{

  private static final long serialVersionUID = 3989473011642978242L;

  public ImDecodeException(Throwable e) {
    super(e);
  }

  public ImDecodeException(String message) {
    super(message);

  }
}
