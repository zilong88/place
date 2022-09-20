package com.one.place.web.interceptor;

import com.one.place.config.UserTokenConfig;
import com.one.place.dto.UserTokenDto;
import com.one.place.enums.ApiErrors;
import com.one.place.exceptions.ApiException;
import com.one.place.service.UserService;
import com.one.place.util.AuthorityUtil;
import com.one.place.util.JsonUtil;
import com.one.place.util.UserTokenUtil;
import com.one.place.web.annotation.NeedlessLogin;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

@Component
public class UserLoginInterceptor implements AsyncHandlerInterceptor {

  private final UserTokenConfig userTokenConfig;
  private final UserService userService;

  public UserLoginInterceptor(
      UserTokenConfig userTokenConfig,
      UserService userService) {
    this.userTokenConfig = userTokenConfig;
    this.userService = userService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String token = UserTokenUtil.getUserToken(request);
    // 跳过登入
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      if (AuthorityUtil.hasAnnotation(handlerMethod, NeedlessLogin.class)) {
        if (StringUtils.isNotBlank(token)) {
          extendTokenExpirationTime(token);
        }
        return true;
      }
      if (AuthorityUtil.hasAnnotation(handlerMethod.getMethod(), NeedlessLogin.class)) {
        if (StringUtils.isNotBlank(token)) {
          extendTokenExpirationTime(token);
        }
        return true;
      }
    }
    if (StringUtils.isBlank(token)){
      throw new ApiException(ApiErrors.MUST_LOGIN);
    }
    extendTokenExpirationTime(token);
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

  private void extendTokenExpirationTime(String token) {
    Pair<String, String> pair = UserTokenUtil.decodeToken(token,
        userTokenConfig.getGoTokenEncryptKey(),
        userTokenConfig.getDefaultIv(), userTokenConfig.getGoTokenDelimiter());

    String tokenKey = userTokenConfig.getTokenPrefix() + pair.getKey();
    String userTokenStr = userService.getUserByCache(tokenKey);
    if (StringUtils.isBlank(userTokenStr)) {
      throw new ApiException(ApiErrors.MUST_LOGIN);
    }
    UserTokenDto userTokenDto = JsonUtil.readValue(userTokenStr, UserTokenDto.class);
    if (!pair.getValue().equals(userTokenDto.getUuid())) {
      throw new ApiException(ApiErrors.MUST_LOGIN);
    }
    userService.extendTokenExpirationTime(tokenKey, userTokenConfig.getTokenExpired(),
        TimeUnit.SECONDS);

//    String userToken = stringRedisTemplate.opsForValue().get(tokenKey);
//    if (StringUtils.isBlank(userToken)) {
//      throw new ApiException(ApiErrors.MUST_LOGIN);
//    }
//    GoTokenUserResp goToken = JsonUtil.readValue(userToken, GoTokenUserResp.class);
//    if (!pair.getValue().equals(goToken.getUuid())) {
//      throw new ApiException(ApiErrors.MUST_LOGIN);
//    }
//    UserInfoResp userInfo = goToken.getData();
//    userInfo.setToken(token);
//    UserContext.setCurrentUser(userInfo);
//    // 延长token时间
//    try {
//      stringRedisTemplate.executePipelined((RedisCallback<Void>) connection -> {
//        StringRedisConnection strConnection = (StringRedisConnection) connection;
//        strConnection.expire(tokenKey, nftConfig.getTokenExpired());
//        strConnection.set(RedisConstant.userLastRequestAt + userInfo.getId(),
//            System.currentTimeMillis() + "");
//        return null;
//      });
//    } catch (Exception e) {
//      log.error("延长用户token过期时间出错", e);
//    }
  }
}
