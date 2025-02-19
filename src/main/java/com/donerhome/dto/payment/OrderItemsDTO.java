package com.donerhome.dto.payment;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) representing an item in an order.
 * This class stores details of each product in an order, including the product ID, quantity, and price at the time of order.
 */
public class OrderItemsDTO {

    // Unique identifier for the order.
    private Long orderId;

    // Unique identifier for the product being ordered.
    private Long productId;

    // The quantity of the product ordered.
    private int quantity;

    // The price of the product at the time of the order.
    private BigDecimal price;

    /**
     * Default constructor for OrderItemsDTO.
     * Initializes an empty OrderItemsDTO object.
     */
    public OrderItemsDTO() {}

    /**
     * Constructor to initialize the OrderItemsDTO object with provided values.
     *
     * @param orderId   The unique identifier of the order.
     * @param productId The unique identifier of the product.
     * @param quantity  The quantity of the product ordered.
     * @param price     The price of the product at the time of the order.
     */
    public OrderItemsDTO(Long orderId, Long productId, int quantity, BigDecimal price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets the order ID associated with the item.
     *
     * @return The order ID.
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID for the item.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the product ID associated with the item.
     *
     * @return The product ID.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the product ID for the item.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of the product ordered.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product ordered.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of the product at the time of the order.
     *
     * @return The price of the product.
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
}
