package com.study.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.core.common.entity.Account;
import com.study.core.dto.AccountDto;
import com.study.core.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

  private final AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    Account account = accountRepository.findByLoginId(loginId)
        .orElseThrow(() -> new UsernameNotFoundException("user name not found."));

    return new User(account.getLoginId(), account.getPassword(), authorities());
  }

  public Account signUp(AccountDto.SingUp dto) {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
    return accountRepository.save(Account.signUp(dto));
  }

  private Collection<? extends GrantedAuthority> authorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

    return authorities;
  }
}
