package com.example.sampleapp.domain.validate;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import java.util.List;

@Component
public class ValidateUtil {

  private static MessageSource messageSource;

  ValidateUtil(final MessageSource messageSource) {
    if (messageSource == null) {
      throw new IllegalStateException("message");
    }
    ValidateUtil.messageSource = messageSource;
  }

  public static <T> void validateLength(
      List<FieldError> fieldErrorList, String target, Integer min, Integer max, Class<T> clazz) {
    if (target == null) return;
    if (target.length() > max) {
      addError(
          fieldErrorList,
          target,
          max.toString() + "文字以上" + min.toString() + "文字以下で入力してください。",
          clazz);
    }
  }

  public static <T> void validateNull(
      List<FieldError> fieldErrorList, Object target, Class<T> clazz) {
    if (target == null) {
      addError(fieldErrorList, null, "nullは許可されてません", clazz);
    }
  }

  public static <T> void addError(
      List<FieldError> fieldErrorList, Object object, String message, Class<T> clazz) {

    fieldErrorList.add(
        new FieldError(
            clazz.getSimpleName(), clazz.getSimpleName(), object, false, null, null, message));
  }
}
