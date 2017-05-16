package com.dentalavenue.dentalavenue.viewCartPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartDatum {

    @SerializedName("cart_id")
    @Expose
    private String cartId;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_sku")
    @Expose
    private String productSku;
    @SerializedName("product_size")
    @Expose
    private String productSize;
    @SerializedName("mrp_price")
    @Expose
    private String mrpPrice;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("qty")
    @Expose
    private String qty;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(String mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
