package com.donerhome.controller;

import com.donerhome.dto.payment.*;
import com.donerhome.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private PaymentService paymentService;

    /**
     * Processes an order payment request.
     *
     * @param orderRequest The order details containing payment card information and order details.
     * @return A ResponseEntity containing the payment status (success or failed) and additional details if necessary.
     */
    @PostMapping("/pay")
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody OrderRequestDTO orderRequest) {
        logger.info("Received payment request");

        Map<String, String> response = new HashMap<>();
        PaymentCardDTO card = orderRequest.getCard();

        // Logging card details (in real-world applications, never log sensitive data!)
        logger.debug("Processing payment for card ending in: {}", card.getCardNumber().substring(card.getCardNumber().length() - 4));

        // Simulating payment success (replace with real payment logic in production)
        boolean paymentSuccessful = true; // In production, use actual logic to determine payment status

        if (paymentSuccessful) {
            logger.info("Payment successful for order.");
            paymentService.processOrder(orderRequest);

            response.put("payment_status", "success");
            return ResponseEntity.ok(response);
        } else {
            logger.warn("Payment failed.");
            response.put("payment_status", "failed");
            response.put("message", "Insufficient funds or payment declined.");
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(response);
        }
    }
}
