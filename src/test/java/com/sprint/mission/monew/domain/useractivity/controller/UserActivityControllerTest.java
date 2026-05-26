package com.sprint.mission.monew.domain.useractivity.controller;

import com.sprint.mission.monew.domain.useractivity.dto.UserActivityResponse;
import com.sprint.mission.monew.domain.useractivity.service.UserActivityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserActivityController.class)
class UserActivityControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private UserActivityService userActivityService;

  @Nested
  @DisplayName("GET /api/user-activities/{userId} - 사용자 활동 내역 조회")
  class 사용자_활동_내역_조회 {

    @Test
    @DisplayName("성공 시 200 반환")
    void 성공_시_200_반환() throws Exception {
      // given
      UUID userId = UUID.randomUUID();
      UserActivityResponse response = new UserActivityResponse(
          userId, "test@test.com", "테스터", Instant.now(),
          List.of(), List.of(), List.of(), List.of()
      );
      given(userActivityService.getUserActivity(userId)).willReturn(response);

      // when & then
      mockMvc.perform(get("/api/user-activities/{userId}", userId)
              .header("Monew-Request-User-ID", UUID.randomUUID()))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id").value(userId.toString()));
    }

    @Test
    @DisplayName("존재하지 않는 사용자 조회 시 404 반환")
    void 존재하지_않는_사용자_조회_시_404_반환() throws Exception {
      // given
      UUID userId = UUID.randomUUID();
      given(userActivityService.getUserActivity(userId))
          .willThrow(new RuntimeException("사용자를 찾을 수 없습니다."));

      // when & then
      mockMvc.perform(get("/api/user-activities/{userId}", userId)
              .header("Monew-Request-User-ID", UUID.randomUUID()))
          .andExpect(status().isNotFound());
    }
  }
}