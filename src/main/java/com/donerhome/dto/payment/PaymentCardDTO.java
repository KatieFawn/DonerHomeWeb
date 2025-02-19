package com.donerhome.dto.payment;

/**
 * Data Transfer Object (DTO) for representing payment card details.
 * This class holds the basic information required for processing payments, including the card number, expiry date, and CVV code.
 */
public class PaymentCardDTO {

    // Card number for the payment method
    private String cardNumber;

    // Expiry date of the card in MM/YY format
    private String expiryDate;

    // CVV (Card Verification Value) code for the card
    private String cvv;

    /**
     * Default constructor for PaymentCardDTO.
     * Initializes an empty PaymentCardDTO object.
     */
    public PaymentCardDTO() {}

    /**
     * Constructor to initialize PaymentCardDTO with provided card details.
     *
     * @param cardNumber  The card number.
     * @param expiryDate  The card's expiry date in MM/YY format.
     * @param cvv         The card's CVV code.
     */
    public PaymentCardDTO(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Getters and Setters

    /**
     * Gets the card number.
     *
     * @return The card number.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number.
     *
     * @param cardNumber The card number to set.
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the expiry date of the card.
     *
     * @return The expiry date in MM/YY format.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the card.
     *
     * @param expiryDate The expiry date to set.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the CVV code of the card.
     *
     * @return The CVV code.
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Sets the CVV code for the card.
     *
     * @param cvv The CVV code to set.
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
