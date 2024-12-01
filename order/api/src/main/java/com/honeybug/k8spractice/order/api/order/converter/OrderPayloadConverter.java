package com.honeybug.k8spractice.order.api.order.converter;

import com.honeybug.k8spractice.order.api.order.dto.DetailedOrderResponse;
import com.honeybug.k8spractice.order.application.dto.DetailedOrder;
import org.mapstruct.Mapper;

@Mapper
public interface OrderPayloadConverter {

    DetailedOrderResponse convertToResponse(DetailedOrder source);
}
