package com.donerhome.dto.auth;

import com.donerhome.dto.address.AddressDTO;

/**
 * Data Transfer Object (DTO) for Authentication information.
 * This class is used to transfer authentication-related data, including tokens,
 * user data, address, and products, typically between layers of an application.
 */
public class AuthDTO {

    // Tokens related to the authentication process
    private TokensDTO tokens;

    // User data related to the authentication
    private UsersDTO userData;

    // Address details associated with the user
    private AddressDTO address;

    // Products associated with the user or session
    private ProductsDTO products;

    /**
     * Constructor to initialize AuthDTO with authentication details.
     *
     * @param tokens    Tokens related to the authentication.
     * @param userData  User data for the authentication session.
     * @param address   User address data.
     * @param products  Products associated with the user or session.
     */
    public AuthDTO(TokensDTO tokens, UsersDTO userData, AddressDTO address, ProductsDTO products) {
        this.tokens = tokens;
        this.userData = userData;
        this.address = address;
        this.products = products;
    }

    // Getter and setter methods for each property

    /**
     * Gets the tokens associated with the authentication.
     *
     * @return Tokens related to authentication.
     */
    public TokensDTO getTokens() {
        return tokens;
    }

    /**
     * Sets the tokens associated with the authentication.
     *
     * @param tokens Tokens related to authentication.
     */
    public void setTokens(TokensDTO tokens) {
        this.tokens = tokens;
    }

    /**
     * Gets the user data associated with the authentication.
     *
     * @return User data.
     */
    public UsersDTO getUserData() {
        return userData;
    }

    /**
     * Sets the user data associated with the authentication.
     *
     * @param userData User data for the authentication session.
     */
    public void setUserData(UsersDTO userData) {
        this.userData = userData;
    }

    /**
     * Gets the address associated with the user.
     *
     * @return User address data.
     */
    public AddressDTO getAddress() {
        return address;
    }

    /**
     * Sets the address associated with the user.
     *
     * @param address User address data.
     */
    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    /**
     * Gets the products associated with the user or session.
     *
     * @return Products related to the user.
     */
    public ProductsDTO getProducts() {
        return products;
    }

    /**
     * Sets the products associated with the user or session.
     *
     * @param products Products related to the user.
     */
    public void setProducts(ProductsDTO products) {
        this.products = products;
    }
}
