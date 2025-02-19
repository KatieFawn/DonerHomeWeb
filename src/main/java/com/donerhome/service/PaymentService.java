package com.donerhome.service;

import com.donerhome.dto.payment.*;
import com.donerhome.entity.*;
import com.donerhome.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Service layer for processing payment orders.
 * This service handles the creation of orders and associated order items based on incoming order requests.
 * It persists orders and items into the database through the respective repositories.
 * <p>
 * This class provides functionality for:
 * - Creating an order from an incoming order request.
 * - Saving the order and its items into the database.
 */
@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    // Repositories for managing orders and order items in the database
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    /**
     * Processes an incoming order request and saves the order and its items to the database.
     *
     * This method does the following:
     * - Creates a new order entity based on the data from the OrderRequestDTO.
     * - Parses the order date and sets other details such as status, total price, and shipping address.
     * - Saves the order to the database.
     * - Iterates through each item in the order and saves them as OrderItems in the database.
     *
     * @param orderRequestDTO the DTO containing the details of the order and order items
     */
    public void processOrder(OrderRequestDTO orderRequestDTO) {

        logger.info("Processing order for user ID: {}", orderRequestDTO.getOrder().getUserId());
        // Creating the order
        Orders order = new Orders();
        order.setUserId(orderRequestDTO.getOrder().getUserId());  // Set the user ID

        // Formatting the order date string into a LocalDateTime object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a", Locale.ENGLISH);
        LocalDateTime orderDate = LocalDateTime.parse(orderRequestDTO.getOrder().getOrderDate(), formatter);
        order.setOrderDate(orderDate);  // Set the order date

        // Setting other order parameters
        order.setStatus(orderRequestDTO.getOrder().getStatus());
        order.setTotalPrice(orderRequestDTO.getOrder().getTotalPrice());
        order.setPaymentMethod(orderRequestDTO.getOrder().getPaymentMethod());
        order.setStreet(orderRequestDTO.getOrder().getStreet());
        order.setBuild(orderRequestDTO.getOrder().getBuild());
        order.setApartment(orderRequestDTO.getOrder().getApartment());

        // Saving the order to the database
        ordersRepository.save(order);
        logger.info("Order saved successfully with ID: {}", order.getUserId());

        // Creating and saving the order items
        for (OrderItemsDTO item : orderRequestDTO.getItems()) {
            OrderItems orderItem = new OrderItems(order, item.getProductId(), item.getQuantity(), item.getPrice());
            // Saving each order item
            orderItemsRepository.save(orderItem);
            logger.info("Saved order item for product ID: {} with quantity: {}", item.getProductId(), item.getQuantity());
        }

        logger.info("Order processing completed successfully for order ID: {}", order.getUserId());

    }
}
