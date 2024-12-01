package com.honeybug.k8spractice.order.application.port.out;

import com.honeybug.k8spractice.order.core.order.domain.Order;
import com.honeybug.k8spractice.order.core.order.valueobject.OrderId;

public interface LoadOrderPort {

    Order getOrder(OrderId orderId);
}
