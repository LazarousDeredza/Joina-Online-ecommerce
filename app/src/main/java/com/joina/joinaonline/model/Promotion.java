package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promotion {
    @SerializedName("id")
    @Expose
    private Long id;

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
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("vendors")
    @Expose
    private Vendor vendors;

    public Promotion(Long id, String name, String promotionCode, Double percent, String status, String type, double valueThreshold, String description, String startDate, String endDate, String time, String imageUrl, Vendor vendors) {
        this.id = id;
        this.name = name;
        this.promotionCode = promotionCode;
        this.percent = percent;
        this.status = status;
        this.type = type;
        this.valueThreshold = valueThreshold;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.imageUrl = imageUrl;
        this.vendors = vendors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValueThreshold() {
        return valueThreshold;
    }

    public void setValueThreshold(double valueThreshold) {
        this.valueThreshold = valueThreshold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Vendor getVendors() {
        return vendors;
    }

    public void setVendors(Vendor vendors) {
        this.vendors = vendors;
    }
}
