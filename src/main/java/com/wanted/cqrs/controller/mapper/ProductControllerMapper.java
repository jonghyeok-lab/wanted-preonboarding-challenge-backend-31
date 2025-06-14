package com.wanted.cqrs.controller.mapper;

import com.wanted.cqrs.controller.dto.ProductCreateRequest;
import com.wanted.cqrs.service.request.ProductServiceRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductControllerMapper {

    public ProductServiceRequest.CreateProduct toCreateProduct(ProductCreateRequest request) {
        return ProductServiceRequest.CreateProduct.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .shortDescription(request.getShortDescription())
                .fullDescription(request.getFullDescription())
                .status(request.getStatus())
                .productDetail(toProductDetail(request.getDetail()))
                .productPrice(toProductPrice(request.getPrice()))
                .productOptionGroup(request.getOptionGroups().stream().map(this::toProductOptionGroup).toList())
                .productImage(request.getImages().stream().map(this::toProductImage).toList())
                .tags(request.getTags())
                .build();
    }

    public ProductServiceRequest.ProductDetail toProductDetail(ProductCreateRequest.ProductDetail detail) {
        return ProductServiceRequest.ProductDetail.builder()
                .weight(detail.getWeight())
                .dimensions(detail.getDimensions())
                .materials(detail.getMaterials())
                .countryOfOrigin(detail.getCountryOfOrigin())
                .warrantyInfo(detail.getWarrantyInfo())
                .careInstructions(detail.getCareInstructions())
                .additionalInfo(detail.getAdditionalInfo())
                .build();
    }

    public ProductServiceRequest.ProductPrice toProductPrice(ProductCreateRequest.ProductPrice price) {
        return ProductServiceRequest.ProductPrice.builder()
                .basePrice(price.getBasePrice())
                .salePrice(price.getSalePrice())
                .costPrice(price.getCostPrice())
                .currency(price.getCurrency())
                .taxRate(price.getTaxRate())
                .build();
    }


    public ProductServiceRequest.ProductOptionGroup toProductOptionGroup(ProductCreateRequest.ProductOptionGroup optionGroup) {
        return ProductServiceRequest.ProductOptionGroup.builder()
                .name(optionGroup.getName())
                .displayOrder(optionGroup.getDisplayOrder())
                .options(optionGroup.getOptions().stream().map(this::toProductOption).toList())
                .build();
    }

    public ProductServiceRequest.ProductOption toProductOption(ProductCreateRequest.ProductOption option) {
        return ProductServiceRequest.ProductOption.builder()
                .name(option.getName())
                .additionalPrice(option.getAdditionalPrice())
                .sku(option.getSku())
                .stock(option.getStock())
                .displayOrder(option.getDisplayOrder())
                .build();
    }

    public ProductServiceRequest.ProductImage toProductImage(ProductCreateRequest.ProductImage image) {
        return ProductServiceRequest.ProductImage.builder()
                .url(image.getUrl())
                .altText(image.getAltText())
                .isPrimary(image.isPrimary())
                .displayOrder(image.getDisplayOrder())
                .optionId(image.getOptionId())
                .build();
    }
}
