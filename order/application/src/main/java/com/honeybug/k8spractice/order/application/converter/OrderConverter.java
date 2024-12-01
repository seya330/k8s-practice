package com.honeybug.k8spractice.order.application.converter;

import com.honeybug.k8spractice.order.application.dto.DetailedOrder;
import com.honeybug.k8spractice.order.core.order.domain.Order;
import com.honeybug.k8spractice.order.core.product.vo.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface OrderConverter {

    @Mapping(target = "orderedProducts", source = "orderedProducts")
    DetailedOrder mapToDetailedOrder(Order order, List<Product> orderedProducts);
}
