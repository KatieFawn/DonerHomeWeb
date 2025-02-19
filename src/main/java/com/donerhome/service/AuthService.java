package com.donerhome.service;

import com.donerhome.dto.auth.ProductsDTO;
import com.donerhome.entity.*;
import com.donerhome.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.*;

/**
 * Service layer for managing user authentication and product-related data.
 * <p>
 * This service handles various operations related to users, such as saving, updating, and deleting users,
 * as well as handling the refresh token operations. Additionally, it provides functionality for retrieving
 * all products from the product repository.
 * <p>
 * Methods include:
 * - `findByEmail`: Finds a user by their email address.
 * - `saveUser`: Saves a new user to the database.
 * - `deleteUser`: Deletes a user by their ID.
 * - `updateRefreshToken`: Updates the refresh token for a user.
 * - `findByRefreshToken`: Finds a user by their refresh token.
 * - `updateRefreshTokenExpiration`: Updates the expiration date of a refresh token.
 * - `updateRefreshTokenAndDate`: Updates both the refresh token and its expiration date.
 * - `receiveUsersData`: Retrieves data for a user by their ID.
 * - `receiveAllProducts`: Retrieves all products from the product repository and returns them as a `ProductsDTO`.
 */
@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class); // Logger for logging

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    /**
     * Finds a user by their email address.
     *
     * @param email the email address of the user to be found
     * @return an Optional containing the user if found, or an empty Optional if not
     */
    public Optional<User> findByEmail(String email){
        logger.info("Searching for user by email: {}", email);
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    /**
     * Saves a new user to the database.
     *
     * @param user the user to be saved
     * @return the saved user
     */
    public User saveUser(User user){
        logger.info("Saving new user: {}", user.getEmail());
        return userRepository.save(user);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to be deleted
     */
    public void deleteUser(Long id){
        logger.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }

    /**
     * Updates the refresh token for a user.
     *
     * @param id the ID of the user whose refresh token is to be updated
     * @param refreshToken the new refresh token
     */
    @Transactional
    public void updateRefreshToken(Long id, String refreshToken){
        logger.info("Updating refresh token for user ID: {}", id);
        userRepository.updateRefreshToken(id, refreshToken);
    }

    /**
     * Finds a user by their refresh token.
     *
     * @param refreshToken the refresh token of the user to be found
     * @return the user associated with the refresh token
     */
    @Transactional
    public User findByRefreshToken(String refreshToken){
        logger.info("Searching for user by refresh token.");
        return userRepository.findByRefreshToken(refreshToken);
    }

    /**
     * Updates the expiration date of a refresh token.
     *
     * @param refreshToken the refresh token whose expiration date is to be updated
     * @param expiration the new expiration date
     */
    @Transactional
    public void updateRefreshTokenExpiration(String refreshToken, Instant expiration){
        logger.info("Updating expiration date for refresh token: {}", refreshToken);
        userRepository.updateRefreshTokenExpiration(refreshToken, expiration);
    }

    /**
     * Updates both the refresh token and its expiration date for a user.
     *
     * @param userId the ID of the user whose refresh token and expiration date are to be updated
     * @param refreshToken the new refresh token
     * @param expiration the new expiration date
     */
    @Transactional
    public void updateRefreshTokenAndDate(Long userId, String refreshToken, Instant expiration){
        logger.info("Updating refresh token and expiration date for user ID: {}", userId);
        userRepository.updateRefreshTokenAndDate(userId, refreshToken, expiration);
    }

    /**
     * Retrieves user data by their ID.
     *
     * @param userId the ID of the user whose data is to be retrieved
     */
    @Transactional
    public void receiveUsersData(Long userId){
        logger.info("Retrieving data for user with ID: {}", userId);
        userRepository.findById(userId);
    }

    /**
     * Retrieves all products from the product repository and returns them as a `ProductsDTO`.
     *
     * @return the DTO containing all products
     */
    @Transactional
    public ProductsDTO receiveAllProducts(){
        logger.info("Retrieving all products.");

        ProductsDTO products = new ProductsDTO();
        List<ProductEntity> listOfProducts = productsRepository.findAll();

        for (int i = 0; i < listOfProducts.size(); i++){
            ProductEntity product = listOfProducts.get(i);

            logger.debug("Product found: {} with price: {}", product.getProductName(), product.getPrice());

            // Set product details to ProductsDTO
            products.setId(product.getId());
            products.setProductName(product.getProductName());
            products.setPrice(product.getPrice());
            products.setCategory(product.getCategory());
            products.setSubcategory(product.getSubcategory());
            products.setImageURL(product.getImageURL());
        }

        logger.info("Successfully retrieved {} product(s).", listOfProducts.size());
        return products;
    }
}
