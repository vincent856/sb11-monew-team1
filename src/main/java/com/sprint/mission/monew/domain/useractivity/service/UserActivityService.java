package com.sprint.mission.monew.domain.useractivity.service;

import com.sprint.mission.monew.domain.useractivity.dto.UserActivityResponse;

import java.util.UUID;

public interface UserActivityService {

  UserActivityResponse getUserActivity(UUID userId);
}