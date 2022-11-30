package com.one.place.im.core.ws;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import com.one.place.im.core.exception.ImException;
import com.one.place.im.core.http.HttpRequest;
import com.one.place.im.core.http.HttpRequestDecoder;
import com.one.place.im.core.protocol.AbstractProtocol;
import com.one.place.im.core.protocol.ProtocolConverter;
import com.one.place.im.core.util.ImKit;
import java.nio.ByteBuffer;
import java.util.Objects;

public class WsProtocol extends AbstractProtocol {

  @Override
  public String name() {
    return Protocol.WEB_SOCKET;
  }

  public WsProtocol(ProtocolConverter converter) {
    super(converter);
  }

  @Override
  protected void init(ImChannelContext imChannelContext) {
    imChannelContext.setSessionContext(new WsSessionContext(imChannelContext));
    ImKit.initImClientNode(imChannelContext);
  }

  @Override
  protected boolean validateProtocol(ImSessionContext imSessionContext) throws ImException {
    if (imSessionContext instanceof WsSessionContext) {
      return true;
    }
    return false;
  }

  @Override
  protected boolean validateProtocol(ByteBuffer buffer, ImChannelContext imChannelContext)
      throws ImException {
    //第一次连接;
    HttpRequest request = HttpRequestDecoder.decode(buffer, imChannelContext, false);
    if (Objects.isNull(request)){
      return false;
    }
    if (null != request.getHeaders().get(Http.RequestHeaderKey.Sec_WebSocket_Key)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean validateProtocol(ImPacket imPacket) throws ImException {
    if (imPacket instanceof WsPacket) {
      return true;
    }
    return false;
  }
}
