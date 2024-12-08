package com.honeybug.k8spractice.user.application.port.out;

import com.honeybug.k8spractice.user.core.domain.UserInfo;

import java.util.Optional;

public interface UserFindByEmailPort {

    Optional<UserInfo> execute(String email);
}
