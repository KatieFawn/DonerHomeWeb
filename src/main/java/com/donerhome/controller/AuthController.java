package com.donerhome.controller;

import com.donerhome.dto.address.AddressDTO;
import com.donerhome.dto.auth.*;
import com.donerhome.service.AddressService;
import com.donerhome.utils.PasswordUtils;
import com.donerhome.entity.User;
import com.donerhome.service.AuthService;
import com.donerhome.utils.*;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

/**
 * Controller for handling authentication-related endpoints.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private AddressService addressService;

    /**
     * Home endpoint to verify the server is running.
     *
     * @return Welcome message.
     */
    @GetMapping("/")
    public String home() {
        logger.info("Home endpoint called");
        return "Welcome to the server!";
    }

    /**
     * Handles user login requests.
     *
     * @param loginRequest Object containing user credentials (email and password).
     * @return ResponseEntity with authentication tokens or UNAUTHORIZED status.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        logger.info("Login attempt for email: {}", email);

        // Fetch user by email
        User user = authService.findByEmail(email).orElse(new User());
        logger.debug("Fetched user with ID: {}", user.getId());

        // Verify the password
        if (PasswordUtils.checkPassword(password, user.getPassword())) {
            logger.info("Password matched for user ID: {}", user.getId());

            // Generate access and refresh tokens
            String accessToken = TokenGenerator.generateAccessToken(Long.toString(user.getId()));
            String refreshToken = TokenGenerator.generateRefreshToken();
            String hashedRefreshToken = SHA256.hashString(refreshToken);

            // Update refresh token and its expiration date
            Instant newExpirationTime = Instant.now().plus(Duration.ofDays(7));
            authService.updateRefreshTokenAndDate(user.getId(), hashedRefreshToken, newExpirationTime);
            logger.info("Tokens generated and saved for user ID: {}", user.getId());

            return ResponseEntity.ok(response(user, accessToken, hashedRefreshToken));
        } else {
            logger.warn("Unauthorized login attempt for email: {}", email);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    /**
     * Validates and refreshes authentication tokens.
     *
     * @param tokens DTO containing the access token and refresh token.
     * @return ResponseEntity with updated tokens or UNAUTHORIZED status.
     */
    @PostMapping("/begin")
    public ResponseEntity<AuthDTO> begin(@RequestBody TokensDTO tokens) {
        String accessToken = tokens.getAccessToken();
        String refreshToken = tokens.getRefreshToken();

        logger.info("Begin endpoint called");

        // Hash the provided refresh token
        String hashedRefreshToken = SHA256.hashString(refreshToken);
        logger.debug("Hashed refresh token: {}", hashedRefreshToken);

        // Fetch user by hashed refresh token
        User user = authService.findByRefreshToken(hashedRefreshToken);

        if (user.getRefreshToken() != null) {
            // Check if the refresh token is still valid
            if (user.getRefreshTokenExpiration().isAfter(Instant.now())) {
                logger.info("Valid refresh token for user ID: {}", user.getId());

                // Check the validity of the access token
                if (accessToken != null && TokenGenerator.validateToken(accessToken)) {
                    logger.info("Valid access token for user ID: {}", user.getId());
                    return ResponseEntity.ok(response(user, accessToken, refreshToken));
                } else {
                    logger.info("Access token is invalid or missing. Generating a new one.");
                    accessToken = TokenGenerator.generateAccessToken(Long.toString(user.getId()));
                    return ResponseEntity.ok(response(user, accessToken, refreshToken));
                }
            } else {
                logger.warn("Refresh token has expired for user ID: {}", user.getId());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }

        logger.warn("Invalid refresh token provided");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    /**
     * Builds the authentication response.
     *
     * @param user         User entity.
     * @param accessToken  Newly generated or existing access token.
     * @param refreshToken Newly generated or existing refresh token.
     * @return AuthDTO containing user data, tokens, and other details.
     */
    private AuthDTO response(User user, String accessToken, String refreshToken) {
        logger.debug("Building AuthDTO for user ID: {}", user.getId());

        // Populate user information
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserId(user.getId());
        usersDTO.setEmail(user.getEmail());
        usersDTO.setRole(user.getRole());
        usersDTO.setFirstName(user.getFirstName());
        usersDTO.setLastName(user.getLastName());
        usersDTO.setPhoneNumber(user.getPhoneNumber());
        usersDTO.setLanguage(user.getLanguage());

        // Populate token information
        TokensDTO tokensDTO = new TokensDTO();
        tokensDTO.setAccessToken(accessToken);
        tokensDTO.setRefreshToken(refreshToken);

        // Fetch address and products
        AddressDTO addressDTO = addressService.findByUserId(user.getId());
        ProductsDTO productsDTO = authService.receiveAllProducts();

        // Create the authentication DTO
        AuthDTO authDTO = new AuthDTO(tokensDTO, usersDTO, addressDTO, productsDTO);
        logger.debug("AuthDTO created for user ID: {}", user.getId());

        return authDTO;
    }
}
