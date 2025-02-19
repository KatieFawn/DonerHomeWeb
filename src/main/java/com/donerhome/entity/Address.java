package com.donerhome.entity;

import jakarta.persistence.*;

/**
 * Entity class representing an address in the database.
 * This class maps to the "addresses" table and holds the details of a user's address,
 * such as the city, street, building, apartment, and postal code.
 */
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_seq")
    @SequenceGenerator(name = "your_seq", sequenceName = "your_seq", allocationSize = 1)
    private Long id;  // Unique identifier for the address

    @Column(nullable = false)
    private Long userId;  // Reference to the user associated with the address

    @Column(nullable = false)
    private String addressName;  // The name of the address (e.g., "Home", "Office")

    @Column(nullable = false)
    private String city;  // The city in the address

    @Column(nullable = false)
    private String street;  // The street name

    @Column(nullable = false)
    private String build;  // The building number or name

    @Column(nullable = false)
    private String apartment;  // The apartment or suite number (if applicable)

    @Column(nullable = false)
    private String postalCode;  // Postal code of the address

    /**
     * Default constructor for the Address entity.
     * Initializes an empty Address object.
     */
    public Address() {}

    /**
     * Constructor to initialize the Address entity with the provided values.
     *
     * @param userId        The ID of the user associated with the address.
     * @param addressName   The name of the address (e.g., "Home", "Office").
     * @param city          The city of the address.
     * @param street        The street name of the address.
     * @param build         The building number or name.
     * @param apartment     The apartment or suite number (if applicable).
     * @param postalCode    The postal code of the address.
     */
    public Address(Long userId, String addressName, String city, String street,
                   String build, String apartment, String postalCode) {
        this.userId = userId;
        this.addressName = addressName;
        this.city = city;
        this.street = street;
        this.build = build;
        this.apartment = apartment;
        this.postalCode = postalCode;
    }

    // Getters and setters

    /**
     * Gets the ID of the address.
     *
     * @return The address ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the address.
     *
     * @param id The address ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the user ID associated with the address.
     *
     * @return The user ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID associated with the address.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the name of the address (e.g., "Home", "Office").
     *
     * @return The address name.
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Sets the name of the address (e.g., "Home", "Office").
     *
     * @param addressName The address name to set.
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * Gets the city of the address.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address.
     *
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the street of the address.
     *
     * @return The street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street of the address.
     *
     * @param street The street to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the building number or name.
     *
     * @return The building.
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the building number or name.
     *
     * @param build The building to set.
     */
    public void setBuild(String build) {
        this.build = build;
    }

    /**
     * Gets the apartment or suite number.
     *
     * @return The apartment number.
     */
    public String getApartment() {
        return apartment;
    }

    /**
     * Sets the apartment or suite number.
     *
     * @param apartment The apartment number to set.
     */
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    /**
     * Gets the postal code of the address.
     *
     * @return The postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of the address.
     *
     * @param postalCode The postal code to set.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Converts the Address object to a string representation.
     *
     * @return A string representing the Address object.
     */
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", addressName='" + addressName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", build='" + build + '\'' +
                ", apartment='" + apartment + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
