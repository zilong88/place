package com.one.place.im.core.packets.req;

import com.one.place.im.core.packets.Message;

public class AuthReqBody extends Message {

  private static final long serialVersionUID = -8872861808666020860L;

  private String token;//token验证;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
