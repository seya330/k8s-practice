package com.honeybug.k8spractice.user.application.port.in;

import com.honeybug.k8spractice.user.application.dto.UserRegisterCommand;
import com.honeybug.k8spractice.user.core.domain.UserInfo;

public interface UserRegisterUseCase {

    UserInfo register(UserRegisterCommand command);
}
