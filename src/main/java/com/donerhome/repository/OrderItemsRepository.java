package com.donerhome.repository;

import com.donerhome.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on the OrderItems entity.
 * Extends JpaRepository to provide basic database operations for order items.
 */
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    // You can add custom queries here in the future if needed
}
