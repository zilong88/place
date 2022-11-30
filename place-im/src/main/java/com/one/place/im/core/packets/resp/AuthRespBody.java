package com.one.place.im.core.packets.resp;

import com.one.place.im.core.packets.Message;

public class AuthRespBody extends Message {

  private static final long serialVersionUID = -7795510908118183511L;
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
