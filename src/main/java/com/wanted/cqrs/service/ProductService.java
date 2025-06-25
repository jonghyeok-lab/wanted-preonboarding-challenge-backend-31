package com.wanted.cqrs.service;

import com.wanted.cqrs.entity.Product;
import com.wanted.cqrs.entity.ProductDetail;
import com.wanted.cqrs.entity.ProductImage;
import com.wanted.cqrs.entity.ProductPrice;
import com.wanted.cqrs.repository.*;
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
    private final ProductDetailRepository productDetailRepository;
    private final ProductPriceRepository productPriceRepository;


    @Transactional
    public void create(ProductServiceRequest.CreateProduct createProduct, Long sellerId, Long brandId) {
//        sellerRepository.findById(sellerId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid sellerId: " + sellerId));
//
//        brandRepository.findById(brandId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid brandId: " + brandId));

        // 상품
        Product product = productMapper.toProductEntity(createProduct, sellerId, brandId);
        productRepository.save(product);

        // 상품 상세
        ProductDetail productDetail = productMapper.toProductDetailEntity(createProduct, product);
        productDetailRepository.save(productDetail);

        // 상품 가격
        ProductPrice productPrice = productMapper.toProductPriceEntity(createProduct, product);
        productPriceRepository.save(productPrice);

        // 상품 이미지
        List<ProductImage> productImage = productMapper.toProductImageEntity(createProduct, product);
        productImageRepository.saveAll(productImage);


    }
}
