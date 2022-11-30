package com.one.place.im.core.ws;

import com.one.place.im.core.ImConst;

public class WsConfig implements ImConst {
  private String charset = Http.CHARSET_NAME;

  private WsMsgHandler wsMsgHandler;

  public WsConfig(){};

  public WsConfig(WsMsgHandler wsMsgHandler){
    this.wsMsgHandler = wsMsgHandler;
  }

  public static WsConfig.Builder newBuilder(){
    return new WsConfig.Builder();
  }

  /**
   * @return the charset
   */
  public String getCharset() {
    return charset;
  }

  /**
   * @param charset the charset to set
   */
  public void setCharset(String charset) {
    this.charset = charset;
  }
  public WsMsgHandler getWsMsgHandler() {
    return wsMsgHandler;
  }
  public void setWsMsgHandler(WsMsgHandler wsMsgHandler) {
    this.wsMsgHandler = wsMsgHandler;
  }

  public static class Builder{

    private WsMsgHandler wsMsgHandler;

    private String charset;

    public Builder wsMsgHandler(WsMsgHandler wsMsgHandler){
      this.wsMsgHandler = wsMsgHandler;
      return this;
    }

    public Builder charset(String charset){
      this.charset = charset;
      return this;
    }

    public WsConfig build(){
      WsConfig wsConfig = new WsConfig(wsMsgHandler);
      wsConfig.setCharset(charset);
      return wsConfig;
    }
  }
}
