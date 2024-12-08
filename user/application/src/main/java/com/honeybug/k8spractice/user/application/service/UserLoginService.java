package com.honeybug.k8spractice.user.application.service;

import com.honeybug.k8spractice.user.application.port.in.UserLoginUseCase;
import com.honeybug.k8spractice.user.application.port.out.UserFindByEmailPort;
import com.honeybug.k8spractice.user.application.port.in.PasswordValidateUseCase;
import com.honeybug.k8spractice.user.core.domain.UserInfo;
import com.honeybug.k8spractice.user.core.exception.UserEmailNotFoundException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserLoginUseCase {

    private final UserFindByEmailPort userFindByEmailPort;

    private final PasswordValidateUseCase passwordValidateUseCase;

    @Override
    @NotNull
    public UserInfo login(@Email String email, @NotEmpty String password) {
        final UserInfo user = userFindByEmailPort.execute(email)
                .orElseThrow(UserEmailNotFoundException::new);
        passwordValidateUseCase.validateForLogin(user.getUserId(), password);
        return user;
    }
}
