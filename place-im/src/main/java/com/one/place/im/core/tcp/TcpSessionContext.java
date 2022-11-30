package com.one.place.im.core.tcp;

import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;

public class TcpSessionContext extends ImSessionContext {
  public TcpSessionContext(ImChannelContext imChannelContext){
    super(imChannelContext);
  }
}
