package com.honeybug.k8spractice.order.adapterweb.client;

import com.honeybug.k8spractice.order.adapterweb.config.FeignConfig;
import com.honeybug.k8spractice.order.adapterweb.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "productClient", url = "${resource.product.api-url}", configuration = FeignConfig.class)
public interface ProductFeignClient {

    @GetMapping("/api/products")
    ResponseEntity<List<ProductResponse>> getProducts();
}
