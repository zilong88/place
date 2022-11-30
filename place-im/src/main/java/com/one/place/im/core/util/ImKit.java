package com.one.place.im.core.util;

import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import com.one.place.im.core.packets.ImClientNode;
import java.util.Objects;

public class ImKit {
  /**
   * 设置Client对象到ImSessionContext中
   * @param channelContext 通道上下文
   * @return 客户端Node信息
   * @author: WChao
   */
  public static ImClientNode initImClientNode(ImChannelContext channelContext) {
    ImSessionContext imSessionContext = channelContext.getSessionContext();
    ImClientNode imClientNode = imSessionContext.getImClientNode();
    if(Objects.nonNull(imClientNode)){
      return imClientNode;
    }
    imClientNode = ImClientNode.newBuilder().id(channelContext.getId()).ip(channelContext.getClientNode().getIp()).port(channelContext.getClientNode().getPort()).build();
    imSessionContext.setImClientNode(imClientNode);
    return imClientNode;
  }
}
