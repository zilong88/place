package com.one.place.im.core.ws;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import com.one.place.im.core.enums.Command;
import com.one.place.im.core.protocol.ProtocolConverter;

public class WsConvertPacket implements ProtocolConverter {
  /**
   * WebSocket响应包;
   */
  @Override
  public ImPacket RespPacket(byte[] body, Command command, ImChannelContext channelContext) {
    ImSessionContext sessionContext = channelContext.getSessionContext();
    //转ws协议响应包;
    if(sessionContext instanceof WsSessionContext){
      WsResponsePacket wsResponsePacket = new WsResponsePacket();
      wsResponsePacket.setBody(body);
      wsResponsePacket.setWsOpcode(Opcode.TEXT);
      wsResponsePacket.setCommand(command);
      return wsResponsePacket;
    }
    return null;
  }

  @Override
  public ImPacket RespPacket(ImPacket imPacket, Command command, ImChannelContext imChannelContext) {

    return this.RespPacket(imPacket.getBody(), command, imChannelContext);
  }

  @Override
  public ImPacket ReqPacket(byte[] body, Command command, ImChannelContext channelContext) {

    return null;
  }
}
