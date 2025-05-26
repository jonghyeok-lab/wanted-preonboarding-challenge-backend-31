package com.wanted.cqrs.product;

import com.wanted.cqrs.common.response.ApiErrorResponse;
import com.wanted.cqrs.product.request.ProductCreateRequest;
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

    private final ProductControllerMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductCreateRequest request) {
        productService.create(productMapper.toProduct(request));
    }
}
