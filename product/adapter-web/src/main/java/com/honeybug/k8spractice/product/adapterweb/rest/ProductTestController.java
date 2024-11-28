package com.honeybug.k8spractice.product.adapterweb.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ProductTestController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello Product");
    }
}
