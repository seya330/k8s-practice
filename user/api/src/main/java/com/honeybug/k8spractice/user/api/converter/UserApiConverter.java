package com.honeybug.k8spractice.user.api.converter;

import com.honeybug.k8spractice.user.api.dto.UserRegisterRequest;
import com.honeybug.k8spractice.user.application.dto.UserRegisterCommand;
import com.honeybug.k8spractice.user.core.valueobject.PhoneNumber;
import org.mapstruct.Mapper;

@Mapper
public interface UserApiConverter {

    UserRegisterCommand convert(UserRegisterRequest source);

    default PhoneNumber convert(String source) {
        return PhoneNumber.of(source);
    }
}
