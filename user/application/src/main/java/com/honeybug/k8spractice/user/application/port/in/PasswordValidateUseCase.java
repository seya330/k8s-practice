package com.honeybug.k8spractice.user.application.port.in;

import com.honeybug.k8spractice.user.core.valueobject.UserId;
import jakarta.validation.constraints.NotEmpty;

public interface PasswordValidateUseCase {

    void validateForLogin(@NotEmpty UserId userId, @NotEmpty String password);

    void validateForRegister(@NotEmpty String password);
}
