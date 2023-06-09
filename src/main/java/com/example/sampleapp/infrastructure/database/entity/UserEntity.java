package com.example.sampleapp.infrastructure.database.entity;

import com.example.sampleapp.presentation.entity.AgeCertificationEntity;
import com.example.sampleapp.presentation.entity.BillingEntity;
import com.example.sampleapp.presentation.entity.GenderEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
public class UserEntity {
  private Long userId;
  private String userName;
  private Long age;
}
