package com.example.sampleapp.infrastructure.database.mapper;

import com.example.sampleapp.infrastructure.database.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface UserGroupMapper {

  List<UserEntity> searchUserGroup(String groupId);

  void joinUserGroup(UserEntity userEntity);
}
