package com.honeybug.k8spractice.order.adapterpersistence;

import com.honeybug.k8spractice.order.application.port.out.LoadOrderPort;
import com.honeybug.k8spractice.order.core.order.domain.Order;
import com.honeybug.k8spractice.order.core.order.valueobject.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadOrderAdapter implements LoadOrderPort {

    @Override
    public Order getOrder(OrderId orderId) {
        //todo mysql repository 필요
        return Order.builder()
                .orderId(new OrderId(1L))
                .orderNumber("12341223541234")
                .orderedProducts(List.of(1L, 2L, 3L))
                .build();
    }
}
