package com.dentalavenue.dentalavenue.viewWishlistPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mukul on 5/31/2017.
 */

public class WishlistDetail {
    @SerializedName("whislist_id")
    @Expose
    private String whislistId;
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("pro_image")
    @Expose
    private String proImage;
    @SerializedName("pro_sku")
    @Expose
    private String proSku;
    @SerializedName("price_to_doctor")
    @Expose
    private Object priceToDoctor;
    @SerializedName("price_to_dealer")
    @Expose
    private Object priceToDealer;
    @SerializedName("sale_price_to_doctor")
    @Expose
    private String salePriceToDoctor;
    @SerializedName("sale_price_to_dealer")
    @Expose
    private Object salePriceToDealer;
    @SerializedName("qty")
    @Expose
    private Object qty;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("dentistry")
    @Expose
    private Object dentistry;
    @SerializedName("pro_detail")
    @Expose
    private String proDetail;
    @SerializedName("key_features")
    @Expose
    private String keyFeatures;
    @SerializedName("indications")
    @Expose
    private String indications;
    @SerializedName("technical_data")
    @Expose
    private String technicalData;
    @SerializedName("packaging")
    @Expose
    private String packaging;
    @SerializedName("company")
    @Expose
    private Object company;
    @SerializedName("types")
    @Expose
    private Object types;
    @SerializedName("offer")
    @Expose
    private Object offer;
    @SerializedName("message")
    @Expose
    private String message;

    public String getWhislistId() {
        return whislistId;
    }

    public void setWhislistId(String whislistId) {
        this.whislistId = whislistId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
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

    public String getProSku() {
        return proSku;
    }

    public void setProSku(String proSku) {
        this.proSku = proSku;
    }

    public Object getPriceToDoctor() {
        return priceToDoctor;
    }

    public void setPriceToDoctor(Object priceToDoctor) {
        this.priceToDoctor = priceToDoctor;
    }

    public Object getPriceToDealer() {
        return priceToDealer;
    }

    public void setPriceToDealer(Object priceToDealer) {
        this.priceToDealer = priceToDealer;
    }

    public String getSalePriceToDoctor() {
        return salePriceToDoctor;
    }

    public void setSalePriceToDoctor(String salePriceToDoctor) {
        this.salePriceToDoctor = salePriceToDoctor;
    }

    public Object getSalePriceToDealer() {
        return salePriceToDealer;
    }

    public void setSalePriceToDealer(Object salePriceToDealer) {
        this.salePriceToDealer = salePriceToDealer;
    }

    public Object getQty() {
        return qty;
    }

    public void setQty(Object qty) {
        this.qty = qty;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Object getDentistry() {
        return dentistry;
    }

    public void setDentistry(Object dentistry) {
        this.dentistry = dentistry;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail;
    }

    public String getKeyFeatures() {
        return keyFeatures;
    }

    public void setKeyFeatures(String keyFeatures) {
        this.keyFeatures = keyFeatures;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getTechnicalData() {
        return technicalData;
    }

    public void setTechnicalData(String technicalData) {
        this.technicalData = technicalData;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public Object getTypes() {
        return types;
    }

    public void setTypes(Object types) {
        this.types = types;
    }

    public Object getOffer() {
        return offer;
    }

    public void setOffer(Object offer) {
        this.offer = offer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}