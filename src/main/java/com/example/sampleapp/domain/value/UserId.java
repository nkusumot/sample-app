package com.example.sampleapp.domain.value;

import com.example.sampleapp.domain.validate.ValidateUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
public class UserId extends AbstractValueObject<UserId> implements Serializable {

  @Serial private static final long serialVersionUID = 1L;
  @Getter private Long value;

  public UserId() {
    this.value = null;
  }

  public UserId(Long value) {
    this.value = value;
  }

  public UserId(String value) {
    this.value = value != null ? Long.valueOf(value) : null;
  }

  public static UserId from() {
    return new UserId();
  }

  public static UserId from(Long value) {
    return new UserId(value);
  }

  @Override
  public String toString() {
    return value == null ? null : value.toString();
  }

  @Override
  protected UserId validate() {
    ValidateUtil.validateNull(this.getFieldErrorList(), this.value, this.getClass());
    return this;
  }
}
