package com.one.place.im.core.protocol;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.enums.Command;

public interface ProtocolConverter {
  /**
   * 转化请求包
   * @param body
   * @param command
   * @param imChannelContext
   * @return
   */
  ImPacket ReqPacket(byte[] body, Command command, ImChannelContext imChannelContext);
  /**
   * 转化响应包
   * @param body
   * @param command
   * @param imChannelContext
   * @return
   */
  ImPacket RespPacket(byte[] body, Command command, ImChannelContext imChannelContext);

  /**
   * 转化响应包
   * @param imPacket
   * @param command
   * @param imChannelContext
   * @return
   */
  ImPacket RespPacket(ImPacket imPacket, Command command, ImChannelContext imChannelContext);
}
