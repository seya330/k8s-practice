package com.honeybug.k8spractice.order.adapterweb.dto;

import jakarta.validation.constraints.NotNull;

public record ProductResponse(
        @NotNull Long productId,
        @NotNull String name
) {
}
