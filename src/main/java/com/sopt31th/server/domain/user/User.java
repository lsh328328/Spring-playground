package com.sopt31th.server.domain.user;

import com.sopt31th.server.domain.common.AuditingTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailOrContact;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String emailOrContact, String password) {
        this.emailOrContact = emailOrContact;
        this.password = password;
    }
}
