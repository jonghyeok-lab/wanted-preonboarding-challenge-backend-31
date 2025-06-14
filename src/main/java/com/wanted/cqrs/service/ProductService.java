package com.wanted.cqrs.service;

import com.wanted.cqrs.entity.ProductImage;
import com.wanted.cqrs.repository.BrandRepository;
import com.wanted.cqrs.repository.SellerRepository;
import com.wanted.cqrs.service.request.ProductServiceRequest;
import com.wanted.cqrs.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final SellerRepository sellerRepository;
    private final BrandRepository brandRepository;


    public void create(ProductServiceRequest.CreateProduct createProduct, Long sellerId, Long brandId) {
        sellerRepository.findById(sellerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sellerId: " + sellerId));

        brandRepository.findById(brandId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid brandId: " + brandId));

        List<ProductImage> productImage = productMapper.toProductImageEntity(createProduct);

    }
}
