package com.one.place.im.core.packets;

public class HandshakeBody extends Message{

  private static final long serialVersionUID = 8971781857247662234L;
  private byte hbyte;

  public HandshakeBody(){}
  public HandshakeBody(byte hbyte){
    this.hbyte = hbyte;
  }
  public byte getHbyte() {
    return hbyte;
  }

  public HandshakeBody setHbyte(byte hbyte) {
    this.hbyte = hbyte;
    return this;
  }
}
