package com.dentalavenue.dentalavenue.productPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    private List<Price> price = null;
    @SerializedName("sale_price_to_doctor")
    @Expose
    private List<SalePriceToDoctor> salePriceToDoctor = null;
    @SerializedName("sale_price_to_dealer")
    @Expose
    private List<SalePriceToDealer> salePriceToDealer = null;
    @SerializedName("qty")
    @Expose
    private List<Qty> qty = null;
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

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }

    public List<SalePriceToDoctor> getSalePriceToDoctor() {
        return salePriceToDoctor;
    }

    public void setSalePriceToDoctor(List<SalePriceToDoctor> salePriceToDoctor) {
        this.salePriceToDoctor = salePriceToDoctor;
    }

    public List<SalePriceToDealer> getSalePriceToDealer() {
        return salePriceToDealer;
    }

    public void setSalePriceToDealer(List<SalePriceToDealer> salePriceToDealer) {
        this.salePriceToDealer = salePriceToDealer;
    }

    public List<Qty> getQty() {
        return qty;
    }

    public void setQty(List<Qty> qty) {
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
