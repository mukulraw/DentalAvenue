package com.dentalavenue.dentalavenue.productPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class productbean {



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

