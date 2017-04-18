package com.dentalavenue.dentalavenue.registerDealerPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class registerDealerBean {

    @SerializedName("register_dealer")
    @Expose
    private List<RegisterDealer> registerDealer = null;

    public List<RegisterDealer> getRegisterDealer() {
        return registerDealer;
    }

    public void setRegisterDealer(List<RegisterDealer> registerDealer) {
        this.registerDealer = registerDealer;
    }

}
