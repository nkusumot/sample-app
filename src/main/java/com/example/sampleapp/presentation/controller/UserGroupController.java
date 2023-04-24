package com.example.sampleapp.presentation.controller;

import com.example.sampleapp.application.service.UserGroupService;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.presentation.entity.UserEntity;
import com.example.sampleapp.presentation.helper.UserGroupControllerHelper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserGroupController {

  private final UserGroupService userGroupService;

  @PostMapping()
  public void joinGroup(@RequestBody UserEntity request, final String groupId) {
    final User user = UserGroupControllerHelper.convertUser(request);
    userGroupService.joinUserGroup(user, groupId);
  }
}
