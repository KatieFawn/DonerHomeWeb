package com.donerhome.dto.auth;

/**
 * Data Transfer Object (DTO) for handling tokens related to user authentication.
 * This class contains the access token and refresh token needed for user authentication
 * and session management.
 */
public class TokensDTO {

    // Access token used for authenticating API requests.
    private String accessToken;

    // Refresh token used to refresh the access token when it expires.
    private String refreshToken;

    /**
     * Default constructor for TokensDTO.
     * Initializes an empty TokensDTO object.
     */
    public TokensDTO() {
    }

    /**
     * Gets the access token.
     *
     * @return The access token as a string.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token.
     *
     * @param accessToken The access token to set.
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets the refresh token.
     *
     * @return The refresh token as a string.
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets the refresh token.
     *
     * @param refreshToken The refresh token to set.
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
