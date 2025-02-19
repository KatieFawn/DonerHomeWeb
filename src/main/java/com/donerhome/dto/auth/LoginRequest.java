package com.donerhome.dto.auth;

/**
 * Data Transfer Object (DTO) for handling login request data.
 * This class is used to transfer login credentials, including email and password,
 * typically between client and server during the authentication process.
 */
public class LoginRequest {

    // Email address used for authentication
    private String email;

    // Password associated with the provided email
    private String password;

    /**
     * Constructor to initialize LoginRequest with email and password.
     *
     * @param email    The email address for authentication.
     * @param password The password associated with the email.
     */
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Default constructor.
     * Initializes LoginRequest with default values (empty fields).
     */
    public LoginRequest() {

    }

    /**
     * Gets the email address associated with the login request.
     *
     * @return Email address for authentication.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the login request.
     *
     * @param email The email address for authentication.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password associated with the login request.
     *
     * @return Password for authentication.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the login request.
     *
     * @param password The password associated with the email.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
