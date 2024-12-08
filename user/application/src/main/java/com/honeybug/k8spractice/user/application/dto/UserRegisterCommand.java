package com.honeybug.k8spractice.user.application.dto;

import com.honeybug.k8spractice.user.core.valueobject.PhoneNumber;
import com.honeybug.k8spractice.user.core.valueobject.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRegisterCommand(
        @NotEmpty String name,
        @Email String email,
        @NotNull PhoneNumber phoneNumber,
        @NotNull UserType userType,
        @NotEmpty String password
) {
}
