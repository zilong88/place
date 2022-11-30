package com.one.place.im.core.session;

import java.util.UUID;

public class UUIDSessionIdGenerator implements SessionIdGenerator{
  public final static UUIDSessionIdGenerator instance = new UUIDSessionIdGenerator();
  /**
   *
   * @author wchao
   */
  private UUIDSessionIdGenerator() {
  }

  /**
   * @return
   * @author wchao
   */
  @Override
  public String sessionId() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
