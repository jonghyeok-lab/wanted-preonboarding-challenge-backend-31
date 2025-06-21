package com.wanted.cqrs.service;

import com.wanted.cqrs.entity.Product;
import com.wanted.cqrs.entity.ProductImage;
import com.wanted.cqrs.repository.BrandRepository;
import com.wanted.cqrs.repository.ProductImageRepository;
import com.wanted.cqrs.repository.ProductRepository;
import com.wanted.cqrs.repository.SellerRepository;
import com.wanted.cqrs.service.request.ProductServiceRequest;
import com.wanted.cqrs.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductMapper productMapper;
    private final SellerRepository sellerRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;


    @Transactional
    public void create(ProductServiceRequest.CreateProduct createProduct, Long sellerId, Long brandId) {
//        sellerRepository.findById(sellerId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid sellerId: " + sellerId));
//
//        brandRepository.findById(brandId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid brandId: " + brandId));

        Product product = productMapper.toProductEntity(createProduct, sellerId, brandId);
        Product savedProduct = productRepository.save(product);

        List<ProductImage> productImage = productMapper.toProductImageEntity(createProduct, savedProduct);
        productImageRepository.saveAll(productImage);
    }
}
