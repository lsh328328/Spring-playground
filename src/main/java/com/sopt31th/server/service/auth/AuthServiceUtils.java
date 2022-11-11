package com.sopt31th.server.service.auth;

import com.sopt31th.server.common.exception.ErrorCode;
import com.sopt31th.server.common.exception.model.ConflictException;
import com.sopt31th.server.domain.user.UserRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthServiceUtils {
    static void validateNotExistsUser(UserRepository userRepository, String emailOrContact) {
        if (userRepository.existsByEmailOrContact(emailOrContact)) {
            throw new ConflictException(String.format("이미 존재하는 유저 (%s) 입니다.", emailOrContact), ErrorCode.CONFLICT_USER_EXCEPTION);
        }
    }
}
