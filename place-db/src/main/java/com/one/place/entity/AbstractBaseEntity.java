package com.one.place.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

public abstract class AbstractBaseEntity {
  /**
   * 主键
   */
  @TableId(value = "f_id", type = IdType.AUTO)
  private Long id;

  /**
   * 乐观锁主键
   */
  @TableField("f_version")
  @Version
  private Long version;

  /**
   * 创建时间
   */
  @TableField(value = "f_created_at", fill = FieldFill.INSERT)
  private Long createdAt;

  /**
   * 更新时间
   */
  @TableField(value = "f_updated_at", fill = FieldFill.INSERT_UPDATE)
  private Long updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public Long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }
}
