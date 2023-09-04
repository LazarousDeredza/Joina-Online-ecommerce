package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PromotionDto {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("promotionCode")
    @Expose
    private String promotionCode;
    @SerializedName("percent")
    @Expose
    private Double percent;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("valueThreshold")
    @Expose
    private double valueThreshold;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("vendorsId")
    @Expose
    private Long vendorsId;
}
