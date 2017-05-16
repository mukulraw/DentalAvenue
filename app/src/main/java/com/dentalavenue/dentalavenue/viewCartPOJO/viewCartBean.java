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
    private Integer rewardpoint;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<CartDatum> getCartData() {
        return cartData;
    }

    public void setCartData(List<CartDatum> cartData) {
        this.cartData = cartData;
    }

    public Integer getRewardpoint() {
        return rewardpoint;
    }

    public void setRewardpoint(Integer rewardpoint) {
        this.rewardpoint = rewardpoint;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
