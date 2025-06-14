package com.wanted.cqrs.repository;

import com.wanted.cqrs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
