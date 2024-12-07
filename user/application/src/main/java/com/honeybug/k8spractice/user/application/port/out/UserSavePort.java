package com.honeybug.k8spractice.user.application.port.out;

import com.honeybug.k8spractice.user.core.domain.UserInfo;

public interface UserSavePort {

    UserInfo save(UserInfo userInfo);
}
