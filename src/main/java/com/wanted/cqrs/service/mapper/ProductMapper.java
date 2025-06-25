package com.wanted.cqrs.service.mapper;

import com.wanted.cqrs.entity.*;
import com.wanted.cqrs.service.request.ProductServiceRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

    public ProductDetail toProductDetailEntity(
            ProductServiceRequest.CreateProduct createProduct,
            Product product
    ) {
        ProductServiceRequest.ProductDetail productDetailDto = createProduct.getProductDetail();
        return ProductDetail.builder()
                .weight(BigDecimal.valueOf(productDetailDto.getWeight()))
                .product(product)
                .dimensions(productDetailDto.getDimensions())
                .additionalInfo(productDetailDto.getAdditionalInfo())
                .careInstructions(productDetailDto.getCareInstructions())
                .countryOfOrigin(productDetailDto.getCountryOfOrigin())
                .materials(productDetailDto.getMaterials())
                .warrantyInfo(productDetailDto.getWarrantyInfo())
                .build();
    }

    public ProductPrice toProductPriceEntity(ProductServiceRequest.CreateProduct createProduct, Product product) {
        ProductServiceRequest.ProductPrice productPriceDto = createProduct.getProductPrice();

        return ProductPrice.builder()
                .taxRate(productPriceDto.getTaxRate())
                .basePrice(productPriceDto.getBasePrice())
                .salePrice(productPriceDto.getSalePrice())
                .currency(productPriceDto.getCurrency())
                .costPrice(productPriceDto.getCostPrice())
                .product(product)
                .build();
    }
}
