package com.study.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account")
public class Account {	
	@Id
	@GeneratedValue
	@Column(name = "accountId", length = 100)
	
	  private long accountId;
	  private String accountPw;
	  private String accountName;
	  private String accountAddress1;
	  private String accountAddress2;
	  private String accountPhone;
}
