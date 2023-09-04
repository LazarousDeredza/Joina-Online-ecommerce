package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDto {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("unit_price")
    @Expose
    private double unit_price;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("image1")
    @Expose
    private String image1;
    @SerializedName("image2")
    @Expose
    private String image2;
    @SerializedName("image3")
    @Expose
    private String image3;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("vendorId")
    @Expose
    private Long vendorId;
    @SerializedName("promotionId")
    @Expose
    private Long promotionId;
    @SerializedName("discountId")
    @Expose
    private Long discountId;
    @SerializedName("taxId")
    @Expose
    private Long taxId;
    @SerializedName("brandId")
    @Expose
    private Long brandId;
    @SerializedName("categoryId")
    @Expose
    private Long categoryId;
    @SerializedName("subCategoryId")
    @Expose
    private Long subCategoryId;

    public ProductDto(String name, String description, double unit_price, double quantity, String image1, String image2, String image3, String status, Long vendorId, Long promotionId, Long discountId, Long taxId, Long brandId, Long categoryId, Long subCategoryId) {
        this.name = name;
        this.description = description;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.status = status;
        this.vendorId = vendorId;
        this.promotionId = promotionId;
        this.discountId = discountId;
        this.taxId = taxId;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
    }

    public ProductDto(String image1, String name, double unit_price) {
        this.image1 = image1;
        this.name = name;
        this.unit_price = unit_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
}
