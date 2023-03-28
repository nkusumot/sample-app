package com.example.sampleapp.presentation.helper;

import com.example.sampleapp.domain.consts.AgeCertification;
import com.example.sampleapp.domain.consts.Billing;
import com.example.sampleapp.domain.consts.Gender;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.value.Age;
import com.example.sampleapp.domain.value.UserId;
import com.example.sampleapp.domain.value.UserName;
import com.example.sampleapp.presentation.entity.UserEntity;
import lombok.NonNull;

public final class UserGroupControllerHelper {

  private UserGroupControllerHelper() {}

  @NonNull
  public static User convertUser(@NonNull final UserEntity request) {
    final UserId userId = UserId.from(request.getUserId());
    final UserName userName = UserName.from(request.getUserName());
    final Age age = Age.from(request.getAge());
    final AgeCertification ageCertification =
        AgeCertification.getByCode(request.getAgeCertification().getCode());
    final Gender gender = Gender.getByCode(request.getGender().getCode());
    final Billing billing = Billing.getByCode(request.getBilling().getCode());

    return User.of(userId, userName, age, ageCertification, gender, billing);
  }
}
