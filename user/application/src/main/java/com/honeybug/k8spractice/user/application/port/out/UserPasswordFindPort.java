package com.honeybug.k8spractice.user.application.port.out;

import com.honeybug.k8spractice.user.core.domain.UserPassword;
import com.honeybug.k8spractice.user.core.valueobject.UserId;

public interface UserPasswordFindPort {

    UserPassword getByUserId(UserId userId);
}
