package com.study.core.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaleStatus {

  SALE("판매중"),
  PREPARING("입고 준비중"),
  SOLD_OUT("품절");

  private final String message;
}
