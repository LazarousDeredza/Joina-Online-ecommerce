package com.joina.joinaonline.Joinaonline.adapter;

public class Logo {
    int imageUrl;
    String name;
    public Logo(int imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }
    public int getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
