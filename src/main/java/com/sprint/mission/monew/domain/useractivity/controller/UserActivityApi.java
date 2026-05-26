package com.sprint.mission.monew.domain.useractivity.controller;

import com.sprint.mission.monew.domain.useractivity.dto.UserActivityResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "UserActivity", description = "사용자 활동 내역 API")
public interface UserActivityApi {

  @Operation(summary = "사용자 활동 내역 조회")
  ResponseEntity<UserActivityResponse> getUserActivity(
      @PathVariable UUID userId
  );
}