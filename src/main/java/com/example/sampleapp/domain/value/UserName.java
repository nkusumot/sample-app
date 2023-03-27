package com.example.sampleapp.domain.value;

import com.example.sampleapp.domain.validate.ValidateUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Getter
@ToString
public class UserName extends AbstractValueObject<UserName> implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  private final String value;

  public UserName() {
    this.value = null;
  }

  public UserName(String value) {
    this.value = value;
  }

  public static UserName from() {
    return new UserName();
  }

  public static UserName from(String value) {
    return new UserName(value);
  }

  @Override
  public UserName validate() {
    ValidateUtil.validateLength(super.getFieldErrorList(), this.value, 1, 10, this.getClass());
    return this;
  }
}
