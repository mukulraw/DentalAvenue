package com.dentalavenue.dentalavenue.addWishlistPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class addWishlistBean {

    @SerializedName("add_wishlist")
    @Expose
    private List<AddWishlist> addWishlist = null;

    public List<AddWishlist> getAddWishlist() {
        return addWishlist;
    }

    public void setAddWishlist(List<AddWishlist> addWishlist) {
        this.addWishlist = addWishlist;
    }

}
