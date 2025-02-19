package com.donerhome.dto.payment;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) for representing an order.
 * This class holds the details of an order including user information, order date, status, total price, payment method, and shipping address.
 */
public class OrdersDTO {

    // User ID that the order is associated with
    private Long userId;

    // Date and time when the order was placed
    private String orderDate;

    // Current status of the order (e.g., pending, shipped, delivered)
    private String status;

    // Total price of the order
    private BigDecimal totalPrice;

    // Payment method used for the order (e.g., Credit Card, PayPal)
    private String paymentMethod;

    // Shipping address components
    private String street;
    private String build;
    private String apartment;

    /**
     * Default constructor for OrdersDTO.
     * Initializes an empty OrdersDTO object.
     */
    public OrdersDTO() {}

    /**
     * Constructor to initialize the OrdersDTO object with provided values.
     *
     * @param userId        The ID of the user who placed the order.
     * @param orderDate     The date and time when the order was placed.
     * @param status        The status of the order (e.g., pending, shipped, delivered).
     * @param totalPrice    The total price of the order.
     * @param paymentMethod The payment method used for the order.
     * @param street        The street address for shipping.
     * @param build         The building number or name for shipping.
     * @param apartment     The apartment number or name for shipping (if applicable).
     */
    public OrdersDTO(Long userId, String orderDate, String status,
                     BigDecimal totalPrice, String paymentMethod,
                     String street, String build, String apartment) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.street = street;
        this.build = build;
        this.apartment = apartment;
    }

    // Getters and Setters

    /**
     * Gets the user ID associated with the order.
     *
     * @return The user ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID for the order.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the order date.
     *
     * @return The order date.
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date.
     *
     * @param orderDate The order date to set.
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the status of the order.
     *
     * @return The order status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The order status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the total price of the order.
     *
     * @return The total price.
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the order.
     *
     * @param totalPrice The total price to set.
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the payment method used for the order.
     *
     * @return The payment method.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method for the order.
     *
     * @param paymentMethod The payment method to set.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the apartment number (if any) for shipping.
     *
     * @return The apartment number.
     */
    public String getApartment() {
        return apartment;
    }

    /**
     * Sets the apartment number for shipping.
     *
     * @param apartment The apartment number to set.
     */
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    /**
     * Gets the building number or name for shipping.
     *
     * @return The building number.
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the building number or name for shipping.
     *
     * @param build The building number to set.
     */
    public void setBuild(String build) {
        this.build = build;
    }

    /**
     * Gets the street address for shipping.
     *
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address for shipping.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }
}
