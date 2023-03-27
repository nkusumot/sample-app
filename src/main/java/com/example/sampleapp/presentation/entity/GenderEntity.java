package com.example.sampleapp.presentation.entity;

import java.util.Arrays;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NonNull;
import org.springframework.lang.Nullable;

public enum GenderEntity {
  MEM("男性", 0),
  WOMEN("女性", 1),
  ;

  private final String name;

  private final Integer code;

  GenderEntity(@NonNull final String name, @Nullable Integer code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  @JsonValue
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String toString() {
    assert this.code != null;
    return this.code.toString();
  }

  @JsonCreator
  public static AgeCertificationEntity getByCode(Integer code) {
    return Arrays.stream(AgeCertificationEntity.values())
        .filter(data -> Objects.equals(data.getCode(), code))
        .findFirst()
        .orElseThrow(
            () -> new IllegalArgumentException(String.format("No such values. value os %d", code)));
  }
}
