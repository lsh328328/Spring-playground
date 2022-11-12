package com.sopt31th.server.service.auth;

import com.sopt31th.server.common.exception.ErrorCode;
import com.sopt31th.server.common.exception.model.ConflictException;
import com.sopt31th.server.common.exception.model.ForbiddenException;
import com.sopt31th.server.common.exception.model.NotFoundException;
import com.sopt31th.server.domain.user.User;
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

    static void validateExistsUser(UserRepository userRepository, String emailOrContact) {
        if (!userRepository.existsByEmailOrContact(emailOrContact)) {
            throw new NotFoundException(String.format("존재하지 않는 유저 (%s) 입니다.", emailOrContact), ErrorCode.NOT_FOUND_EXCEPTION);
        }
    }

    static void validateMatchPassword(UserRepository userRepository, String emailOrContact, String password) {
        User user = userRepository.existsUser(emailOrContact);
        if (!password.equals(user.getPassword())) {
            throw new ForbiddenException(String.format("비밀번호가 일치하지 않습니다.", ErrorCode.FORBIDDEN_EXCEPTION));
        }
    }
}
