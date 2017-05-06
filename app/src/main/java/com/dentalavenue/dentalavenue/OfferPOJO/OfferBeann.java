package com.dentalavenue.dentalavenue.OfferPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mukul on 5/4/2017.
 */

public class OfferBeann {
    @SerializedName("offer")
    @Expose
    private List<Offer> offer = null;

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

}
