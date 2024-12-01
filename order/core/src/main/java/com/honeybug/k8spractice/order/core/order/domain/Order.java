package com.honeybug.k8spractice.order.core.order.domain;

import com.honeybug.k8spractice.order.core.order.valueobject.OrderId;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Order {

    private OrderId orderId;

    private String orderNumber;

    private List<Long> orderedProducts;
}
