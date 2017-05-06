package com.dentalavenue.dentalavenue.singleProductPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferToDoctor {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pro_offer")
    @Expose
    private String proOffer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProOffer() {
        return proOffer;
    }

    public void setProOffer(String proOffer) {
        this.proOffer = proOffer;
    }

}
