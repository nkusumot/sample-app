package com.example.sampleapp.domain.consts;

import lombok.NonNull;
import org.springframework.lang.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Gender implements EnumInterface {
  MEM("男性", 0),
  WOMEN("女性", 1),
  ;

  private final String name;

  private final Integer code;

  private static final Map<Integer, Gender> GENDER_BY_CODE = new HashMap<>();

  Gender(@NonNull final String name, @Nullable Integer code) {
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

  public static Gender getByCode(final int code) {
    return GENDER_BY_CODE.get(code);
  }

  public boolean isMen() {
    return Objects.equals(this, Gender.MEM);
  }

  public boolean isWomen() {
    return Objects.equals(this, Gender.WOMEN);
  }
}
