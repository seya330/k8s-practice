package com.honeybug.k8spractice.user.application.service;

import com.honeybug.k8spractice.user.application.dto.UserRegisterCommand;
import com.honeybug.k8spractice.user.application.port.in.PasswordValidateUseCase;
import com.honeybug.k8spractice.user.application.port.in.UserRegisterUseCase;
import com.honeybug.k8spractice.user.application.port.out.UserFindByEmailPort;
import com.honeybug.k8spractice.user.application.port.out.UserPasswordSavePort;
import com.honeybug.k8spractice.user.application.port.out.UserSavePort;
import com.honeybug.k8spractice.user.core.domain.UserInfo;
import com.honeybug.k8spractice.user.core.domain.UserPassword;
import com.honeybug.k8spractice.user.core.exception.DuplicatedUserEmailException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUseCase {

    private final PasswordValidateUseCase passwordValidateUseCase;

    private final UserSavePort userSavePort;

    private final UserPasswordSavePort userPasswordSavePort;

    private final UserFindByEmailPort userFindByEmailPort;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserInfo register(@Valid final UserRegisterCommand command) {
        passwordValidateUseCase.validateForRegister(command.password());
        userFindByEmailPort.execute(command.email()).ifPresent(e -> {
            throw new DuplicatedUserEmailException();
        });
        final UserInfo userInfo = UserInfo.builder()
                .name(command.name())
                .email(command.email())
                .phoneNumber(command.phoneNumber())
                .userType(command.userType())
                .build();
        final UserInfo saved = userSavePort.save(userInfo);
        userPasswordSavePort.save(new UserPassword(saved.getUserId(), passwordEncoder.encode(command.password())));
        return saved;
    }
}
