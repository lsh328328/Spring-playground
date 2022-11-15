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

    //Music
    GET_MUSICLIST_SUCCESS(StatusCode.SUCCESS, "음악 리스트 조회에 성공했습니다."),
    REGISTER_MUSIC_SUCCESS(StatusCode.CREATED, "음악 생성에 성공했습니다."),

    //Chat
    GET_CHATLIST_SUCCESS(StatusCode.SUCCESS, "채팅 리스트 조회에 성공했습니다,"),
    ;

    private final StatusCode statusCode;
    private final String message;

    public int getStatus() {
        return statusCode.getStatus();
    }
}
