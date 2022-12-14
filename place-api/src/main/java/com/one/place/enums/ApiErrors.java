package com.one.place.enums;

/**
 * APi 错误
 */
public enum ApiErrors {

  /**
   * 未知错误
   */
  UNKNOWN_ERROR,
  /**
   * 参数错误
   */
  BAD_ARGUMENT_ERROR,
  /**
   * 必须登录
   */
  MUST_LOGIN,

  SYSTEM_ERROR;


  public String getErrorMsgCode() {
    return name();
  }
}
