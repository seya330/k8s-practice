package com.honeybug.k8spractice.user.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserResponse(
        @NotEmpty String accessToken,
        @Email String email
) {
}
