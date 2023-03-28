package com.example.sampleapp.domain.consts;

import lombok.NonNull;
import org.springframework.lang.Nullable;
import java.util.HashMap;import java.util.Map;import java.util.Objects;

public enum AgeCertification implements EnumInterface {
  NOT_CERTIFICATION("年齢未認証", 0),
  CERTIFICATION("年齢認証済", 1),
  ;

  private final String name;

  private final Integer code;

  private static final Map<Integer, AgeCertification> GENDER_BY_CODE = new HashMap<>();

  AgeCertification(@NonNull final String name, @Nullable final Integer code) {
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

  public static AgeCertification getByCode(final int code) {
    return GENDER_BY_CODE.get(code);
  }


  public boolean isAgeCertification() {
    return Objects.equals(this, AgeCertification.CERTIFICATION);
  }
}
