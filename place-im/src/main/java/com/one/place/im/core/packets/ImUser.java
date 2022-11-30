package com.one.place.im.core.packets;

import java.io.Serializable;
import java.util.List;

public class ImUser implements Serializable {

  private static final long serialVersionUID = 2521782056488841135L;
  private String userId;
  private String nick;
  private String avatar;
  private String status ;

  /**
   * 个性签名;
   */
  private String sign;
  /**
   * 用户所属终端;(ws、tcp、http、android、ios等)
   */
  private String terminal;
  /**
   * 好友列表;
   */
  private List<Group> friends;
  /**
   * 群组列表;
   */
  private List<Group> groups;
}
