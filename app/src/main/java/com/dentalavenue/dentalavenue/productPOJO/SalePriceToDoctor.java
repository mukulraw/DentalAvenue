package com.dentalavenue.dentalavenue.productPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalePriceToDoctor {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("price")
    @Expose
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
