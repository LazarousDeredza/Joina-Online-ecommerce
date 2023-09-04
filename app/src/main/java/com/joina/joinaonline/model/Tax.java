package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("percentage")
    @Expose
    private double percentage;
    @SerializedName("vendors")
    @Expose
    private Vendor vendor;

    public Tax(Long id, String name, String description, double percentage, Vendor vendor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.vendor = vendor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
