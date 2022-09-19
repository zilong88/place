package com.one.place.service;

import java.util.concurrent.TimeUnit;

public interface UserService {

  void extendTokenExpirationTime(String userTokenKey,String uuid,long timeout, TimeUnit timeUnit);
}
