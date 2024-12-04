package com.honeybug.k8spractice.product.adapterweb.rest;

import com.honeybug.k8spractice.product.adapterweb.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(List.of(
                new ProductResponse(1L, "아이템1"),
                new ProductResponse(2L, "아이템2"),
                new ProductResponse(3L, "아이템3")
        ));
    }
}
