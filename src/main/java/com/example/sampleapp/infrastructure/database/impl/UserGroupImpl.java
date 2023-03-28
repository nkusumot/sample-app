package com.example.sampleapp.infrastructure.database.impl;

import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.model.UserGroup;
import com.example.sampleapp.domain.repository.UserGroupServiceDomain;
import com.example.sampleapp.infrastructure.database.converter.UserGroupConverter;
import com.example.sampleapp.infrastructure.database.entity.UserEntity;
import com.example.sampleapp.infrastructure.database.mapper.UserGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserGroupImpl implements UserGroupServiceDomain {

  private final UserGroupMapper mapper;

  @Override
  public UserGroup searchUserGroup(String groupId) {
    final List<UserEntity> userEntities = mapper.searchUserGroup(groupId);
    final List<User> userList =
        userEntities.stream().map(UserGroupConverter::convertToUserModel).toList();
    return UserGroup.from(groupId, userList);
  }

  @Override
  public void joinUserGroup(User user) {
    mapper.joinUserGroup(user.generateUserEntity());
  }
}
