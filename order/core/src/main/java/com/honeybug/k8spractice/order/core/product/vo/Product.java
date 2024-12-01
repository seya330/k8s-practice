package com.honeybug.k8spractice.order.core.product.vo;

import jakarta.validation.constraints.NotNull;

public record Product(
        @NotNull Long productId,
        @NotNull String name
) {
}
