package com.one.place.web.controller;

import com.one.place.entity.User;
import com.one.place.service.UserApiService;
import com.one.place.web.resp.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1")
@Api(tags = " 用户 控制器")
@Validated
public class UserController {

  private final UserApiService userApiService;

  public UserController(UserApiService userApiService){
    this.userApiService = userApiService;
  }

  @GetMapping("/{id}")
  public ApiResponse<User> getUser(@NotNull @PathVariable("id") Long userId){
    return ApiResponse.ok(userApiService.getUser(userId));
  }

  @ApiOperation("修改用户信息")
  @PostMapping
  public ApiResponse<Void> update(){
    Long userId = 1L;
    User user = userApiService.getUser(userId);
    user.setAvatar("avatar");
    userApiService.update(user);
    return ApiResponse.ok();
  }
}
