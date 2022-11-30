package com.one.place.im.core.packets;

public class HeartbeatBody extends Message{

  private static final long serialVersionUID = 3298065968957969225L;
  private byte hbbyte;

  public HeartbeatBody(){}
  public HeartbeatBody(byte hbbyte){
    this.hbbyte = hbbyte;
  }
  public byte getHbbyte() {
    return hbbyte;
  }

  public HeartbeatBody setHbbyte(byte hbbyte) {
    this.hbbyte = hbbyte;
    return this;
  }
}
