package com.sopt31th.server.controller.auth.dto.request;

import com.sopt31th.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignupRequest {

    @NotBlank
    private String emailOrContact;

    @NotBlank
    private String password;

    @NotBlank
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
