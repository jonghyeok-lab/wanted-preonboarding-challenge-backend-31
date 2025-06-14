package com.wanted.cqrs.service.mapper;

import com.wanted.cqrs.entity.ProductImage;
import com.wanted.cqrs.service.request.ProductServiceRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public List<ProductImage> toProductImageEntity(ProductServiceRequest.CreateProduct createProduct) {
        return createProduct.getProductImage().stream()
                .map(dto -> ProductImage.builder()
                        .url(dto.getUrl())
                        .altText(dto.getAltText())
                        .isPrimary(dto.isPrimary())
                        .displayOrder(dto.getDisplayOrder())
                        .build())
                .toList();
    }
}
