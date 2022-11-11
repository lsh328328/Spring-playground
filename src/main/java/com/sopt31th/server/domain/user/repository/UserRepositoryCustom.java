package com.sopt31th.server.domain.user.repository;

public interface UserRepositoryCustom {
    boolean existsByEmailOrContact(String emailOrContact);
}
