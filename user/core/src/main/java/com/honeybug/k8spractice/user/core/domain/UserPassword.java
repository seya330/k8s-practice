package com.honeybug.k8spractice.user.core.domain;

import com.honeybug.k8spractice.user.core.valueobject.UserId;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserPassword(
        @NotNull UserId userId,
        @NotEmpty String password
) {
}