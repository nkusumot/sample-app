package com.example.sampleapp.domain.model;

import com.example.sampleapp.domain.consts.AgeCertification;
import com.example.sampleapp.domain.consts.Billing;
import com.example.sampleapp.domain.consts.Gender;
import com.example.sampleapp.domain.value.*;
import com.example.sampleapp.infrastructure.database.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

  private UserId userId;

  private UserName userName;

  private Age age;

  private AgeCertification ageCertification;

  private Gender gender;

  private Billing billing;

  @NonNull
  public static User of(
      @NonNull UserId userId,
      @NonNull UserName userName,
      @Nullable Age age,
      @NonNull AgeCertification ageCertification,
      @NonNull Gender gender,
      @NonNull Billing billing) {
    return new User(userId, userName, age, ageCertification, gender, billing);
  }

  /**
   * 年齢認証済ユーザーかを判定
   *
   * @return 判定結果
   */
  public boolean isAgeCertificationUser() {
    return this.ageCertification.isAgeCertification();
  }

  /**
   * メッセージ可能なユーザーを判定
   *
   * @return メッセージ可能かの判定結果
   */
  public boolean CanUserMessage() {
    if (!ageCertification.isAgeCertification()) {
      return false;
    }
    return gender.isWomen() || gender.isMen() && billing.isBilling();
  }

  public UserEntity generateUserEntity() {
    return new UserEntity(userId.getValue(), userName.getValue(), age.getValue());
  }
}
