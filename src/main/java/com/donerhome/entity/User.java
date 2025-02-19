package com.donerhome.entity;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Entity class representing a user in the system.
 * This class maps to the "users" table and holds information about a user, including authentication details,
 * user profile information, and the refresh token for session management.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the user (Primary key)

    @Column(nullable = false, unique = true)
    private String email;  // The user's email address (unique)

    @Column(nullable = false)
    private String password;  // The user's password

    @Column(nullable = false)
    private String role;  // The user's role (e.g., "USER", "ADMIN")

    @Column(name = "refresh_token", columnDefinition = "TEXT")
    private String refreshToken;  // Refresh token for session management

    @Column(name = "refresh_token_expiration")
    private Instant refreshTokenExpiration;  // Expiration time for the refresh token

    @Column(name = "first_name")
    private String firstName;  // The user's first name

    @Column(name = "last_name")
    private String lastName;  // The user's last name

    @Column(name = "phone_number")
    private String phoneNumber;  // The user's phone number

    @Column(name = "language")
    private String language;  // The user's preferred language

    /**
     * Gets the unique identifier of the user.
     *
     * @return The user ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id The user ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the user.
     *
     * @return The user's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the refresh token for session management.
     *
     * @return The refresh token.
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets the refresh token for session management.
     *
     * @param refreshToken The refresh token to set.
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Gets the expiration time of the refresh token.
     *
     * @return The refresh token expiration time.
     */
    public Instant getRefreshTokenExpiration() {
        return refreshTokenExpiration;
    }

    /**
     * Sets the expiration time of the refresh token.
     *
     * @param refreshTokenExpiration The expiration time to set.
     */
    public void setRefreshTokenExpiration(Instant refreshTokenExpiration) {
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return The user's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the preferred language of the user.
     *
     * @return The user's preferred language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the preferred language of the user.
     *
     * @param language The language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Converts the User entity to a string representation.
     *
     * @return A string representation of the User entity.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", refreshTokenExpiration=" + refreshTokenExpiration +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
