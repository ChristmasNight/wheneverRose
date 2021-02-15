package com.study.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.core.common.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	  Optional<Account> findByLoginId(String loginId);
}
