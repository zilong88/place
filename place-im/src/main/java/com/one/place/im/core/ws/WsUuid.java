package com.one.place.im.core.ws;

import cn.hutool.core.lang.Snowflake;
import java.util.concurrent.ThreadLocalRandom;

public class WsUuid {
  private Snowflake snowflake;

  public WsUuid() {
    snowflake = new Snowflake(
        ThreadLocalRandom.current().nextInt(1, 30), ThreadLocalRandom.current().nextInt(1, 30));
  }

  public WsUuid(long workerId, long dataCenterId) {
    snowflake = new Snowflake(workerId, dataCenterId);
  }

  /**
   * @return
   * @author wchao
   */
  public String uuid() {
    return snowflake.nextId() + "";
  }
}
