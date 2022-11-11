package com.sopt31th.server.domain.user;

import com.sopt31th.server.domain.user.repository.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
