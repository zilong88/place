package com.one.place.im.core.packets.resp;

import com.one.place.im.core.packets.ImUser;
import com.one.place.im.core.packets.Message;

public class ExitGroupNotifyRespBody extends Message {

  private static final long serialVersionUID = -7227620108910280314L;
  private ImUser user;
  private String group;

  public ImUser getUser() {
    return user;
  }
  public ExitGroupNotifyRespBody setUser(ImUser user) {
    this.user = user;
    return this;
  }
  public String getGroup() {
    return group;
  }
  public ExitGroupNotifyRespBody setGroup(String group) {
    this.group = group;
    return this;
  }
}
