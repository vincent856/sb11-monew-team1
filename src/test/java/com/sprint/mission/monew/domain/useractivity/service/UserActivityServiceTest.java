package com.sprint.mission.monew.domain.useractivity.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserActivityServiceTest {

  @InjectMocks
  private UserActivityServiceImpl userActivityService;

  @Nested
  @DisplayName("사용자 활동 내역 조회")
  class 사용자_활동_내역_조회 {

    @Test
    @DisplayName("성공 시 활동 내역 반환")
    void 성공_시_활동_내역_반환() {
      // given
      UUID userId = UUID.randomUUID();

      // when
      // TODO: 엔티티 완성 후 구현

      // then
      // TODO: 엔티티 완성 후 구현
    }

    @Test
    @DisplayName("존재하지 않는 사용자 조회 시 예외 발생")
    void 존재하지_않는_사용자_조회_시_예외_발생() {
      // given
      UUID userId = UUID.randomUUID();

      // when & then
      // TODO: 엔티티 완성 후 구현
    }
  }
}