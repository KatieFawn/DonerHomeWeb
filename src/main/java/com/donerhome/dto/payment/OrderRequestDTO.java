package com.donerhome.dto.payment;

import java.util.List;

/**
 * Data Transfer Object (DTO) for representing a request to place an order.
 * This class contains information about the order, the items in the order, and the payment card.
 */
public class OrderRequestDTO {

    // Order details
    private OrdersDTO order;

    // List of items included in the order
    private List<OrderItemsDTO> items;

    // Payment card information
    private PaymentCardDTO card;

    /**
     * Default constructor for OrderRequestDTO.
     * Initializes an empty OrderRequestDTO object.
     */
    public OrderRequestDTO() {}

    /**
     * Constructor to initialize the OrderRequestDTO object with provided values.
     *
     * @param order The order details.
     * @param items The list of items in the order.
     * @param card  The payment card information.
     */
    public OrderRequestDTO(OrdersDTO order, List<OrderItemsDTO> items, PaymentCardDTO card) {
        this.order = order;
        this.items = items;
        this.card = card;
    }

    /**
     * Gets the order details.
     *
     * @return The order details.
     */
    public OrdersDTO getOrder() {
        return order;
    }

    /**
     * Sets the order details.
     *
     * @param order The order details to set.
     */
    public void setOrder(OrdersDTO order) {
        this.order = order;
    }

    /**
     * Gets the list of items in the order.
     *
     * @return The list of order items.
     */
    public List<OrderItemsDTO> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the order.
     *
     * @param items The list of items to set.
     */
    public void setItems(List<OrderItemsDTO> items) {
        this.items = items;
    }

    /**
     * Gets the payment card information.
     *
     * @return The payment card information.
     */
    public PaymentCardDTO getCard() {
        return card;
    }

    /**
     * Sets the payment card information.
     *
     * @param card The payment card information to set.
     */
    public void setCard(PaymentCardDTO card) {
        this.card = card;
    }
}
