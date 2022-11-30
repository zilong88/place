package com.one.place.im.core.message;

import com.one.place.im.config.ImConfig;
import com.one.place.im.core.ImConst;

public abstract class AbstractMessageHelper implements MessageHelper, ImConst {
  protected ImConfig imConfig;

  public ImConfig getImConfig() {
    return imConfig;
  }

  public void setImConfig(ImConfig imConfig) {
    this.imConfig = imConfig;
  }
}
