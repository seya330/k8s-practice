package com.honeybug.k8spractice.order.application.port.out;

import com.honeybug.k8spractice.order.core.product.vo.Product;

import java.util.List;

public interface LoadProductPort {

    List<Product> getProducts(List<Long> orderedProductIds);
}
