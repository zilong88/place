package com.one.place.service;

import com.one.place.entity.User;
import java.util.concurrent.TimeUnit;
import org.springframework.lang.Nullable;

public interface UserService {

  /**
   * 从缓存中获取数据
   * @param userTokenKey user token key
   * @return 用户数据字符串
   */
  String getUserByCache(String userTokenKey);

  /**
   * 延长过期时间
   * @param userTokenKey user token key
   * @param timeout 时间
   * @param timeUnit 单位
   */
  void extendTokenExpirationTime(String userTokenKey,long timeout, TimeUnit timeUnit);

  @Nullable
  User findById(Long userId);

  boolean save(User user);
}
