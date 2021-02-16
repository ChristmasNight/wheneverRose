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
	//login id가 없을 경우 오류 메세지 설정
    Account account = accountRepository.findByLoginId(loginId)
        .orElseThrow(() -> new UsernameNotFoundException("user name not found."));
    //user에 회원정보에 들어있는 id, pw, 권한을 저장시킨다.
    return new User(account.getLoginId(), account.getPassword(), authorities());
  }
  
  //비밀번호 암호화하여 저장
  public Account signUp(AccountDto.SingUp dto) {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
    return accountRepository.save(Account.signUp(dto));
  }
  
  //계정이 갖고 있는 권한 목록을 리턴
  private Collection<? extends GrantedAuthority> authorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

    return authorities;
  }
}
