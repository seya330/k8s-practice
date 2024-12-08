package com.honeybug.k8spractice.user.api.dto;

import com.honeybug.k8spractice.user.core.valueobject.UserType;
import jakarta.validation.constraints.*;

public record UserRegisterRequest(
        @NotEmpty String name,
        @Email String email,
        @Size(min = 11, max = 11) @Pattern(regexp = "^[0-9]+$") String phoneNumber,
        @NotEmpty String password,
        @NotNull UserType userType
) {
}
