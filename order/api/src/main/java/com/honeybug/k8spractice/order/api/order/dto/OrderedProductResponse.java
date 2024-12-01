package com.honeybug.k8spractice.order.api.order.dto;

import jakarta.validation.constraints.NotNull;

public record OrderedProductResponse(
        @NotNull Long productId,
        @NotNull String name
) {
}
