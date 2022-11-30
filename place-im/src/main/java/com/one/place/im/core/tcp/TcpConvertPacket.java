package com.one.place.im.core.tcp;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import com.one.place.im.core.enums.Command;
import com.one.place.im.core.protocol.ProtocolConverter;

public class TcpConvertPacket implements ProtocolConverter {
  /**
   * 转TCP协议响应包;
   */
  @Override
  public ImPacket RespPacket(byte[] body, Command command, ImChannelContext imChannelContext) {
    ImSessionContext sessionContext = imChannelContext.getSessionContext();
    if(sessionContext instanceof TcpSessionContext){
      TcpPacket tcpPacket = new TcpPacket(command,body);
      TcpServerEncoder.encode(tcpPacket, imChannelContext.getImConfig(), imChannelContext);
      tcpPacket.setCommand(command);
      return tcpPacket;
    }
    return null;
  }

  @Override
  public ImPacket RespPacket(ImPacket imPacket, Command command, ImChannelContext imChannelContext) {

    return this.RespPacket(imPacket.getBody(), command, imChannelContext);
  }

  /**
   * 转TCP协议请求包;
   */
  @Override
  public ImPacket ReqPacket(byte[] body, Command command, ImChannelContext channelContext) {
    Object sessionContext = channelContext.getSessionContext();
    if(sessionContext instanceof TcpSessionContext){
      TcpPacket tcpPacket = new TcpPacket(command,body);
      TcpServerEncoder.encode(tcpPacket, channelContext.getImConfig(), channelContext);
      tcpPacket.setCommand(command);
      return tcpPacket;
    }
    return null;
  }

}
