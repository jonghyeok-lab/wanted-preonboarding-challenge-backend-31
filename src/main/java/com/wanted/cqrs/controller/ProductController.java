package com.wanted.cqrs.controller;

import com.wanted.cqrs.controller.mapper.ProductControllerMapper;
import com.wanted.cqrs.service.ProductService;
import com.wanted.cqrs.controller.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductControllerMapper productControllerMapper;
    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductCreateRequest request) {
        productService.create(productControllerMapper.toCreateProduct(request), request.getSellerId(), request.getBrandId());
    }
}
