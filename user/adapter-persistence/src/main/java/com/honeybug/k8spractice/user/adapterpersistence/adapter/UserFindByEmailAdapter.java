package com.honeybug.k8spractice.user.adapterpersistence.adapter;

import com.honeybug.k8spractice.user.adapterpersistence.converter.UserInfoPersistenceConverter;
import com.honeybug.k8spractice.user.adapterpersistence.jpa.UserInfoEntityJpaRepository;
import com.honeybug.k8spractice.user.application.port.out.UserFindByEmailPort;
import com.honeybug.k8spractice.user.core.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFindByEmailAdapter implements UserFindByEmailPort {

    private final UserInfoEntityJpaRepository userInfoEntityJpaRepository;

    private final UserInfoPersistenceConverter userInfoPersistenceConverter;

    @Override
    public Optional<UserInfo> execute(String email) {
        return userInfoEntityJpaRepository.findByEmail(email)
                .map(userInfoPersistenceConverter::convert);
    }
}
