package com.one.place.im.core.packets.req;

import com.one.place.im.core.packets.Message;

public class UserReqBody extends Message {

  private static final long serialVersionUID = -7148504080280932855L;
  /**
   * 用户id;
   */
  private String userId;
  /**
   * 0:单个,1:所有在线用户,2:所有用户(在线+离线);
   */
  private Integer type;
  /**
   * 好友分组id;
   */
  private String friendGroupId;
  /**
   * 群组id;
   */
  private String groupId;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getFriendGroupId() {
    return friendGroupId;
  }

  public void setFriendGroupId(String friendGroupId) {
    this.friendGroupId = friendGroupId;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }
}
