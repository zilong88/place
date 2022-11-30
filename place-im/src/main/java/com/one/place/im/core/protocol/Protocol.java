package com.one.place.im.core.protocol;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import java.nio.ByteBuffer;

public interface Protocol {
  /**
   * 协议名称
   * @return 如:http、ws、tcp等
   */
  String name();

  /**
   * 根据buffer判断是否属于指定协议
   * @param buffer
   * @param imChannelContext
   * @return
   * @throws Exception
   */
  boolean isProtocol(ByteBuffer buffer, ImChannelContext imChannelContext) throws Exception;

  /**
   * 根据imPacket判断是否属于指定协议
   * @param imPacket
   * @param imChannelContext
   * @return
   * @throws Exception
   */
  boolean isProtocol(ImPacket imPacket, ImChannelContext imChannelContext)throws Exception;
}
