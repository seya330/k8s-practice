package com.honeybug.k8spractice.order.application.port.in;

import com.honeybug.k8spractice.order.application.dto.DetailedOrder;
import com.honeybug.k8spractice.order.application.dto.GetOrderCommand;
import jakarta.validation.constraints.NotNull;

public interface GetOrderUseCase {

    DetailedOrder get(@NotNull GetOrderCommand command);
}
