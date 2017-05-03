package com.dentalavenue.dentalavenue.productPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDetail {
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("pro_name")
    @Expose
    private String proName;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("pro_image")
    @Expose
    private String proImage;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("sale_price_to_doctor")
    @Expose
    private String salePriceToDoctor;
    @SerializedName("sale_price_to_dealer")
    @Expose
    private String salePriceToDealer;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("stock")
    @Expose
    private String stock;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePriceToDoctor() {
        return salePriceToDoctor;
    }

    public void setSalePriceToDoctor(String salePriceToDoctor) {
        this.salePriceToDoctor = salePriceToDoctor;
    }

    public String getSalePriceToDealer() {
        return salePriceToDealer;
    }

    public void setSalePriceToDealer(String salePriceToDealer) {
        this.salePriceToDealer = salePriceToDealer;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

}
