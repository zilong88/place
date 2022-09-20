package com.one.place.service.impl;

import com.one.place.entity.User;
import com.one.place.repository.UserRepository;
import com.one.place.service.UserService;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final StringRedisTemplate redisTemplate;
  private final UserRepository userRepository;

  public UserServiceImpl(StringRedisTemplate redisTemplate,
      UserRepository userRepository) {
    this.redisTemplate = redisTemplate;
    this.userRepository = userRepository;
  }

  @Override
  public String getUserByCache(String userTokenKey) {
    return redisTemplate.opsForValue().get(userTokenKey);
  }

  @Override
  public void extendTokenExpirationTime(String userTokenKey,long timeout, TimeUnit timeUnit) {
    redisTemplate.expire(userTokenKey,timeout,timeUnit);
  }

  @Nullable
  @Override
  public User findById(Long userId) {
    return userRepository.getById(userId);
  }

  @Override
  public boolean save(User user) {
   return userRepository.saveOrUpdate(user);
  }


}
