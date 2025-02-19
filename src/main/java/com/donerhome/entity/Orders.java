package com.donerhome.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class representing an order.
 * This class maps to the "orders" table and holds the details about an order, including user information,
 * order status, total price, payment method, and delivery address.
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the order

    @Column(nullable = false)
    private Long userId;  // Reference to the user placing the order

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime orderDate;  // The date and time when the order was created

    @Column(nullable = false)
    private String status;  // Status of the order (e.g., "Pending", "Completed", etc.)

    @Column(nullable = false)
    private BigDecimal totalPrice;  // Total price of the order

    @Column(nullable = false)
    private String paymentMethod;  // The payment method used for the order (e.g., "Credit Card", "PayPal")

    @Column(nullable = false)
    private String street;  // Street part of the delivery address

    @Column(nullable = false)
    private String build;  // Building part of the delivery address

    @Column(nullable = false)
    private String apartment;  // Apartment number in the delivery address

    /**
     * Default constructor for the Orders entity.
     * Initializes an empty Orders object.
     */
    public Orders() {}

    /**
     * Constructor to initialize the Orders entity with the provided values.
     *
     * @param userId        The ID of the user placing the order.
     * @param orderDate     The date and time when the order is created.
     * @param status        The status of the order.
     * @param totalPrice    The total price of the order.
     * @param paymentMethod The payment method used for the order.
     * @param street        The street part of the delivery address.
     * @param build         The building part of the delivery address.
     * @param apartment     The apartment number in the delivery address.
     */
    public Orders(Long userId, LocalDateTime orderDate, String status,
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

    // Getters and setters

    /**
     * Gets the ID of the user placing the order.
     *
     * @return The user ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user placing the order.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the date and time when the order was created.
     *
     * @return The order creation date.
     */
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date and time when the order was created.
     *
     * @param orderDate The order creation date to set.
     */
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The status to set.
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
     * Sets the payment method used for the order.
     *
     * @param paymentMethod The payment method to set.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the street part of the delivery address.
     *
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street part of the delivery address.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the building part of the delivery address.
     *
     * @return The building address.
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the building part of the delivery address.
     *
     * @param build The building address to set.
     */
    public void setBuild(String build) {
        this.build = build;
    }

    /**
     * Gets the apartment number in the delivery address.
     *
     * @return The apartment number.
     */
    public String getApartment() {
        return apartment;
    }

    /**
     * Sets the apartment number in the delivery address.
     *
     * @param apartment The apartment number to set.
     */
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    /**
     * Converts the Orders object to a string representation.
     *
     * @return A string representing the Orders object.
     */
    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", street='" + street + '\'' +
                ", build='" + build + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
