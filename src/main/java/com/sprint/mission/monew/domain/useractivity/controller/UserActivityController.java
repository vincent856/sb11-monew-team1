package com.sprint.mission.monew.domain.useractivity.controller;

import com.sprint.mission.monew.domain.useractivity.dto.UserActivityResponse;
import com.sprint.mission.monew.domain.useractivity.service.UserActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user-activities")
@RequiredArgsConstructor
public class UserActivityController implements UserActivityApi {

  private final UserActivityService userActivityService;

  @GetMapping("/{userId}")
  public ResponseEntity<UserActivityResponse> getUserActivity(
      @PathVariable UUID userId
  ) {
    return ResponseEntity.ok(userActivityService.getUserActivity(userId));
  }
}