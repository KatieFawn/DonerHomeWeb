package com.donerhome.service;

import com.donerhome.dto.address.AddressDTO;
import com.donerhome.entity.Address;
import com.donerhome.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for managing addresses.
 * <p>
 * This service is responsible for interacting with the address data, including updating and retrieving user addresses.
 * It performs CRUD operations on the Address entity, and includes methods for updating multiple addresses at once
 * and retrieving addresses for a specific user.
 * <p>
 * Methods include:
 * - `updateAddresses`: Updates the addresses for a specific user.
 * - `findByUserId`: Retrieves all addresses associated with a given user ID.
 */
@Service
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class); // Logger for logging

    @Autowired
    private AddressRepository addressRepository;

    /**
     * Updates the user's addresses in the database. This method deletes existing addresses
     * and saves new ones provided in the AddressDTO.
     *
     * @param addressDTO the DTO containing the addresses to be updated
     * @return boolean indicating if the update was successful (i.e., at least one address was saved)
     * @throws IllegalArgumentException if the addressDTO is null or contains invalid data
     */
    @Transactional
    public boolean updateAddresses(AddressDTO addressDTO) {
        // Log the start of the update process
        logger.info("Updating addresses for user with ID: {}", addressDTO.getUserId());

        // Delete old addresses for the given user
        logger.debug("Deleting existing addresses for user ID: {}", addressDTO.getUserId());
        addressRepository.deleteByUserId(addressDTO.getUserId());

        // List to hold the addresses that are successfully saved
        List<Address> savedAddresses = new ArrayList<>();

        // Loop through the provided addresses in the DTO
        for (int i = 0; i < addressDTO.getAddressName().length; i++) {
            // Only save non-null addresses
            if (addressDTO.getAddressName()[i] != null) {
                Address addressEntity = new Address();
                addressEntity.setUserId(addressDTO.getUserId());
                addressEntity.setAddressName(addressDTO.getAddressName()[i]);
                addressEntity.setCity(addressDTO.getCity()[i]);
                addressEntity.setStreet(addressDTO.getStreet()[i]);
                addressEntity.setBuild(addressDTO.getBuild()[i]);
                addressEntity.setApartment(addressDTO.getApartment()[i]);
                addressEntity.setPostalCode(addressDTO.getPostalCode()[i]);

                // Save the address and add it to the saved list
                savedAddresses.add(addressRepository.save(addressEntity));
                logger.debug("Saved address: {}", addressEntity);
            }
        }

        // If at least one address was saved, return true
        boolean updateSuccessful = !savedAddresses.isEmpty();
        if (updateSuccessful) {
            logger.info("Successfully updated addresses for user with ID: {}", addressDTO.getUserId());
        } else {
            logger.warn("No addresses were provided or saved for user ID: {}", addressDTO.getUserId());
        }

        return updateSuccessful;
    }

    /**
     * Retrieves all addresses for a user based on their user ID and maps them to an AddressDTO.
     *
     * @param userId the ID of the user whose addresses are to be retrieved
     * @return AddressDTO containing all the user's addresses
     * @throws IllegalArgumentException if the userId is null or invalid
     * @throws RuntimeException if an error occurs while fetching the addresses from the database
     */
    public AddressDTO findByUserId(Long userId) {
        // Log the start of the address retrieval process
        logger.info("Retrieving addresses for user with ID: {}", userId);

        // Retrieve the list of addresses for the given user
        List<Address> listOfAddresses = addressRepository.findByUserId(userId);

        // Initialize arrays dynamically based on the number of addresses
        String[] addressName = new String[listOfAddresses.size()];
        String[] city = new String[listOfAddresses.size()];
        String[] street = new String[listOfAddresses.size()];
        String[] build = new String[listOfAddresses.size()];
        String[] apartment = new String[listOfAddresses.size()];
        String[] postalCode = new String[listOfAddresses.size()];

        // Populate arrays with address data
        for (int i = 0; i < listOfAddresses.size(); i++) {
            Address address = listOfAddresses.get(i);
            addressName[i] = address.getAddressName();
            city[i] = address.getCity();
            street[i] = address.getStreet();
            build[i] = address.getBuild();
            apartment[i] = address.getApartment();
            postalCode[i] = address.getPostalCode();
        }

        // Log the successful retrieval of addresses
        logger.info("Successfully retrieved {} address(es) for user ID: {}", listOfAddresses.size(), userId);

        // Create and return the AddressDTO with the gathered address information
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setUserId(userId);
        addressDTO.setAddressName(addressName);
        addressDTO.setCity(city);
        addressDTO.setStreet(street);
        addressDTO.setBuild(build);
        addressDTO.setApartment(apartment);
        addressDTO.setPostalCode(postalCode);

        return addressDTO;
    }
}
