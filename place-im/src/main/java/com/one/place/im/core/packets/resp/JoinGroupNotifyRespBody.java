package com.one.place.im.core.packets.resp;

import com.one.place.im.core.Status;
import com.one.place.im.core.enums.Command;
import com.one.place.im.core.enums.ImStatus;
import com.one.place.im.core.packets.ImUser;
import com.one.place.im.core.packets.RespBody;

public class JoinGroupNotifyRespBody extends RespBody {

  private static final long serialVersionUID = -8596668537347042521L;

  private ImUser user;
  private String group;

  public JoinGroupNotifyRespBody(){
    super(Command.COMMAND_JOIN_GROUP_NOTIFY_RESP, null);
  }

  public JoinGroupNotifyRespBody(Integer code, String msg){
    super(Command.COMMAND_JOIN_GROUP_NOTIFY_RESP, null);
    this.code = code;
    this.msg = msg;
  }

  public JoinGroupNotifyRespBody(Status status){
    super(Command.COMMAND_JOIN_GROUP_NOTIFY_RESP,status);
  }

  public JoinGroupNotifyRespBody(Command command, Status status){
    super(command,status);
  }
  public ImUser getUser() {
    return user;
  }

  public JoinGroupNotifyRespBody setUser(ImUser user) {
    this.user = user;
    return this;
  }
  public String getGroup() {
    return group;
  }

  public JoinGroupNotifyRespBody setGroup(String group) {
    this.group = group;
    return this;
  }

  public static JoinGroupNotifyRespBody success(){
    return new JoinGroupNotifyRespBody(ImStatus.C10011);
  }

  public static JoinGroupNotifyRespBody failed(){
    return new JoinGroupNotifyRespBody(ImStatus.C10012);
  }
}
