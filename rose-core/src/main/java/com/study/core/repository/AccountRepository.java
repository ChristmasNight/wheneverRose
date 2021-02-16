package com.study.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.core.common.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	//아이디를 사용하여 회원정보를 검색
	Optional<Account> findByLoginId(String loginId);
}
