package com.sopt31th.server.controller.auth;

import com.sopt31th.server.common.dto.ApiResponse;
import com.sopt31th.server.common.exception.SuccessCode;
import com.sopt31th.server.controller.auth.dto.request.LoginRequest;
import com.sopt31th.server.controller.auth.dto.request.SignupRequest;
import com.sopt31th.server.controller.auth.dto.response.LoginResponse;
import com.sopt31th.server.controller.auth.dto.response.SignupResponse;
import com.sopt31th.server.service.auth.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @ApiOperation("회원가입 페이지 - 회원가입을 요청합니다.")
    @PostMapping("/v1/signup")
    public ApiResponse<SignupResponse> signup(@Valid @RequestBody final SignupRequest request) {
        final Long userId = authService.createUser(request);
        return ApiResponse.success(SuccessCode.SIGNUP_SUCCESS, SignupResponse.of(userId, request.getEmailOrContact()));
    }

    @ApiOperation("로그인 페이지 - 로그인을 요청합니다.")
    @PostMapping("/v1/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody final LoginRequest request) {
        final Long userId = authService.login(request);
        return ApiResponse.success(SuccessCode.LOGIN_SUCCESS, LoginResponse.of(userId, request.getEmailOrContact()));
    }
}
