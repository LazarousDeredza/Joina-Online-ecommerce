package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {
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
    @SerializedName("vendorId")
    @Expose
    private Long promotionId;
    @SerializedName("vendorId")
    @Expose
    private Long discountId;
    @SerializedName("vendorId")
    @Expose
    private Long taxId;
    @SerializedName("vendorId")
    @Expose
    private Long brandId;
    @SerializedName("categoryId")
    @Expose
    private Long categoryId;
    @SerializedName("subCategoryId")
    @Expose
    private Long subCategoryId;
}
