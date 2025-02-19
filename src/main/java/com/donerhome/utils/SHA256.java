package com.donerhome.utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for hashing strings using the SHA-256 algorithm.
 *
 * <p>
 * This class provides functionality to:
 * - Hash a string using the SHA-256 hashing algorithm.
 * - Convert the resulting byte array to a hexadecimal representation.
 * </p>
 */
public class SHA256 {

    // Logger for logging events and errors
    private static final Logger logger = LoggerFactory.getLogger(SHA256.class);

    // The algorithm used for hashing
    private static final String HASH_ALGORITHM = "SHA-256";

    /**
     * Hashes the given string using the SHA-256 algorithm and returns the hash in hexadecimal format.
     *
     * @param line the string to be hashed
     * @return the hashed string in hexadecimal format
     */
    public static String hashString(String line) {
        logger.info("Starting SHA-256 hashing process"); // Logging the start of hashing
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);

            // Convert the input string to bytes using UTF-8 and compute the hash
            byte[] encodedHash = digest.digest(line.getBytes(StandardCharsets.UTF_8));

            logger.info("SHA-256 hashing completed successfully"); // Log successful hashing
            return bytesToHex(encodedHash); // Convert the hash to hexadecimal format
        } catch (NoSuchAlgorithmException e) {
            logger.error("SHA-256 algorithm not found", e); // Log the error if the algorithm is not found
            throw new RuntimeException("SHA-256 not found!"); // Throw an exception for handling
        }
    }

    /**
     * Converts a byte array to its hexadecimal string representation.
     *
     * @param hash the byte array to be converted
     * @return the hexadecimal representation of the byte array
     */
    private static String bytesToHex(byte[] hash) {
        // Initialize a StringBuilder with double the length of the hash (for hex representation)
        StringBuilder hexString = new StringBuilder(2 * hash.length);

        // Convert each byte to a 2-digit hexadecimal string
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b); // Convert the byte to hex
            if (hex.length() == 1) {
                hexString.append('0'); // Add a leading zero if the hex string is only 1 digit
            }
            hexString.append(hex); // Append the hex string to the result
        }

        logger.info("Converted byte array to hexadecimal format"); // Log the completion of hex conversion
        return hexString.toString();
    }
}
