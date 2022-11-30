package com.one.place.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author place
 * @since 2022-09-19
 */
@TableName("t_user")
public class User extends AbstractBaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;


  /**
   * 用户头像URL
   */
  @TableField("f_avatar")
  private String avatar;

  /**
   * 昵称
   */
  @TableField("f_nick_name")
  private String nickName;

  /**
   * 手机号
   */
  @TableField("f_cell_phone")
  private String cellPhone;

  /**
   * 登录密码
   */
  @TableField("f_password")
  private String password;

  /**
   * 实名状态（0：未审核；1：审核中；2：已通过）
   */
  @TableField("f_kyc_status")
  private Integer kycStatus;

  /**
   * 用户类型 1:普通 2:系统手续费接收人
   */
  @TableField("f_type")
  private Integer type;


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Integer getKycStatus() {
    return kycStatus;
  }

  public void setKycStatus(Integer kycStatus) {
    this.kycStatus = kycStatus;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "User{" +
        "id = " + super.getId() +
        ", version = " + super.getVersion() +
        ", createdAt = " + super.getCreatedAt() +
        ", updatedAt = " + super.getUpdatedAt() +
        ", avatar = " + avatar +
        ", nickName = " + nickName +
        ", cellPhone = " + cellPhone +
        ", password = " + password +
        ", kycStatus = " + kycStatus +
        ", type = " + type +
        "}";
  }
}
