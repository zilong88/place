package com.one.place.service.impl;

import com.one.place.dto.UserTokenDto;
import com.one.place.enums.ApiErrors;
import com.one.place.exceptions.ApiException;
import com.one.place.service.UserService;
import com.one.place.util.JsonUtil;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final StringRedisTemplate redisTemplate;

  public UserServiceImpl(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public void extendTokenExpirationTime(String userTokenKey, String uuid,long timeout, TimeUnit timeUnit) {
    String userTokenStr = redisTemplate.opsForValue().get(userTokenKey);
    if (StringUtils.isBlank(userTokenStr)){
      throw new ApiException(ApiErrors.MUST_LOGIN);
    }
    UserTokenDto userTokenDto = JsonUtil.readValue(userTokenStr,UserTokenDto.class);
    if (!userTokenDto.getUuid().equals(uuid)){
      throw new ApiException(ApiErrors.MUST_LOGIN);
    }
    redisTemplate.expire(userTokenKey,timeout,timeUnit);
  }
}
