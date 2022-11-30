package com.one.place.im.core.http.session;

import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import com.one.place.im.core.http.HttpConfig;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpSession extends ImSessionContext implements Serializable {

  private static final long serialVersionUID = 8122648527681777585L;

  private Map<String, Serializable> data = new ConcurrentHashMap<>();

  public HttpSession(String id){
    this(id, null);
  }

  public HttpSession(ImChannelContext imChannelContext){
    this(null, imChannelContext);
  }

  public HttpSession(String id, ImChannelContext imChannelContext){
    super(imChannelContext);
    this.id = id;
  }

  /**
   * 清空所有属性
   * @param httpConfig
   * @author wchao
   */
  public void clear(HttpConfig httpConfig) {
    data.clear();
    httpConfig.getSessionStore().put(id, this);
  }

  /**
   * 获取会话属性
   * @param key
   * @return
   * @author wchao
   */
  public Object getAttribute(String key) {
    return data.get(key);
  }

  public Map<String, Serializable> getData() {
    return data;
  }

  /**
   *
   * @param key
   * @param httpConfig
   * @author wchao
   */
  public void removeAttribute(String key, HttpConfig httpConfig) {
    data.remove(key);
    httpConfig.getSessionStore().put(id, this);
  }

  /**
   * 设置会话属性
   * @param key
   * @param value
   * @param httpConfig
   * @author wchao
   */
  public void setAttribute(String key, Serializable value, HttpConfig httpConfig) {
    data.put(key, value);
    httpConfig.getSessionStore().put(id, this);
  }

  public void setData(Map<String, Serializable> data) {
    this.data = data;
  }
}
