package com.one.place.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;
import org.springframework.web.method.HandlerMethod;

public interface AuthorityUtil {

  static <A extends Annotation> boolean hasAnnotation(HandlerMethod handlerMethod,
      Class<A> annotation) {
    A a = handlerMethod.getBeanType().getAnnotation(annotation);
    if (Objects.nonNull(a)) {
      return true;
    }
    return handlerMethod.getMethodAnnotation(annotation) != null;
  }

  static <A extends Annotation> boolean hasAnnotation(Method method, Class<A> annotation) {
    A a = method.getDeclaringClass()
        .getAnnotation(annotation);
    if (Objects.nonNull(a)) {
      return true;
    }
    return method.getAnnotation(annotation) != null;
  }
}
