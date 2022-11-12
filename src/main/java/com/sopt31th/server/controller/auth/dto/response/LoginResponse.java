package com.sopt31th.server.controller.auth.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginResponse {

    private Long id;

    private String emailOrContact;

    public static LoginResponse of(Long id, String emailOrContact) {
        return new LoginResponse(id, emailOrContact);
    }
}
