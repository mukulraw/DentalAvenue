package com.dentalavenue.dentalavenue.countryPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class countryBean {

    @SerializedName("country")
    @Expose
    private List<Country> country = null;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

}
