package com.one.place.web.annotation.validation;

import com.one.place.web.annotation.NotEmptyEx;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * 扩展的非空验证器
 *
 * @see javax.validation.constraints.NotEmpty
 * @see NotEmptyEx
 */
public class NotEmptyExValidation implements ConstraintValidator<NotEmptyEx, Object> {

  private NotEmptyEx constraint;

  @Override
  public void initialize(NotEmptyEx constraintAnnotation) {
    this.constraint = constraintAnnotation;
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (value == null) {
      return constraint.acceptNull();
    }
    if (value instanceof CharSequence) {
      return onCharSequence((CharSequence) value);
    } else if (value instanceof Collection) {
      return onCollection((Collection<?>) value);
    } else if (value instanceof Map) {
      return onMap((Map<?, ?>) value);
    } else {
      return onArray(value);
    }
  }

  private boolean onCharSequence(CharSequence charSequence) {
    if (!constraint.acceptNull() && Objects.isNull(charSequence)) {
      return false;
    }
    // 不允许为空白字符
    if (!constraint.acceptBlank() && StringUtils.hasText(charSequence)) {
      return false;
    }
    // 不允许包含空白字符
    return constraint.acceptWhitespace() || !StringUtils.containsWhitespace(charSequence);
  }

  private boolean onCollection(Collection<?> collection) {
    if (collection.isEmpty() && constraint.acceptNull()) {
      return true;
    } else {
      return !collection.isEmpty();
    }
  }

  private boolean onMap(Map<?, ?> map) {
    if (map.isEmpty() && constraint.acceptNull()) {
      return true;
    } else {
      return !map.isEmpty();
    }
  }

  private boolean onArray(Object array) {
    if (!array.getClass().isArray()) {
      return false;
    }
    if (Array.getLength(array) <= 0 && constraint.acceptNull()) {
      return true;
    } else {
      return Array.getLength(array) > 0;
    }
  }
}
