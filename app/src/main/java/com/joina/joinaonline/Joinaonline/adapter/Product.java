package com.joina.joinaonline.Joinaonline.adapter;

public class Product {

    Integer prod_id;
    String prod_name;
    String quantity;
    String brand;
    String price;
    String desc;
    int imageUrl;

    public Product(Integer prod_id, String prod_name, String quantity, String brand, String price, String desc, int qty) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
        this.desc = desc;
        this.imageUrl = qty;
    }

    public Product(Integer prod_id, String prod_name, String brand, String price, int qty) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.brand = brand;
        this.price = price;
        this.imageUrl = qty;
    }

    public Product(Integer prod_id, String prod_name, String quantity, String brand, String price, int qty) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
        this.imageUrl = qty;
    }

    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String quantity) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
