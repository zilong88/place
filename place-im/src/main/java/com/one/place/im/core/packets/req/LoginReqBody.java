package com.one.place.im.core.packets.req;

import com.one.place.im.core.enums.Command;
import com.one.place.im.core.packets.Message;

public class LoginReqBody extends Message {

  private static final long serialVersionUID = -9072518677767568615L;

  /**
   * 用户Id
   */
  private String userId;
  /**
   * 密码
   */
  private String password;
  /**
   * 登陆token
   */
  private String token;

  public LoginReqBody(){}

  public LoginReqBody(String token){
    this.token = token;
    this.cmd = Command.COMMAND_LOGIN_REQ.getNumber();
  }

  public LoginReqBody(String userId,String password){
    this.userId = userId;
    this.password = password;
    this.cmd = Command.COMMAND_LOGIN_REQ.getNumber();
  }

  public LoginReqBody(String userId,String password,String token){
    this(userId,password);
    this.token = token;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
