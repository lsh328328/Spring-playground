package com.sopt31th.server.domain.user.repository;

import com.sopt31th.server.domain.user.User;

public interface UserRepositoryCustom {
    boolean existsByEmailOrContact(String emailOrContact);
    User existsUser(String emailOrContact);
}
