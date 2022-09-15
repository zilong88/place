package com.one.place.web.req;

import com.one.place.web.annotation.NotEmptyEx;

public class TestReq {

  @NotEmptyEx
  private String empty;

  public String getEmpty() {
    return empty;
  }

  public void setEmpty(String empty) {
    this.empty = empty;
  }
}
