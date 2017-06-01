package com.dentalavenue.dentalavenue.viewWishlistPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mukul on 5/31/2017.
 */

public class WishlishtDetailsBean {

@SerializedName("wishlist_detail")
@Expose
private List<WishlistDetail> wishlistDetail = null;

    public List<WishlistDetail> getWishlistDetail() {
        return wishlistDetail;
    }

    public void setWishlistDetail(List<WishlistDetail> wishlistDetail) {
        this.wishlistDetail = wishlistDetail;
    }

}