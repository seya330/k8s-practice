package com.honeybug.k8spractice.user.application.port.in;

import com.honeybug.k8spractice.user.core.domain.UserInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public interface UserLoginUseCase {

    UserInfo login(@Email String email, @NotEmpty String password);
}
