package com.honeybug.k8spractice.order.application.dto;

import com.honeybug.k8spractice.order.core.order.valueobject.OrderId;
import jakarta.validation.constraints.NotNull;

public record GetOrderCommand(
        @NotNull OrderId orderId
) {
}
