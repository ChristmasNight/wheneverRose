package com.study.core.dto;

import com.study.core.common.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AccountDto {

  @Getter
  @Setter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SingUp {
    private String loginId;

    private String password;

    private String name;

    private Address address;

    private String phoneNumber;
  }

}
