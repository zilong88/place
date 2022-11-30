package com.one.place.im.core.tcp;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import com.one.place.im.core.protocol.AbstractProtocol;
import com.one.place.im.core.protocol.ProtocolConverter;
import com.one.place.im.core.util.ImKit;
import java.nio.ByteBuffer;

public class TcpProtocol extends AbstractProtocol {
  public TcpProtocol(ProtocolConverter converter){
    super(converter);
  }

  @Override
  public String name() {
    return Protocol.TCP;
  }

  @Override
  protected void init(ImChannelContext imChannelContext) {
    imChannelContext.setSessionContext(new TcpSessionContext(imChannelContext));
    ImKit.initImClientNode(imChannelContext);
  }

  @Override
  public boolean validateProtocol(ImSessionContext imSessionContext) throws Exception {
    return imSessionContext instanceof TcpSessionContext;
  }

  @Override
  public boolean validateProtocol(ByteBuffer buffer, ImChannelContext imChannelContext) throws Exception {
    //获取第一个字节协议版本号,TCP协议;
    if(buffer.get() == Protocol.VERSION){
      return true;
    }
    return false;
  }

  @Override
  public boolean validateProtocol(ImPacket imPacket) throws Exception {
    if(imPacket instanceof TcpPacket){
      return true;
    }
    return false;
  }
}
