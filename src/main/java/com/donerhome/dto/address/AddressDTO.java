package com.donerhome.dto.address;

import java.util.Arrays;

import java.util.Arrays;

/**
 * Data Transfer Object (DTO) for Address information.
 * This class is used to transfer address data, typically between layers of an application.
 */
public class AddressDTO {

    // User ID associated with the address
    private Long userId;

    // Array of address names (e.g., "Home", "Office")
    private String[] addressName;

    // Array of cities corresponding to the addresses
    private String[] city;

    // Array of street names for the addresses
    private String[] street;

    // Array of building numbers for the addresses
    private String[] build;

    // Array of apartment numbers for the addresses
    private String[] apartment;

    // Array of postal codes for the addresses
    private String[] postalCode;

    /**
     * Default constructor.
     * Initializes an empty AddressDTO.
     */
    public AddressDTO() {
    }

    /**
     * Constructor to initialize AddressDTO with user ID and address details.
     *
     * @param userId        User ID associated with the address.
     * @param addressName   Array of address names.
     * @param city          Array of cities.
     * @param street        Array of street names.
     * @param build         Array of building numbers.
     * @param apartment     Array of apartment numbers.
     * @param postalCode    Array of postal codes.
     */
    public AddressDTO(Long userId, String[] addressName, String[] city, String[] street,
                      String[] build, String[] apartment, String[] postalCode) {
        this.userId = userId;
        this.addressName = addressName;
        this.city = city;
        this.street = street;
        this.build = build;
        this.apartment = apartment;
        this.postalCode = postalCode;
    }

    // Getter and setter methods for each property

    /**
     * Gets the user ID associated with the address.
     *
     * @return User ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID associated with the address.
     *
     * @param userId User ID.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the address names.
     *
     * @return Array of address names.
     */
    public String[] getAddressName() {
        return addressName;
    }

    /**
     * Sets the address names.
     *
     * @param addressName Array of address names.
     */
    public void setAddressName(String[] addressName) {
        this.addressName = addressName;
    }

    /**
     * Gets the cities associated with the addresses.
     *
     * @return Array of cities.
     */
    public String[] getCity() {
        return city;
    }

    /**
     * Sets the cities associated with the addresses.
     *
     * @param city Array of cities.
     */
    public void setCity(String[] city) {
        this.city = city;
    }

    /**
     * Gets the streets associated with the addresses.
     *
     * @return Array of street names.
     */
    public String[] getStreet() {
        return street;
    }

    /**
     * Sets the streets associated with the addresses.
     *
     * @param street Array of street names.
     */
    public void setStreet(String[] street) {
        this.street = street;
    }

    /**
     * Gets the buildings associated with the addresses.
     *
     * @return Array of building numbers.
     */
    public String[] getBuild() {
        return build;
    }

    /**
     * Sets the buildings associated with the addresses.
     *
     * @param build Array of building numbers.
     */
    public void setBuild(String[] build) {
        this.build = build;
    }

    /**
     * Gets the apartment numbers associated with the addresses.
     *
     * @return Array of apartment numbers.
     */
    public String[] getApartment() {
        return apartment;
    }

    /**
     * Sets the apartment numbers associated with the addresses.
     *
     * @param apartment Array of apartment numbers.
     */
    public void setApartment(String[] apartment) {
        this.apartment = apartment;
    }

    /**
     * Gets the postal codes associated with the addresses.
     *
     * @return Array of postal codes.
     */
    public String[] getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal codes associated with the addresses.
     *
     * @param postalCode Array of postal codes.
     */
    public void setPostalCode(String[] postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Provides a string representation of the AddressDTO object, including all address fields.
     *
     * @return String representation of the AddressDTO.
     */
    @Override
    public String toString() {
        return "AddressDTO{" +
                "userId=" + userId +
                ", addressName=" + Arrays.toString(addressName) +
                ", city=" + Arrays.toString(city) +
                ", street=" + Arrays.toString(street) +
                ", build=" + Arrays.toString(build) +
                ", apartment=" + Arrays.toString(apartment) +
                ", postalCode=" + Arrays.toString(postalCode) +
                '}';
    }
}
