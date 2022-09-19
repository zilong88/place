package com.one.place.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "user.token")
public class UserTokenConfig {

  private String tokenPrefix = "UserToken:";
  private String defaultIv = "I Love Java !";
  private String goTokenEncryptKey = "abc30a83ideajavaq29aaa9bbb8a7xyz";
  private String goTokenDelimiter = "_";
  private Long tokenExpired = 864000L;

  public String getTokenPrefix() {
    return tokenPrefix;
  }

  public void setTokenPrefix(String tokenPrefix) {
    this.tokenPrefix = tokenPrefix;
  }

  public String getDefaultIv() {
    return defaultIv;
  }

  public void setDefaultIv(String defaultIv) {
    this.defaultIv = defaultIv;
  }

  public String getGoTokenEncryptKey() {
    return goTokenEncryptKey;
  }

  public void setGoTokenEncryptKey(String goTokenEncryptKey) {
    this.goTokenEncryptKey = goTokenEncryptKey;
  }

  public String getGoTokenDelimiter() {
    return goTokenDelimiter;
  }

  public void setGoTokenDelimiter(String goTokenDelimiter) {
    this.goTokenDelimiter = goTokenDelimiter;
  }

  public Long getTokenExpired() {
    return tokenExpired;
  }

  public void setTokenExpired(Long tokenExpired) {
    this.tokenExpired = tokenExpired;
  }
}
