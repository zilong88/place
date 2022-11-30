package com.one.place.im.core.packets.resp;

import com.one.place.im.core.Status;
import com.one.place.im.core.enums.Command;
import com.one.place.im.core.enums.ImStatus;
import com.one.place.im.core.packets.ImUser;
import com.one.place.im.core.packets.RespBody;

public class LoginRespBody extends RespBody {

  private static final long serialVersionUID = 9054569215005246842L;
  private String token;
  private ImUser user;

  public LoginRespBody(){
    this.setCommand(Command.COMMAND_LOGIN_RESP);
  }

  public LoginRespBody(Status status){
    this(status,null);
  }

  public LoginRespBody(Status status , ImUser user){
    this(status, user, null);
  }

  public LoginRespBody(Status status , ImUser user, String token){
    super(Command.COMMAND_LOGIN_RESP, status);
    this.user = user;
    this.token = token;
  }

  public ImUser getUser() {
    return user;
  }

  public void setUser(ImUser user) {
    this.user = user;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public static LoginRespBody success(){
    return new LoginRespBody(ImStatus.C10007);
  }

  public static LoginRespBody failed(){
    return new LoginRespBody(ImStatus.C10008);
  }

  public static LoginRespBody failed(String msg){
    LoginRespBody loginRespBody = new LoginRespBody(ImStatus.C10008);
    loginRespBody.setMsg(msg);
    return loginRespBody;
  }
}
