package com.example.sampleapp.domain.consts;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import com.example.sampleapp.domain.value.AbstractValueObject;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.lang.Nullable;

public enum Billing implements EnumInterface {
  NOT_BILLED("無課金", 0),
  BILLING("課金", 1),
  ;

  private final String name;

  private final Integer code;

  Billing(@NonNull final String name, @Nullable Integer code) {
    this.name = name;
    this.code = code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String toString() {
    assert this.code != null;
    return this.code.toString();
  }

  public boolean isBilling(){
    return Objects.equals(this, Billing.BILLING);
  }
}
