package com.wanted.cqrs.repository;

import com.wanted.cqrs.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
