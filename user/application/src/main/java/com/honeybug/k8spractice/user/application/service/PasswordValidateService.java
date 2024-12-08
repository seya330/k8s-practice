package com.honeybug.k8spractice.user.application.service;

import com.honeybug.k8spractice.user.application.port.in.PasswordValidateUseCase;
import com.honeybug.k8spractice.user.application.port.out.UserPasswordFindPort;
import com.honeybug.k8spractice.user.core.domain.UserPassword;
import com.honeybug.k8spractice.user.core.exception.InvalidUserPasswordException;
import com.honeybug.k8spractice.user.core.exception.UserPasswordNotMatchedException;
import com.honeybug.k8spractice.user.core.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PasswordValidateService implements PasswordValidateUseCase {

    private final UserPasswordFindPort userPasswordFindPort;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void validateForLogin(final UserId userId, final String password) {
        Objects.requireNonNull(userId);
        Objects.requireNonNull(password);

        final UserPassword userPassword = userPasswordFindPort.getByUserId(userId);
        if (!passwordEncoder.matches(password, userPassword.password())) {
            throw new UserPasswordNotMatchedException();
        }
    }

    @Override
    public void validateForRegister(String password) {
        if (password == null) {
            throw new InvalidUserPasswordException();
        }

        int length = password.length();
        if (length < 6 || length > 10) {
            throw new InvalidUserPasswordException();
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        int count = 0;
        if (hasLower) count++;
        if (hasUpper) count++;
        if (hasDigit) count++;

        if (count < 2) {
            throw new InvalidUserPasswordException();
        }
    }
}
