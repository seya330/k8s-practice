package com.honeybug.k8spractice.order.adapterweb.adapter;

import com.honeybug.k8spractice.order.adapterweb.client.ProductFeignClient;
import com.honeybug.k8spractice.order.adapterweb.converter.ProductConverter;
import com.honeybug.k8spractice.order.adapterweb.dto.ProductResponse;
import com.honeybug.k8spractice.order.application.port.out.LoadProductPort;
import com.honeybug.k8spractice.order.core.product.vo.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadProductWebAdapter implements LoadProductPort {

    private final ProductFeignClient productFeignClient;

    private final ProductConverter productConverter;

    @Override
    public List<Product> getProducts(final List<Long> orderedProductIds) {
        final ResponseEntity<List<ProductResponse>> products = productFeignClient.getProducts();
        return productConverter.convert(products.getBody());
    }
}
