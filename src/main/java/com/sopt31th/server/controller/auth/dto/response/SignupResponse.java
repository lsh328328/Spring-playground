package com.sopt31th.server.controller.auth.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResponse {
    private Long id;

    private String emailOrContact;

    public static SignupResponse of(Long id, String emailOrContact) {
        return new SignupResponse(id, emailOrContact);
    }
}
