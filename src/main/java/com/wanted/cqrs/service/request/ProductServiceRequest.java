package com.wanted.cqrs.service.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductServiceRequest {

    @Getter
    @Builder
    public static class CreateProduct {
        private String name;
        private String slug;
        private String shortDescription;
        private String fullDescription;
        private String status;
        private ProductDetail productDetail;
        private ProductPrice productPrice;
        private List<ProductOptionGroup> productOptionGroup;
        private List<ProductImage> productImage;
        private List<Integer> tags;
    }

    @Getter
    @Builder
    public static class ProductDetail {

        private Double weight;
        private Map<String, Object> dimensions; // {"width": float, "height": float, "depth": float}
        private String materials;
        private String countryOfOrigin;
        private String warrantyInfo;
        private String careInstructions;
        private Map<String, Object> additionalInfo; // JSON object 추가 정보, {"assemblyRequired": boolean, "assemblyTime": string}
    }

    @Getter
    @Builder
    public static class ProductPrice {

        private BigDecimal basePrice;
        private BigDecimal salePrice;
        private BigDecimal costPrice;
        private String currency;
        private BigDecimal taxRate;
    }

    @Builder
    @Getter
    public static class Category {

        private Long categoryId;
        private boolean isPrimary;
    }

    @Builder
    @Getter
    public static class ProductOptionGroup {
        private String name;
        private Integer displayOrder;
        private List<ProductOption> options;
    }

    @Builder
    @Getter
    public static class ProductOption {
        private String name;
        private Integer additionalPrice;
        private String sku;
        private Integer stock;
        private Integer displayOrder;
    }

    @Builder
    @Getter
    public static class ProductImage {

        private String url;
        private String altText;
        private boolean isPrimary;
        private Integer displayOrder;
        private Integer optionId;
    }
}
