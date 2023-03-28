package com.example.sampleapp.domain.repository;

import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.model.UserGroup;

public interface UserGroupServiceDomain {

  UserGroup searchUserGroup(final String groupId);

  void joinUserGroup(final User user);
}
