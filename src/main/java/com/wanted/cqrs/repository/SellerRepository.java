package com.wanted.cqrs.repository;

import com.wanted.cqrs.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
