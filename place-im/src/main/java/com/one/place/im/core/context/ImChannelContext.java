package com.one.place.im.core.context;

import com.one.place.im.config.ImConfig;
import com.one.place.im.core.ImConst;
import org.tio.core.ChannelContext;
import org.tio.core.Node;
import org.tio.utils.prop.MapWithLockPropSupport;

public abstract class ImChannelContext extends MapWithLockPropSupport implements ImConst {

  private ImConfig imConfig;

  private ChannelContext tioChannelContext;

  public ImChannelContext(ImConfig imConfig,ChannelContext tioChannelContext){
    this.imConfig = imConfig;
    this.tioChannelContext = tioChannelContext;
  }


  public ImConfig getImConfig() {
    return imConfig;
  }

  public void setImConfig(ImConfig imConfig) {
    this.imConfig = imConfig;
  }

  public ChannelContext getTioChannelContext() {
    return tioChannelContext;
  }

  public void setTioChannelContext(ChannelContext tioChannelContext) {
    this.tioChannelContext = tioChannelContext;
  }

  public void setSessionContext(ImSessionContext imSessionContext){
    this.setAttribute(Key.IM_CHANNEL_SESSION_CONTEXT_KEY, imSessionContext);
  }

  public ImSessionContext getSessionContext(){
    return (ImSessionContext)this.getAttribute(Key.IM_CHANNEL_SESSION_CONTEXT_KEY);
  }

  public String getId() {
    return tioChannelContext.getId();
  }

  public Node getClientNode(){
    return tioChannelContext.getClientNode();
  }

  public void setPacketNeededLength(Integer packetNeededLength) {
    this.tioChannelContext.setPacketNeededLength(packetNeededLength);
  }

  public String getUserId(){
    return tioChannelContext.userid;
  }

  public void setUserId(String userId){
    tioChannelContext.setUserid(userId);
  }


}
