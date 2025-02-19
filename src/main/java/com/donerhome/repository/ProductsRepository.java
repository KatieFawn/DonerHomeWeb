package com.donerhome.repository;

import com.donerhome.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on the ProductEntity.
 * Extends JpaRepository to provide basic database operations for products.
 */
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
    // You can add custom queries here if needed, such as finding products by category or price range
}
