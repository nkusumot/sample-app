package com.example.sampleapp.domain.model;

import com.example.sampleapp.domain.exception.BusinessException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserGroup {

  private final List<User> userList;

  @NonNull
  public static UserGroup from(List<User> userList) {
    return new UserGroup(userList);
  }

  /**
   * グループに参加可能かを判定
   *
   * @param user
   * @return 判定結果
   */
  public boolean CanUserJoin(User user) {
    return user.isAgeCertificationUser();
  }

  /**
   * ユーザーをグループに追加
   *
   * @param user
   * @return メンバー追加したユーザーグループ
   */
  public boolean JoinGroup(User user) {
    if (!CanUserJoin(user)) {
      throw new BusinessException("年齢認証前のユーザーはグループに参加できません");
    }
    return this.userList.add(user);
  }
}
