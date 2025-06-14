package com.wanted.cqrs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    // 멘토님은 columnDefinition 없음
    @Column(length = 1000, columnDefinition = "text")
    private String description;

    @Column
    private String logoUrl;

    @Column(precision = 3, scale = 2) // 소수점 포함 3자리 숫자, 소수점 아래 부분은 2자리 제한 -> 최대 9.99 저장가능
    private BigDecimal rating;

    @Column(length = 100)
    private String contactEmail;

    @Column(length = 20)
    private String contactPhone;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
