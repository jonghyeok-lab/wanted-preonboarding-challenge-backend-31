package com.wanted.cqrs.service.mapper;

import com.wanted.cqrs.entity.Product;
import com.wanted.cqrs.entity.ProductImage;
import com.wanted.cqrs.entity.ProductStatus;
import com.wanted.cqrs.service.request.ProductServiceRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public List<ProductImage> toProductImageEntity(
            ProductServiceRequest.CreateProduct createProduct,
            Product product
    ) {
        return createProduct.getProductImage().stream()
                .map(dto -> ProductImage.builder()
                        .product(product)
                        .url(dto.getUrl())
                        .altText(dto.getAltText())
                        .isPrimary(dto.isPrimary())
                        .displayOrder(dto.getDisplayOrder())
                        .build())
                .toList();
    }

    public Product toProductEntity(
            ProductServiceRequest.CreateProduct createProduct,
            Long sellerId,
            Long brandId
    ) {
        return Product.builder()
                .name(createProduct.getName())
                .slug(createProduct.getSlug())
                .shortDescription(createProduct.getShortDescription())
                .fullDescription(createProduct.getFullDescription())
                .status(ProductStatus.valueOf(createProduct.getStatus()))
                .sellerId(sellerId)
                .brandId(brandId)
                .build();
    }
}
