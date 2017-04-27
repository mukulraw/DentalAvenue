package com.dentalavenue.dentalavenue.banner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Banner {

    @SerializedName("banner_id")
    @Expose
    private String bannerId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private String image;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
