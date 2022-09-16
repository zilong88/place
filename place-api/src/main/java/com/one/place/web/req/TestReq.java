package com.one.place.web.req;

import com.one.place.web.annotation.NotEmptyEx;
import javax.validation.constraints.NotBlank;

public class TestReq {

  @NotEmptyEx
  private String empty;

  @NotBlank
  private String not;

  public String getEmpty() {
    return empty;
  }

  public void setEmpty(String empty) {
    this.empty = empty;
  }

  public String getNot() {
    return not;
  }

  public void setNot(String not) {
    this.not = not;
  }
}
