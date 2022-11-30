package com.one.place.im.core.packets;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable {

  private static final long serialVersionUID = -5672863245415598204L;

  protected Long createTime;
  /**
   * 全局唯一id
   */
  protected String id;

  protected Integer cmd;

  protected Map<String, Object> extras;

  public abstract static class Builder<T extends Message,B extends Message.Builder<T,B>>{
    protected Long createTime;
    /**
     * 全局唯一id
     */
    protected String id;

    protected Integer cmd;

    protected Map<String, Object> extras;

    private B theBuilder = this.getThis();

    /**
     * 供子类获取自身builder抽象类;
     * @return
     */
    protected abstract B getThis();

    public B setCreateTime(Long createTime) {
      this.createTime = createTime;
      return theBuilder;
    }
    public B setId(String id) {
      this.id = id;
      return theBuilder;
    }
    public B setCmd(Integer cmd) {
      this.cmd = cmd;
      return theBuilder;
    }
    public B addExtra(String key , Object value) {
      if (null == value) {
        return theBuilder;
      } else {
        if (null == extras) {
          this.extras = new HashMap<>();
        }
        this.extras.put(key, value);
        return theBuilder;
      }
    }

    /**
     * 供子类实现的抽象构建对象
     * @return
     */
    public abstract T build();
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getCmd() {
    return cmd;
  }

  public void setCmd(Integer cmd) {
    this.cmd = cmd;
  }

  public Map<String, Object> getExtras() {
    return extras;
  }

  public void setExtras(Map<String, Object> extras) {
    this.extras = extras;
  }
}
