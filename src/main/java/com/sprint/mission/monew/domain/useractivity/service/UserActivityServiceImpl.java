package com.sprint.mission.monew.domain.useractivity.service;

import com.sprint.mission.monew.domain.useractivity.dto.UserActivityResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserActivityServiceImpl implements UserActivityService {

  @Override
  public UserActivityResponse getUserActivity(UUID userId) {
    log.debug("사용자 활동 내역 조회 시도: userId={}", userId);

    // TODO: 구현 예정 (다른 팀원 엔티티 완성 후)

    log.info("사용자 활동 내역 조회 완료: userId={}", userId);
    return null;
  }
}