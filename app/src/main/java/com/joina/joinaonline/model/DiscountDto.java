package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscountDto {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("discountCode")
    @Expose
    private String discountCode;
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

    @SerializedName("vendorsId")
    @Expose
    private Long vendorsId;

    public DiscountDto(String name, String discountCode, Double percent, String status, String type, double valueThreshold, String description, String startDate, String endDate, Long vendorsId) {
        this.name = name;
        this.discountCode = discountCode;
        this.percent = percent;
        this.status = status;
        this.type = type;
        this.valueThreshold = valueThreshold;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vendorsId = vendorsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
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

    public Long getVendorsId() {
        return vendorsId;
    }

    public void setVendorsId(Long vendorsId) {
        this.vendorsId = vendorsId;
    }
}
