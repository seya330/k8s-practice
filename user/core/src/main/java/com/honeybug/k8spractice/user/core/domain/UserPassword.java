package com.honeybug.k8spractice.user.core.domain;

import com.honeybug.k8spractice.user.core.valueobject.UserId;

public record UserPassword(
        UserId userId,
        String password
) {
}