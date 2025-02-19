package com.donerhome.entity;

import jakarta.persistence.*;

/**
 * Entity class representing a product in the store.
 * This class maps to the "products" table and holds information about a product,
 * including its name, price, category, subcategory, and image URL.
 */
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Unique identifier for the product (Primary key)

    @Column(name = "name", nullable = false)
    private String productName;  // The name of the product

    @Column(name = "price", nullable = false)
    private Integer price;  // The price of the product

    @Column(name = "category", nullable = false)
    private String category;  // The category to which the product belongs (e.g., electronics, clothing)

    @Column(name = "subcategory")
    private String subcategory;  // The subcategory of the product (e.g., mobile phones, t-shirts)

    @Column(name = "image_url")
    private String imageURL;  // URL to the product image

    /**
     * Default constructor for the ProductEntity class.
     * Initializes an empty ProductEntity object.
     */
    public ProductEntity() {}

    // Getters and setters

    /**
     * Gets the unique identifier of the product.
     *
     * @return The product ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id The product ID to set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return The product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product.
     *
     * @param productName The product name to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the price of the product.
     *
     * @return The product price.
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The product price to set.
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Gets the category of the product.
     *
     * @return The product category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category The product category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the subcategory of the product.
     *
     * @return The product subcategory.
     */
    public String getSubcategory() {
        return subcategory;
    }

    /**
     * Sets the subcategory of the product.
     *
     * @param subcategory The product subcategory to set.
     */
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    /**
     * Gets the URL of the product's image.
     *
     * @return The image URL.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets the URL of the product's image.
     *
     * @param imageURL The image URL to set.
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Converts the ProductEntity object to a string representation.
     *
     * @return A string representing the ProductEntity object.
     */
    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
