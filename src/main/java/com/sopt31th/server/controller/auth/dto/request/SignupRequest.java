package com.sopt31th.server.controller.auth.dto.request;

import com.sopt31th.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequest {
    private String emailOrContact;

    private String password;

    private String passwordCheck;

    @Builder
    public SignupRequest(String emailOrContact, String password, String passwordCheck) {
        this.emailOrContact = emailOrContact;
        this.password = password;
        this.passwordCheck = passwordCheck;
    }

    public User toEntity() {
        return User.builder()
                .emailOrContact(emailOrContact)
                .password(password)
                .build();
    }
}
