package com.honeybug.k8spractice.user.adapterpersistence.adapter;

import com.honeybug.k8spractice.user.adapterpersistence.converter.UserInfoPersistenceConverter;
import com.honeybug.k8spractice.user.adapterpersistence.jpa.UserPasswordEntityJpaRepository;
import com.honeybug.k8spractice.user.application.port.out.UserPasswordFindPort;
import com.honeybug.k8spractice.user.core.domain.UserPassword;
import com.honeybug.k8spractice.user.core.exception.UserPasswordNotFoundException;
import com.honeybug.k8spractice.user.core.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPasswordFindAdapter implements UserPasswordFindPort {

    private final UserPasswordEntityJpaRepository userPasswordEntityJpaRepository;

    private final UserInfoPersistenceConverter userInfoPersistenceConverter;

    @Override
    public UserPassword getByUserId(UserId userId) {
        return userPasswordEntityJpaRepository.findByUserId(userId.id())
                .map(userInfoPersistenceConverter::convert)
                .orElseThrow(UserPasswordNotFoundException::new);
    }
}
