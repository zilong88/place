package com.one.place.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class UserTokenDto implements Serializable {
  private static final long serialVersionUID = 6903703680600115183L;

  @JsonProperty("createTime")
  private Long createTime;
  private UserInfoDto data;

  @JsonProperty("refreshTime")
  private Long refreshTime;
  @JsonProperty("userKey")
  private Long userKey;
  private String uuid;

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public UserInfoDto getData() {
    return data;
  }

  public void setData(UserInfoDto data) {
    this.data = data;
  }

  public Long getRefreshTime() {
    return refreshTime;
  }

  public void setRefreshTime(Long refreshTime) {
    this.refreshTime = refreshTime;
  }

  public Long getUserKey() {
    return userKey;
  }

  public void setUserKey(Long userKey) {
    this.userKey = userKey;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
