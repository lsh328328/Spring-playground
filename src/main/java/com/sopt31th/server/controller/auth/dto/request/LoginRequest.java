package com.sopt31th.server.controller.auth.dto.request;

import com.sopt31th.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    private String emailOrContact;

    @NotBlank
    private String password;

    @Builder
    public LoginRequest(String emailOrContact, String password) {
        this.emailOrContact = emailOrContact;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .emailOrContact(emailOrContact)
                .password(password)
                .build();
    }
}
