package com.honeybug.k8spractice.order.application.service;

import com.honeybug.k8spractice.order.application.converter.OrderConverter;
import com.honeybug.k8spractice.order.application.dto.DetailedOrder;
import com.honeybug.k8spractice.order.application.dto.GetOrderCommand;
import com.honeybug.k8spractice.order.application.port.in.GetOrderUseCase;
import com.honeybug.k8spractice.order.application.port.out.LoadOrderPort;
import com.honeybug.k8spractice.order.application.port.out.LoadProductPort;
import com.honeybug.k8spractice.order.core.order.domain.Order;
import com.honeybug.k8spractice.order.core.product.vo.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderService implements GetOrderUseCase {

    private final LoadProductPort loadProductPort;

    private final LoadOrderPort loadOrderPort;

    private final OrderConverter orderConverter;

    @Override
    public DetailedOrder get(final GetOrderCommand command) {
        final Order order = loadOrderPort.getOrder(command.orderId());
        final List<Product> products = loadProductPort.getProducts(order.getOrderedProducts());
        return orderConverter.mapToDetailedOrder(order, products);
    }
}
