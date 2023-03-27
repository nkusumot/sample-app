package com.example.sampleapp.domain.value;

import com.example.sampleapp.domain.validate.ValidateUtil;
import java.io.Serial;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
public class Age extends AbstractValueObject<Age> implements Serializable {

  @Serial private static final long serialVersionUID = 1L;
  @Getter private final Long value;

  public Age() {
    this.value = null;
  }

  public Age(Long value) {
    this.value = value;
  }

  public Age(String value) {
    this.value = value != null ? Long.valueOf(value) : null;
  }

  public static Age from() {
    return new Age();
  }

  public static Age from(Long value) {
    return new Age(value);
  }

  @Override
  public String toString() {
    return value == null ? null : value.toString();
  }

  @Override
  protected Age validate() {
    ValidateUtil.validateNull(this.getFieldErrorList(), this.value, this.getClass());
    return this;
  }
}
