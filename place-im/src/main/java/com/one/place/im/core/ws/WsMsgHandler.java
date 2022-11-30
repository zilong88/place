package com.one.place.im.core.ws;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;

public interface WsMsgHandler {
  /**
   *
   * @param packet
   * @param imChannelContext
   * @return
   *
   * @author: WChao
   * 2016年11月18日 下午1:08:45
   *
   */
  ImPacket handler(ImPacket packet, ImChannelContext imChannelContext)  throws Exception;
  /**
   * @param wsPacket
   * @param text
   * @param imChannelContext
   * @return 可以是WsResponsePacket、byte[]、ByteBuffer、String或null，如果是null，框架不会回消息
   * @throws Exception
   * @author: WChao
   */
  Object onText(WsRequestPacket wsPacket, String text, ImChannelContext imChannelContext) throws Exception;

  /**
   *
   * @param webSocketPacket
   * @param bytes
   * @param channelContext
   * @return 可以是WsResponsePacket、byte[]、ByteBuffer、String或null，如果是null，框架不会回消息
   * @throws Exception
   * @author: WChao
   */
  Object onClose(WsRequestPacket webSocketPacket, byte[] bytes, ImChannelContext channelContext) throws Exception;

  /**
   *
   * @param webSocketPacket
   * @param bytes
   * @param imChannelContext
   * @return 可以是WsResponsePacket、byte[]、ByteBuffer、String或null，如果是null，框架不会回消息
   * @throws Exception
   * @author: WChao
   */
  Object onBytes(WsRequestPacket webSocketPacket, byte[] bytes, ImChannelContext imChannelContext) throws Exception;
}
