package com.donerhome.repository;

import com.donerhome.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on the Orders entity.
 * Extends JpaRepository to provide basic database operations for orders.
 */
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // You can add custom queries here if needed, such as finding orders by status or userId
}
