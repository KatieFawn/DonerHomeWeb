package com.donerhome.utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for generating and validating JWT access tokens and refresh tokens.
 *
 * <p>
 * This class provides the following functionality:
 * - Generate an access token for a given user ID.
 * - Generate a random refresh token.
 * - Validate a provided JWT token.
 * </p>
 */

public class TokenGenerator {

    // Logger for logging events and errors
    private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);

    // The secret key for signing JWT tokens
    private static final String jwtSecret = "XSjKSlCkKWNGy3OlvIhyGZ8qbf4HaBKMSj7DTceI8PY=";
    //System.getenv("JWT_SECRET_KEY");
    // Secure key for signing JWT tokens
    private static final Key signingKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    // Secure random generator for generating refresh tokens
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    /**
     * Generates a JWT access token for the provided user ID.
     *
     * @param userId the user ID for which the token is generated
     * @return the generated JWT access token
     */

    public static String generateAccessToken(String userId){
        logger.info("Generating access token for user: {}", userId); // Log token generation start
        long expirationTime = 3600000; // Token validity period (1 hour)

        logger.info("Access token generated successfully for user: {}", userId); // Log successful token generation
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date()) // Set the issue time to the current time
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Set expiration time
                .signWith(signingKey) // Sign the token with the secret key
                .compact();
    }

    /**
     * Generates a secure random refresh token.
     *
     * @return the generated refresh token
     */
    public static String generateRefreshToken(){
        logger.info("Generating a new refresh token"); // Log the start of refresh token generation
        byte[] randomBytes = new byte[64]; // Create a byte array for the token
        secureRandom.nextBytes(randomBytes); // Fill the byte array with random bytes
        String refreshToken = base64Encoder.encodeToString(randomBytes); // Encode the bytes to Base64

        logger.info("Refresh token generated successfully"); // Log successful token generation
        return refreshToken;
    }

    /**
     * Validates the provided JWT token by checking its signature and expiration date.
     *
     * @param token the token to be validated
     * @return true if the token is valid; false otherwise
     */
    public static boolean validateToken(String token){
        logger.info("Validating token"); // Log the start of token validation
        // Parse and validate the token using the signing key
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Date expirationDate = claims.getExpiration();
        return !expirationDate.before(new Date());
    }
}
