package com.dentalavenue.dentalavenue.addCartPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddToCart {

    @SerializedName("cart_id")
    @Expose
    private Integer cartId;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
