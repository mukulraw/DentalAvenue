package com.dentalavenue.dentalavenue.AddRatingPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mukul on 5/31/2017.
 */

public class AddRatingBean {
    @SerializedName("add_rating")
    @Expose
    private List<AddRating> addRating = null;

    public List<AddRating> getAddRating() {
        return addRating;
    }

    public void setAddRating(List<AddRating> addRating) {
        this.addRating = addRating;
    }

}
