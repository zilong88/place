package com.one.place.web.annotation;

import com.one.place.web.annotation.validation.NotEmptyExValidation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 扩展的非空验证器，支持的数据类型:
 * <ul>
 * <li>{@code CharSequence}, 长度或字符串中是否包含空格</li>
 * <li>{@code Collection}, 集合的长度</li>
 * <li>{@code Map}, map 的长度</li>
 * <li>{@code Array}, 数组的长度</li>
 * </ul>
 *
 * @see javax.validation.constraints.NotEmpty
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.TYPE_USE})
@Documented
@Constraint(validatedBy = {NotEmptyExValidation.class})
public @interface NotEmptyEx {

  /**
   * 是否允许字符串中包含空白字符
   */
  boolean acceptWhitespace() default false;

  /**
   * 是否允许为空白字符
   */
  boolean acceptBlank() default false;

  /**
   * 是否允许值为null
   */
  boolean acceptNull() default false;

  String message() default "{com.annotation.NotEmptyEx.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
