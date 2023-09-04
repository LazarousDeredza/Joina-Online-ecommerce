package com.joina.joinaonline.model.master;

public class Product {
    String id;
    String categoryId;
    String title;
    String description;
    String attribute;
    String currency;
    String price;
    String discount;
    String image;

    String supplierName;
    int supplierImage;



    public Product() {
    }

    public Product(String id, String categoryId, String title, String description, String attribute, String price, String discount, String image) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.attribute = attribute;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    public Product(String id, String categoryId, String title, String description, String attribute, String currency, String price, String discount, String image) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.attribute = attribute;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    public Product(String id, String categoryId, String title, String description, String attribute, String price, String discount, String image, String supplierName, int supplierImage) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.attribute = attribute;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.supplierName = supplierName;
        this.supplierImage = supplierImage;
    }

    public Product(String id, String categoryId, String title, String description, String attribute, String currency, String price, String discount, String image, String supplierName, int supplierImage) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.attribute = attribute;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.supplierName = supplierName;
        this.supplierImage = supplierImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierImage() {
        return supplierImage;
    }

    public void setSupplierImage(int supplierImage) {
        this.supplierImage = supplierImage;
    }
}
