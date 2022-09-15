package com.one.place.web.controller;

import com.one.place.enums.ApiErrors;
import com.one.place.exceptions.ApiException;
import com.one.place.web.req.TestReq;
import com.one.place.web.resp.ApiResponse;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = " 测试 控制器")
@Validated
public class TestController {

  @GetMapping
  public ApiResponse<Void> testI18n(){
    throw new ApiException(ApiErrors.UNKNOWN_ERROR);
  }

  @PostMapping
  public ApiResponse<Void> test2(@Valid @RequestBody TestReq req){
    return ApiResponse.ok();
  }
}
