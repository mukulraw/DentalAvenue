package com.dentalavenue.dentalavenue.viewCartPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class viewCartBean {


    @SerializedName("cart_data")
    @Expose
    private List<CartDatum> cartData = null;
    @SerializedName("rewardpoint")
    @Expose
    private String rewardpoint;
    @SerializedName("total")
    @Expose
    private String total;

    public List<CartDatum> getCartData() {
        return cartData;
    }

    public void setCartData(List<CartDatum> cartData) {
        this.cartData = cartData;
    }

    public String getRewardpoint() {
        return rewardpoint;
    }

    public void setRewardpoint(String rewardpoint) {
        this.rewardpoint = rewardpoint;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}