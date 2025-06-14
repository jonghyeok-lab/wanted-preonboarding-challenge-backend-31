package com.wanted.cqrs.controller.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductCreateRequest{
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private Long sellerId;
    private Long brandId;
    private String status;

    private ProductDetail detail;
    private ProductPrice price;
    private List<Category> categories;
    private List<ProductOptionGroup> optionGroups;
    private List<ProductImage> images;
    private List<Integer> tags;

    @AllArgsConstructor
    @Getter
    public static class ProductDetail {

        private Double weight;
        private Map<String, Object> dimensions; // {"width": float, "height": float, "depth": float}
        private String materials;
        private String countryOfOrigin;
        private String warrantyInfo;
        private String careInstructions;
        private Map<String, Object> additionalInfo; // JSON object 추가 정보, {"assemblyRequired": boolean, "assemblyTime": string}
    }

    @AllArgsConstructor
    @Getter
    public static class ProductPrice {

        private Long basePrice;
        private Long salePrice;
        private Long costPrice;
        private String currency;
        private Integer taxRate;
    }

    @AllArgsConstructor
    @Getter
    public static class Category {

        private Long categoryId;
        private boolean isPrimary;
    }

    @AllArgsConstructor
    @Getter
    public static class ProductOptionGroup {
        private String name;
        private Integer displayOrder;
        private List<ProductOption> options;
    }

    @AllArgsConstructor
    @Getter
    public static class ProductOption {
        private String name;
        private Integer additionalPrice;
        private String sku;
        private Integer stock;
        private Integer displayOrder;
    }

    @AllArgsConstructor
    @Getter
    public static class ProductImage {

        private String url;
        private String altText;
        private boolean isPrimary;
        private Integer displayOrder;
        private Integer optionId;
    }
}