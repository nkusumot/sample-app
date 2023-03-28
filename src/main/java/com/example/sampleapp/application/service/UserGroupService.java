package com.example.sampleapp.application.service;

import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.model.UserGroup;
import com.example.sampleapp.domain.repository.UserGroupServiceDomain;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGroupService {
  private final UserGroupServiceDomain userGroupServiceDomain;

  public void joinUserGroup(@NonNull final User user, @NonNull final String groupId) {

    final UserGroup userGroup = userGroupServiceDomain.searchUserGroup(groupId);
    if (userGroup.JoinGroup(user)) {
      userGroupServiceDomain.joinUserGroup(user);
    }
  }
}
