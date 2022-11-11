package com.sopt31th.server.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.LockModeType;

import static com.sopt31th.server.domain.user.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existsByEmailOrContact(String emailOrContact) {
        return queryFactory.selectOne()
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .setHint("javax.persistence.lock.timeout", 3000)
                .from(user)
                .where(user.emailOrContact.eq(emailOrContact))
                .fetchFirst() != null;
    }
}
