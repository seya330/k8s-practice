package com.honeybug.k8spractice.order.application.dto;

import jakarta.validation.constraints.NotNull;

public record OrderedProduct(
        @NotNull Long productId,
        @NotNull String name
) {
}
