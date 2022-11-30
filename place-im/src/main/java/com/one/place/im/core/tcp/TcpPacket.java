package com.one.place.im.core.tcp;

import com.one.place.im.core.ImPacket;
import com.one.place.im.core.enums.Command;

public class TcpPacket extends ImPacket {

  private static final long serialVersionUID = 6125664245761217020L;
  private byte version = 0;
  private byte mask = 0;

  public TcpPacket(){}

  public TcpPacket(Command command, byte[] body){
    super(command, body);
  }
  public TcpPacket( byte[] body){
    super(body);
  }
  public byte getVersion() {
    return version;
  }
  public void setVersion(byte version) {
    this.version = version;
  }
  public byte getMask() {
    return mask;
  }
  public void setMask(byte mask) {
    this.mask = mask;
  }
}
