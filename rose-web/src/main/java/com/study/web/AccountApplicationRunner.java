package com.study.web;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.study.core.common.entity.Address;
import com.study.core.dto.AccountDto;
import com.study.web.service.AccountService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountApplicationRunner implements ApplicationRunner {

  private final AccountService accountService;

  @Override
  public void run(ApplicationArguments args) {
    AccountDto.SingUp dto = AccountDto.SingUp.builder()
        .loginId("test")
        .password("0000")
        .name("test")
        .address(new Address("seoul", "seoul", "12345"))
        .phoneNumber("01011112222")
        .build();

    accountService.signUp(dto);
  }
}
