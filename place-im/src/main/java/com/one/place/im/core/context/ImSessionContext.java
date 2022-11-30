package com.one.place.im.core.context;

import com.one.place.im.core.packets.ImClientNode;
import org.tio.monitor.RateLimiterWrap;

/**
 * IM会话上下文信息
 */
public class ImSessionContext {
  /**
   * 消息请求频率控制器
   */
  private RateLimiterWrap requestRateLimiter = null;
  /**
   * 客户端Node信息
   */
  private ImClientNode imClientNode = null;
  /**
   * 客户端票据token,一般业务设置用
   */
  private String token = null;
  /**
   * 所属通道上下文
   */
  private ImChannelContext imChannelContext;
  /**
   * sessionContext唯一ID
   */
  protected String id;


  public ImSessionContext(){}

  public ImSessionContext(ImChannelContext imChannelContext){
    this.imChannelContext = imChannelContext;
  }

  public RateLimiterWrap getRequestRateLimiter() {
    return requestRateLimiter;
  }

  public void setRequestRateLimiter(RateLimiterWrap requestRateLimiter) {
    this.requestRateLimiter = requestRateLimiter;
  }

  public ImClientNode getImClientNode() {
    return imClientNode;
  }

  public void setImClientNode(ImClientNode imClientNode) {
    this.imClientNode = imClientNode;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ImChannelContext getImChannelContext() {
    return imChannelContext;
  }

  public void setImChannelContext(ImChannelContext imChannelContext) {
    this.imChannelContext = imChannelContext;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
