package com.example.sampleapp.domain.consts;

import java.util.HashMap;import java.util.Map;import java.util.Objects;
import lombok.NonNull;
import org.springframework.lang.Nullable;

public enum Billing implements EnumInterface {
  NOT_BILLED("無課金", 0),
  BILLING("課金", 1),
  ;

  private final String name;

  private final Integer code;

  private static final Map<Integer, Billing> GENDER_BY_CODE = new HashMap<>();

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

  public static Billing getByCode(final int code) {
    return GENDER_BY_CODE.get(code);
  }

  public boolean isBilling() {
    return Objects.equals(this, Billing.BILLING);
  }
}
