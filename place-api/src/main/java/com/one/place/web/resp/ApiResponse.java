package com.one.place.web.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
@ApiModel("api返回结果(api return result)")
public class ApiResponse<T> implements Serializable {

  private static final long serialVersionUID = 2303871708353385160L;

  protected static final int STATUS_ERROR = -1;
  protected static final int STATUS_OK = 0;



  @ApiModelProperty(value = "响应状态", allowableValues = STATUS_OK + ","
      + STATUS_ERROR, required = true)
  private Integer code;

  @ApiModelProperty(value = "错误信息", dataType = "string")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String message = "";

  @ApiModelProperty(value = "返回数据-泛型，支持各种返回的数据格式类型", dataType = "object")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;

  public static <K> ApiResponse<K> ok() {
    return ApiResponse.ok(null);
  }
  public static <K> ApiResponse<K> ok(K data) {
    ApiResponse<K> response = new ApiResponse<>();
    response.code = STATUS_OK;
    response.message = "";
    response.data = data;
    return response;
  }

  public static <K> ApiResponse<K> error(String errMsg) {
    ApiResponse<K> response = new ApiResponse<>();
    response.code = STATUS_ERROR;
    response.message = errMsg;
    response.data = null;
    return response;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

}
