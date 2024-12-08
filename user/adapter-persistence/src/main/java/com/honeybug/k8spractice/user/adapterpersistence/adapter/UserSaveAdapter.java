package com.honeybug.k8spractice.user.adapterpersistence.adapter;

import com.honeybug.k8spractice.user.adapterpersistence.converter.UserInfoPersistenceConverter;
import com.honeybug.k8spractice.user.adapterpersistence.entity.UserInfoEntity;
import com.honeybug.k8spractice.user.adapterpersistence.jpa.UserInfoEntityJpaRepository;
import com.honeybug.k8spractice.user.application.port.out.UserSavePort;
import com.honeybug.k8spractice.user.core.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSaveAdapter implements UserSavePort {

    private final UserInfoEntityJpaRepository userInfoEntityJpaRepository;

    private final UserInfoPersistenceConverter userInfoPersistenceConverter;

    @Override
    @Transactional
    public UserInfo save(UserInfo userInfo) {
        final UserInfoEntity saved = userInfoEntityJpaRepository.save(userInfoPersistenceConverter.convert(userInfo));
        return userInfoPersistenceConverter.convert(saved);
    }
}
