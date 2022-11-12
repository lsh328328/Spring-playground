package com.sopt31th.server.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {
    TEST_SUCCESS(StatusCode.SUCCESS, "테스트가 완료되었습니다,"),

    SIGNUP_SUCCESS(StatusCode.CREATED, "회원가입이 완료되었습니다."),
    LOGIN_SUCCESS(StatusCode.SUCCESS, "로그인이 완료되었습니다."),
    ;

    private final StatusCode statusCode;
    private final String message;

    public int getStatus() {
        return statusCode.getStatus();
    }
}
