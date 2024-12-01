package com.honeybug.k8spractice.order.api.order.dto;

import com.honeybug.k8spractice.order.core.order.valueobject.OrderId;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetailedOrderResponse(
        @NotNull OrderId orderId,
        @NotNull String orderNumber,
        @NotEmpty List<OrderedProductResponse> orderedProducts
) {
}
