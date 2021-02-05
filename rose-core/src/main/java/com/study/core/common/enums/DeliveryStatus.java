package com.study.core.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeliveryStatus {

  PROCESSED("상품 준비중"),
  READY("배달 준비 완료"),
  DELIVERY("배달 중"),
  COMPLETED("배달 완료"),
  CANCELED("취소");

  private final String message;
}
