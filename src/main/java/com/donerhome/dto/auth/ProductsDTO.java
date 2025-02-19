package com.donerhome.dto.auth;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) for handling product-related information.
 * This class is used to transfer details about products, including their ID,
 * name, price, category, subcategory, and image URL.
 */
public class ProductsDTO {

    // List to store product IDs
    private List<Integer> id = new ArrayList<>();

    // List to store product names
    private List<String> productName = new ArrayList<>();

    // List to store product prices
    private List<Integer> price = new ArrayList<>();

    // List to store product categories
    private List<String> category = new ArrayList<>();

    // List to store product subcategories
    private List<String> subcategory = new ArrayList<>();

    // List to store product image URLs
    private List<String> imageURL = new ArrayList<>();

    /**
     * Constructor to initialize ProductsDTO with product details.
     *
     * @param id          List of product IDs.
     * @param productName List of product names.
     * @param price       List of product prices.
     * @param category    List of product categories.
     * @param subcategory List of product subcategories.
     * @param imageURL    List of product image URLs.
     */
    public ProductsDTO(List<Integer> id, List<String> productName, List<Integer> price, List<String> category, List<String> subcategory, List<String> imageURL) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.subcategory = subcategory;
        this.imageURL = imageURL;
    }

    /**
     * Default constructor for ProductsDTO.
     * Initializes empty lists for all fields.
     */
    public ProductsDTO() {

    }

    /**
     * Gets the list of product IDs.
     *
     * @return List of product IDs.
     */
    public List<Integer> getId() {
        return id;
    }

    /**
     * Adds a new product ID to the list.
     *
     * @param id Product ID to add.
     */
    public void setId(int id) {
        this.id.add(id);
    }

    /**
     * Gets the list of product names.
     *
     * @return List of product names.
     */
    public List<String> getProductName() {
        return productName;
    }

    /**
     * Adds a new product name to the list.
     *
     * @param productName Product name to add.
     */
    public void setProductName(String productName) {
        this.productName.add(productName);
    }

    /**
     * Gets the list of product prices.
     *
     * @return List of product prices.
     */
    public List<Integer> getPrice() {
        return price;
    }

    /**
     * Adds a new product price to the list.
     *
     * @param price Product price to add.
     */
    public void setPrice(int price) {
        this.price.add(price);
    }

    /**
     * Gets the list of product categories.
     *
     * @return List of product categories.
     */
    public List<String> getCategory() {
        return category;
    }

    /**
     * Adds a new product category to the list.
     *
     * @param category Product category to add.
     */
    public void setCategory(String category) {
        this.category.add(category);
    }

    /**
     * Gets the list of product subcategories.
     *
     * @return List of product subcategories.
     */
    public List<String> getSubcategory() {
        return subcategory;
    }

    /**
     * Adds a new product subcategory to the list.
     *
     * @param subcategory Product subcategory to add.
     */
    public void setSubcategory(String subcategory) {
        this.subcategory.add(subcategory);
    }

    /**
     * Gets the list of product image URLs.
     *
     * @return List of product image URLs.
     */
    public List<String> getImageURL() {
        return imageURL;
    }

    /**
     * Adds a new product image URL to the list.
     *
     * @param imageURL Product image URL to add.
     */
    public void setImageURL(String imageURL) {
        this.imageURL.add(imageURL);
    }
}
