package com.one.place.im.core.exception;

public class ImException extends RuntimeException{

  private static final long serialVersionUID = -1258368195047283776L;

  /**
   * @Author WChao
   * @Description //TODO
   * @param
   * @return
   **/
  public ImException() {
  }

  /**
   * @Author WChao
   * @Description //TODO
   * @param message
   * @return
   **/
  public ImException(String message) {
    super(message);

  }

  /**
   * @Author WChao
   * @Description //TODO
   * @param message, cause
   * @return
   **/
  public ImException(String message, Throwable cause) {
    super(message, cause);

  }

  /**
   * @Author WChao
   * @Description //TODO
   * @param message, cause, enableSuppression, writableStackTrace
   * @return
   **/
  public ImException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

  /**
   * @Author WChao
   * @Description //TODO
   * @param cause
   * @return
   **/
  public ImException(Throwable cause) {
    super(cause);

  }
}
