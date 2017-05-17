package com.dentalavenue.dentalavenue.viewRatingPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class viewRatingBean {

    @SerializedName("rating_detail")
    @Expose
    private List<RatingDetail> ratingDetail = null;
    @SerializedName("rating_avg")
    @Expose
    private Double ratingAvg;

    public List<RatingDetail> getRatingDetail() {
        return ratingDetail;
    }

    public void setRatingDetail(List<RatingDetail> ratingDetail) {
        this.ratingDetail = ratingDetail;
    }

    public Double getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(Double ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

}
