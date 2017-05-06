package com.dentalavenue.dentalavenue.singleProductPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qty {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pro_qty")
    @Expose
    private String proQty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProQty() {
        return proQty;
    }

    public void setProQty(String proQty) {
        this.proQty = proQty;
    }

}
