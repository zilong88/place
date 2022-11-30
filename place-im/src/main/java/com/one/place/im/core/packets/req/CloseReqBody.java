package com.one.place.im.core.packets.req;

import com.one.place.im.core.packets.Message;

public class CloseReqBody extends Message {

  private static final long serialVersionUID = 3805866186754344040L;

  public CloseReqBody(){}

  public CloseReqBody(String userId){
    this.userId = userId;
  }

  /**
   * 用户ID
   */
  private String userId;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
