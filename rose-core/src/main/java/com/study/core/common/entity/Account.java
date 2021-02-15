package com.study.core.common.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.study.core.dto.AccountDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "account_id")
	  private Long id;

	  private String loginId;

	  private String password;

	  private String name;

	  @Embedded
	  private Address address;

	  private String phoneNumber;

	  @OneToMany(mappedBy = "account", orphanRemoval = true)
	  private List<Order> orders = new ArrayList<>();

	  public static Account signUp(AccountDto.SingUp dto) {
	    Account account = new Account();
	    account.loginId = dto.getLoginId();
	    account.password = dto.getPassword();
	    account.name = dto.getName();
	    account.address = dto.getAddress();
	    account.phoneNumber = dto.getPhoneNumber();

	    return account;
	  }
}
