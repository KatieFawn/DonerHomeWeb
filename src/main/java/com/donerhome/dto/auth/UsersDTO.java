package com.donerhome.dto.auth;

/**
 * Data Transfer Object (DTO) for managing user-related information.
 * This class contains the user's personal details such as user ID, email, role, and other profile information.
 */
public class UsersDTO {

    // Unique identifier for the user.
    private Long userId;

    // User's email address.
    private String email;

    // User's role (e.g., admin, user, etc.).
    private String role;

    // User's first name.
    private String firstName;

    // User's last name.
    private String lastName;

    // User's phone number.
    private String phoneNumber;

    // User's preferred language.
    private String language;

    /**
     * Default constructor for UsersDTO.
     * Initializes an empty UsersDTO object.
     */
    public UsersDTO() {
    }

    /**
     * Constructor to initialize the UsersDTO object with provided values.
     *
     * @param userId     The unique identifier of the user.
     * @param email      The user's email address.
     * @param role       The user's role.
     * @param firstName  The user's first name.
     * @param lastName   The user's last name.
     * @param phoneNumber The user's phone number.
     * @param language   The user's preferred language.
     */
    public UsersDTO(Long userId, String email, String role, String firstName, String lastName, String phoneNumber, String language) {
        this.userId = userId;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.language = language;
    }

    /**
     * Gets the user's unique ID.
     *
     * @return The user ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user's unique ID.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the user's email address.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's role.
     *
     * @return The user's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the user's role.
     *
     * @param role The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's phone number.
     *
     * @return The user's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the user's preferred language.
     *
     * @return The user's preferred language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the user's preferred language.
     *
     * @param language The language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }
}
