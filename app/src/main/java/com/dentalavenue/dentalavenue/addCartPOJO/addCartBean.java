package com.dentalavenue.dentalavenue.addCartPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class addCartBean {

    @SerializedName("Add To Cart")
    @Expose
    private List<AddToCart> addToCart = null;

    public List<AddToCart> getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(List<AddToCart> addToCart) {
        this.addToCart = addToCart;
    }

}
