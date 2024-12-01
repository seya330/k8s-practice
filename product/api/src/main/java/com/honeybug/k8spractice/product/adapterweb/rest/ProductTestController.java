package com.honeybug.k8spractice.product.adapterweb.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductTestController {


    @GetMapping
    public ResponseEntity<String> getProducts() {
        return ResponseEntity.ok("Hello Product");
    }
}
