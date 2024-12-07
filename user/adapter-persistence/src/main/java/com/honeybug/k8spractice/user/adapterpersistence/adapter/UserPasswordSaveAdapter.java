package com.honeybug.k8spractice.user.adapterpersistence.adapter;

import com.honeybug.k8spractice.user.adapterpersistence.converter.UserInfoPersistenceConverter;
import com.honeybug.k8spractice.user.adapterpersistence.entity.UserPasswordEntity;
import com.honeybug.k8spractice.user.adapterpersistence.jpa.UserPasswordEntityJpaRepository;
import com.honeybug.k8spractice.user.application.port.out.UserPasswordSavePort;
import com.honeybug.k8spractice.user.core.domain.UserPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPasswordSaveAdapter implements UserPasswordSavePort {

    private final UserPasswordEntityJpaRepository userPasswordEntityJpaRepository;

    private final UserInfoPersistenceConverter userInfoPersistenceConverter;

    @Override
    public UserPassword save(UserPassword userPassword) {
        final UserPasswordEntity saved = userPasswordEntityJpaRepository.save(userInfoPersistenceConverter.convert(userPassword));
        return userInfoPersistenceConverter.convert(saved);
    }
}
