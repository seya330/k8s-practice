package com.honeybug.k8spractice.order.api.order.rest;

import com.honeybug.k8spractice.order.api.order.converter.OrderPayloadConverter;
import com.honeybug.k8spractice.order.api.order.dto.DetailedOrderResponse;
import com.honeybug.k8spractice.order.application.dto.DetailedOrder;
import com.honeybug.k8spractice.order.application.dto.GetOrderCommand;
import com.honeybug.k8spractice.order.application.port.in.GetOrderUseCase;
import com.honeybug.k8spractice.order.core.order.valueobject.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final GetOrderUseCase getOrderUseCase;

    private final OrderPayloadConverter orderPayloadConverter;

    @GetMapping
    public ResponseEntity<DetailedOrderResponse> getOrders() {
        final DetailedOrder detailedOrder = getOrderUseCase.get(new GetOrderCommand(new OrderId(1)));
        return ResponseEntity.ok(orderPayloadConverter.convertToResponse(detailedOrder));
    }
}
