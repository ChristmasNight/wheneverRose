package com.study.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.study.web.service.AccountService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final AccountService accountService;

  @Override
  public void configure(WebSecurity web) throws Exception {
    // static 하위 파일 목록은 인증 무시
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    //web.ignoring().antMatchers("/**"); => 이렇게하면 모든 페이지 인증 무시
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    	//로그인이 필요한 url을 정의(로그인, 회원가입) => 접근 허가
        .antMatchers("/api/account/login").permitAll()
        .antMatchers("/api/account/sign-up").permitAll()
        //.antMatchers("/api/account/sign-up").authenticated(); => 특정 페이지 접근 불가
        .anyRequest().authenticated()
        .and()
        .httpBasic();
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .permitAll()
//        .and()
//        .logout()
//        .permitAll();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
