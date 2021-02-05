package com.study.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.core.common.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
