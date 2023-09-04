package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vendor {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("telephone")
    @Expose
    private String telephone;

    public Vendor(String name, String logo, String description, String email, String mobile, String telephone) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.email = email;
        this.mobile = mobile;
        this.telephone = telephone;
    }

    public Vendor(Long id, String name, String logo, String description, String email, String mobile, String telephone) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.email = email;
        this.mobile = mobile;
        this.telephone = telephone;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
