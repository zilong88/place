package com.one.place.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.one.place.web.resp.ApiResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 携带错误字段名称的响应结果
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseWithField<T> extends ApiResponse<T> {

  private static final long serialVersionUID = 8780905952846911080L;
  @ApiModelProperty("错误字段名称")
  private String errField;

  public static <T> ApiResponseWithField<T> withField(String errMsg, String errCode,
      String errField) {
    ApiResponseWithField<T> response = new ApiResponseWithField<>();
    response.setCode(STATUS_ERROR);
    response.setErrField(errField);
    response.setErrorCode(errCode);
    response.setMessage(errMsg);
    return response;
  }

  public String getErrField() {
    return errField;
  }

  public void setErrField(String errField) {
    this.errField = errField;
  }
}
