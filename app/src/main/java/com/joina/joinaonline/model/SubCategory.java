package com.joina.joinaonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategory {
    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("categoryId")
    @Expose
    private Long categoryId;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("category")
    @Expose
    private Category category;

    public SubCategory(Long id, String name, Long categoryId, String description, String status, Category category) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.status = status;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory(String name, Long categoryId, String description, String status) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SubCategory(String name, Long categoryId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
