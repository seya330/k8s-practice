package com.honeybug.k8spractice.order.api;

import com.honeybug.k8spractice.order.application.port.out.LoadProductPort;
import com.honeybug.k8spractice.order.core.product.vo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadProductWebAdapter implements LoadProductPort {

    @Override
    public List<Product> getProducts(final List<Long> orderedProductIds) {
        return List.of(
                new Product(1L, "상품1"),
                new Product(1L, "상품2"),
                new Product(1L, "상품3")
        );
    }
}
