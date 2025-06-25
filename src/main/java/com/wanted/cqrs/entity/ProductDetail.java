package com.wanted.cqrs.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_product_details_id"))
    private Product product;

    @Column(name = "weight", precision = 10, scale = 2) // 소수점 포함 10자리, 소수부는 2자리, Double은 안됨
    private BigDecimal weight;

    @Column(name = "materials", columnDefinition = "text")
    private String materials;

    @Column(name = "country_of_origin", length = 100)
    private String countryOfOrigin;

    @Column(name = "warranty_info", columnDefinition = "text")
    private String warrantyInfo;

    @Column(name = "care_instructions", columnDefinition = "text")
    private String careInstructions;

    @Column(name = "dimensions", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> dimensions;

    @Column(name = "additional_info", columnDefinition = "jsonb")
    @JdbcTypeCode(value = SqlTypes.JSON)
    private Map<String, Object> additionalInfo;

}
