package com.sopt31th.server.service.auth;

import com.sopt31th.server.controller.auth.dto.request.LoginRequest;
import com.sopt31th.server.controller.auth.dto.request.SignupRequest;
import com.sopt31th.server.domain.user.User;
import com.sopt31th.server.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;

    @Transactional
    public Long createUser(SignupRequest request) {
        AuthServiceUtils.validateNotExistsUser(userRepository, request.getEmailOrContact());
        return userRepository.save(request.toEntity()).getId();
    }

    @Transactional
    public Long login(LoginRequest request) {
        AuthServiceUtils.validateExistsUser(userRepository, request.getEmailOrContact());
        AuthServiceUtils.validateMatchPassword(userRepository, request.getEmailOrContact(), request.getPassword());
        User user = userRepository.existsUser(request.getEmailOrContact());
        return user.getId();
    }
}
