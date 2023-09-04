package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("logo_url")
    @Expose
    private String logo_url;

    public Brand(Long id, String name, String description, String logo_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo_url = logo_url;
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

    public void setDescription(String name) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logo_url;
    }

    public void setLogoUrl(String logo_url) {
        this.logo_url = logo_url;
    }

    public Brand(String name, String description, String logo_url) {
        this.description = description;
        this.logo_url = logo_url;
        this.name = name;
    }

}
