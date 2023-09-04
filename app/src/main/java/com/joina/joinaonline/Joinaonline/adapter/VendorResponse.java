package com.joina.joinaonline.Joinaonline.adapter;

public class VendorResponse {

    Integer prod_id;
    String prod_name;
    String price;
    String desc;
    int imageUrl;

    public VendorResponse(Integer prod_id, String prod_name, String price, String desc, int qty) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.price = price;
        this.desc = desc;
        this.imageUrl = qty;
    }

    public VendorResponse(Integer prod_id, String prod_name, String price, int qty) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
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
