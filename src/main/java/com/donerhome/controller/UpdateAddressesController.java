package com.donerhome.controller;

import com.donerhome.dto.address.AddressDTO;
import com.donerhome.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

@RestController
@RequestMapping("/addresses")
public class UpdateAddressesController {

    private static final Logger logger = LogManager.getLogger(UpdateAddressesController.class);

    @Autowired
    private AddressService addressService;

    /**
     * Updates or creates an address in the system.
     *
     * @param addressDTO The address details to be saved or updated.
     * @return A ResponseEntity containing the status of the operation (success or failed).
     */
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody AddressDTO addressDTO) {
        logger.info("Received request to update address for user ID: {}", addressDTO.getUserId());

        Map<String, String> response = new HashMap<>();

        // Attempting to update the address in the service
        if (addressService.updateAddresses(addressDTO)) {
            logger.info("Address successfully updated for user ID: {}", addressDTO.getUserId());
            response.put("addressSaveDetails", "success");
            return ResponseEntity.ok(response);
        } else {
            logger.warn("Failed to update address for user ID: {}", addressDTO.getUserId());
            response.put("addressSaveDetails", "failed");
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(response);
        }
    }
}
