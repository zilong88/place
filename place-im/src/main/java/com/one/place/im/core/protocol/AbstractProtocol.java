package com.one.place.im.core.protocol;

import com.one.place.im.core.ImConst;
import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.context.ImSessionContext;
import java.nio.ByteBuffer;
import java.util.Objects;

public  abstract class AbstractProtocol implements Protocol, ImConst {
  /**
   * 协议包转化器;
   */
  protected ProtocolConverter converter;

  public AbstractProtocol(ProtocolConverter converter){
    this.converter = converter;
  }
  /**
   * 协议初始化
   * @param imChannelContext
   */
  protected abstract void init(ImChannelContext imChannelContext);
  /**
   * 根据buffer判断是否属于指定协议
   * @param buffer
   * @param imChannelContext
   * @return
   * @throws Exception
   */
  protected abstract boolean validateProtocol(ByteBuffer buffer, ImChannelContext imChannelContext) throws Exception;

  /**
   * 根据SessionContext判断协议
   * @param imSessionContext
   * @return
   * @throws Exception
   */
  protected abstract boolean validateProtocol(ImSessionContext imSessionContext) throws Exception;

  /**
   * 根据imPacket判断是否属于指定协议
   * @param imPacket
   * @return
   * @throws Exception
   */
  protected abstract boolean validateProtocol(ImPacket imPacket) throws Exception;

  @Override
  public boolean isProtocol(ByteBuffer buffer, ImChannelContext imChannelContext) throws Exception {
    ImSessionContext imSessionContext = imChannelContext.getSessionContext();
    if(Objects.isNull(imSessionContext) && Objects.isNull(buffer)){
      return false;
    }else if(Objects.isNull(imSessionContext) && Objects.nonNull(buffer)){
      boolean isProtocol = validateProtocol(ByteBuffer.wrap(buffer.array()), imChannelContext);
      if(isProtocol){
        init(imChannelContext);
      }
      return isProtocol;
    }else{
      return validateProtocol(imSessionContext);
    }
  }

  @Override
  public boolean isProtocol(ImPacket imPacket, ImChannelContext imChannelContext) throws Exception {
    ImSessionContext sessionContext = imChannelContext.getSessionContext();
    if(Objects.isNull(imPacket)){
      return false;
    }
    boolean isProtocol = validateProtocol(imPacket);
    if(isProtocol && Objects.isNull(sessionContext)) {
      init(imChannelContext);
    }
    return isProtocol;
  }

  public ProtocolConverter getConverter() {
    return converter;
  }
}
