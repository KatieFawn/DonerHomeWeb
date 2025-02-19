package com.donerhome.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity class representing an item in an order.
 * This class maps to the "order_items" table and holds the details about a specific product
 * included in an order, including the quantity and price at the time of the order.
 */
@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the order item

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order; // Reference to the associated order

    @Column(nullable = false)
    private Long productId;    // Reference to the product in the order

    @Column(nullable = false)
    private int quantity;      // Quantity of the product in the order

    @Column(nullable = false)
    private BigDecimal price;  // Price of the product at the time of the order

    /**
     * Default constructor for the OrderItems entity.
     * Initializes an empty OrderItems object.
     */
    public OrderItems() {}

    /**
     * Constructor to initialize the OrderItems entity with the provided values.
     *
     * @param order     The order that this item is part of.
     * @param productId The ID of the product in the order.
     * @param quantity  The quantity of the product in the order.
     * @param price     The price of the product at the time of the order.
     */
    public OrderItems(Orders order, Long productId, int quantity, BigDecimal price) {
        this.order = order;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters

    /**
     * Gets the order associated with this order item.
     *
     * @return The associated order.
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * Sets the order associated with this order item.
     *
     * @param order The order to set.
     */
    public void setOrder(Orders order) {
        this.order = order;
    }

    /**
     * Gets the ID of the product in the order.
     *
     * @return The product ID.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product in the order.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of the product in the order.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of the product at the time of the order.
     *
     * @return The price.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the product at the time of the order.
     *
     * @param price The price to set.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Converts the OrderItems object to a string representation.
     *
     * @return A string representing the OrderItems object.
     */
    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", order=" + order +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
