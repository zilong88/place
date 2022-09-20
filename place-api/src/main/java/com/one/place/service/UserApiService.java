package com.one.place.service;

import com.one.place.entity.User;

public interface UserApiService {

  User getUser(Long userId);

  void update(User user);

  void testInsert();
}
