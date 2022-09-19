package com.one.place.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1、注释在controller,整个controller接口都不需要登入
 * <p>
 * 2、注解在指定接口，该接口不需要登入就能访问
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface NeedlessLogin {

}
