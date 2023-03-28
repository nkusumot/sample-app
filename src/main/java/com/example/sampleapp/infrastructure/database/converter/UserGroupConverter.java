package com.example.sampleapp.infrastructure.database.converter;

import com.example.sampleapp.domain.consts.AgeCertification;
import com.example.sampleapp.domain.consts.Billing;
import com.example.sampleapp.domain.consts.Gender;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.value.Age;
import com.example.sampleapp.domain.value.UserId;
import com.example.sampleapp.domain.value.UserName;
import com.example.sampleapp.infrastructure.database.entity.UserEntity;
import lombok.NonNull;

public class UserGroupConverter {

  private UserGroupConverter() {}

  @NonNull
  public static User convertToUserModel(@NonNull final UserEntity userEntity) {
    final UserId userId = UserId.from(userEntity.getUserId());
    final UserName userName = UserName.from(userEntity.getUserName());
    final Age age = Age.from(userEntity.getAge());
    final AgeCertification ageCertification =
        AgeCertification.getByCode(userEntity.getAgeCertification().getCode());
    final Gender gender = Gender.getByCode(userEntity.getGender().getCode());
    final Billing billing = Billing.getByCode(userEntity.getBilling().getCode());

    return User.of(userId, userName, age, ageCertification, gender, billing);
  }
}
