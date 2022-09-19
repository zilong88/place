package com.one.place.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UserInfoDto implements Serializable {

  private static final long serialVersionUID = 954148322877916332L;
  @ApiModelProperty("用户id")
  private Long id;
  @ApiModelProperty("昵称")
  private String nickName;
  @ApiModelProperty("头像")
  private String avatar;
  @ApiModelProperty("邀请码")
  private String inviteCode;
  @ApiModelProperty("微信open id")
  private String openId;
  private String account;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getInviteCode() {
    return inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }
}
