package com.dentalavenue.dentalavenue.addWishlistPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddWishlist {

    @SerializedName("whislist_id")
    @Expose
    private String whislistId;
    @SerializedName("message")
    @Expose
    private String message;

    public String getWhislistId() {
        return whislistId;
    }

    public void setWhislistId(String whislistId) {
        this.whislistId = whislistId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
