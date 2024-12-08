package com.honeybug.k8spractice.user.adapterpersistence.converter;

import com.honeybug.k8spractice.user.adapterpersistence.entity.UserInfoEntity;
import com.honeybug.k8spractice.user.adapterpersistence.entity.UserPasswordEntity;
import com.honeybug.k8spractice.user.core.domain.UserInfo;
import com.honeybug.k8spractice.user.core.domain.UserPassword;
import com.honeybug.k8spractice.user.core.valueobject.PhoneNumber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserInfoPersistenceConverter {

    @Mapping(target = "userId.id", source = "userId")
    UserInfo convert(UserInfoEntity source);

    @Mapping(target = "userId", source = "userId.id")
    UserInfoEntity convert(UserInfo source);

    @Mapping(target = "userId.id", source = "userId")
    UserPassword convert(UserPasswordEntity source);

    @Mapping(target = "userId", source = "userId.id")
    @Mapping(target = "id", ignore = true)
    UserPasswordEntity convert(UserPassword source);

    default PhoneNumber toPhoneNumber(String source) {
        return PhoneNumber.of(source);
    }

    default String toPhoneNumber(PhoneNumber source) {
        return source.toString();
    }
}
