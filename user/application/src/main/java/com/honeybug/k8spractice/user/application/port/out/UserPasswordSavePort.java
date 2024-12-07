package com.honeybug.k8spractice.user.application.port.out;

import com.honeybug.k8spractice.user.core.domain.UserPassword;

public interface UserPasswordSavePort {

    UserPassword save(UserPassword userPassword);
}
