package com.donerhome.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Utility class for password hashing and verification using BCrypt.
 *
 * <p>
 * This class provides the following functionalities:
 * - Hashing a plain-text password using BCrypt.
 * - Verifying a plain-text password against a hashed password.
 * </p>
 */
public class PasswordUtils {

    // Logger for logging important events and errors
    private static final Logger logger = LoggerFactory.getLogger(PasswordUtils.class);

    // Password encoder using BCrypt algorithm
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Hashes the provided plain-text password using BCrypt.
     *
     * @param password the plain-text password to be hashed
     * @return the hashed version of the password
     */
    public static String hashPassword(String password) {
        logger.info("Starting password hashing"); // Logging the start of the hashing process
        return BCrypt.hashpw(password, BCrypt.gensalt()); // Hashing the password with a new salt
    }

    /**
     * Verifies if the provided plain-text password matches the hashed password.
     *
     * @param password the plain-text password to verify
     * @param hashedPassword the hashed password to compare against
     * @return true if the password matches the hashed password, false otherwise
     */
    public static boolean checkPassword(String password, String hashedPassword) {
        logger.info("Starting password verification"); // Logging the start of password verification
        return BCrypt.checkpw(password, hashedPassword); // Comparing the plain-text password with the hashed password
    }
}
