package com.dentalavenue.dentalavenue.singleProductPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class singleProductBean {

    @SerializedName("product_detail")
    @Expose
    private List<ProductDetail> productDetail = null;

    public List<ProductDetail> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(List<ProductDetail> productDetail) {
        this.productDetail = productDetail;
    }

}
