package com.dentalavenue.dentalavenue.singleProductPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProSku {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sku")
    @Expose
    private String sku;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
