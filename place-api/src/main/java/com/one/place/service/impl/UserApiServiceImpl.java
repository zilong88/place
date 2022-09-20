package com.one.place.service.impl;

import com.one.place.entity.User;
import com.one.place.service.UserApiService;
import com.one.place.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserApiServiceImpl implements UserApiService {

  private final UserService userService;

  public UserApiServiceImpl(UserService userService){
    this.userService = userService;
  }

  @Override
  public User getUser(Long userId) {
    return userService.findById(userId);
  }

  @Override
  public void update(User user) {
    userService.save(user);
  }

  @Override
  public void testInsert() {
    User user = new User();
    user.setAvatar("a1");
    user.setNickName("nickname");
    user.setCellPhone("cell phone");
    user.setPassword("pwd");
    user.setKycStatus(0);
    user.setType(1);
    userService.save(user);
  }
}
