package com.one.place.im.core.listener;

import com.one.place.im.config.ImConfig;
import com.one.place.im.core.ImConst;
import com.one.place.im.core.message.MessageHelper;

public abstract class AbstractImStoreBindListener implements ImStoreBindListener, ImConst {
  protected ImConfig imConfig;

  protected MessageHelper messageHelper;

  public AbstractImStoreBindListener(ImConfig imConfig, MessageHelper messageHelper){
    this.imConfig = imConfig;
    this.messageHelper = messageHelper;
  }

  public ImConfig getImConfig() {
    return imConfig;
  }

  public void setImConfig(ImConfig imConfig) {
    this.imConfig = imConfig;
  }

  public MessageHelper getMessageHelper() {
    return messageHelper;
  }

  public void setMessageHelper(MessageHelper messageHelper) {
    this.messageHelper = messageHelper;
  }
}
