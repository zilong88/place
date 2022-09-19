package com.one.place.util;


import com.one.place.dto.UserTokenDto;
import com.one.place.enums.ApiErrors;
import com.one.place.exceptions.ApiException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

public enum UserTokenUtil {
    ;
    private static final Logger log = LoggerFactory.getLogger(UserTokenUtil.class);


    public static Pair<String, String> decodeToken(String token, String goTokenEncryptKey,
        String defaultIv, String goTokenDelimiter) {
        byte[] base64Ary = Base64.getDecoder().decode(token);
        String tmpKey = null;
        try {
            tmpKey = new String(
                AesUtil.decrypt(goTokenEncryptKey.getBytes(StandardCharsets.UTF_8),
                    defaultIv.getBytes(StandardCharsets.UTF_8), base64Ary));
        } catch (Exception e) {
            log.error("解密token 错误", e);
            throw new ApiException(ApiErrors.MUST_LOGIN);
        }
        String[] userKeyAry = tmpKey.split(goTokenDelimiter);
        return Pair.of(userKeyAry[0], userKeyAry[1]);
    }

    public static String generateUserToken(UserTokenDto user, String goTokenDelimiter,
        String goTokenEncryptKey, String defaultIv) {
        String input = user.getUserKey() + goTokenDelimiter + user.getUuid();
        byte[] aesByte;
        try {
            aesByte = AesUtil.encrypt(goTokenEncryptKey.getBytes(StandardCharsets.UTF_8),
                defaultIv.getBytes(StandardCharsets.UTF_8), input.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("生成token 失败");
            throw new ApiException(ApiErrors.UNKNOWN_ERROR);
        }
        return Base64.getEncoder().encodeToString(aesByte);
    }

    public static String getUserToken(HttpServletRequest request){
        return getUserToken("token",request);
    }

    private static String getUserToken(String httpAuthHead, HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotBlank(authHeader)) {
            return StringUtils.substringAfter(authHeader, "Bearer").trim();
        }

        // 从请求头中获取
        String token = request.getHeader(httpAuthHead);
        if (StringUtils.isNotBlank(token)) {
            return token;
        }
        // 从参数中获取
        String paramValue = request.getParameter(httpAuthHead);
        if (StringUtils.isNotBlank(paramValue)) {
            return paramValue;
        }
        return null;
    }
}
