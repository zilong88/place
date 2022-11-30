package com.one.place.im.core.tcp;

import com.one.place.im.core.ImConst;
import com.one.place.im.core.ImPacket;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.enums.Command;
import com.one.place.im.core.enums.ImStatus;
import com.one.place.im.core.exception.ImDecodeException;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpServerDecoder implements ImConst {

  private static final Logger log = LoggerFactory.getLogger(TcpServerDecoder.class);

  public static TcpPacket decode(ByteBuffer buffer, ImChannelContext imChannelContext)
      throws ImDecodeException {
    //校验协议头
    if (!isHeaderLength(buffer)) {
      return null;
    }
    //获取第一个字节协议版本号;
    byte version = buffer.get();
    if (version != Protocol.VERSION) {
      throw new ImDecodeException(ImStatus.C10013.getText());
    }
    //标志位
    byte maskByte = buffer.get();
    Integer synSeq = 0;
    //同步发送;
    if (ImPacket.decodeHasSynSeq(maskByte)) {
      synSeq = buffer.getInt();
    }
    //cmd命令码
    byte cmdByte = buffer.get();
    if (Command.forNumber(cmdByte) == null) {
      throw new ImDecodeException(ImStatus.C10014.getText());
    }
    int bodyLen = buffer.getInt();
    //数据不正确，则抛出ImDecodeException异常
    if (bodyLen < 0) {
      throw new ImDecodeException(
          "bodyLength [" + bodyLen + "] is not right, remote:" + imChannelContext.getClientNode());
    }
    int readableLength = buffer.limit() - buffer.position();
    int validateBodyLen = readableLength - bodyLen;
    // 不够消息体长度(剩下的buffer组不了消息体)
    if (validateBodyLen < 0) {
      return null;
    }
    byte[] body = new byte[bodyLen];
    try {
      buffer.get(body, 0, bodyLen);
    } catch (Exception e) {
      log.error(e.toString());
    }
    log.debug("TCP解码成功...");
    //byteBuffer的总长度是 = 1byte协议版本号+1byte消息标志位+4byte同步序列号(如果是同步发送则多4byte同步序列号,否则无4byte序列号)+1byte命令码+4byte消息的长度+消息体的长度
    TcpPacket tcpPacket = new TcpPacket(Command.forNumber(cmdByte), body);
    tcpPacket.setVersion(version);
    tcpPacket.setMask(maskByte);
    tcpPacket.setByteCount(bodyLen);
    //同步发送设置同步序列号
    if (synSeq > 0) {
      tcpPacket.setSynSeq(synSeq);
      try {
        //channelContext.getGroupContext().getAioHandler().handler(tcpPacket, channelContext);
      } catch (Exception e) {
        log.error("同步发送解码调用handler异常!" + e);
      }
    }
    return tcpPacket;
  }

  /**
   * 判断是否符合协议头长度
   *
   * @param buffer
   * @return
   * @throws ImDecodeException
   */
  private static boolean isHeaderLength(ByteBuffer buffer) throws ImDecodeException {
    int readableLength = buffer.limit() - buffer.position();
    if (readableLength == 0) {
      return false;
    }
    //协议头索引;
    int index = buffer.position();
    try {
      //获取第一个字节协议版本号;
      buffer.get(index);
      index++;
      //标志位
      byte maskByte = buffer.get(index);
      //同步发送;
      if (ImPacket.decodeHasSynSeq(maskByte)) {
        index += 4;
      }
      index++;
      //cmd命令码
      buffer.get(index);
      index++;
      //消息体长度
      buffer.getInt(index);
      index += 4;
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
