package com.dentalavenue.dentalavenue.singleProductPOJO;



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
    @SerializedName("pro_sku")
    @Expose
    private List<ProSku> proSku = null;
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
    @SerializedName("stock")
    @Expose
    private String stock;
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
    @SerializedName("size_type")
    @Expose
    private List<SizeType> sizeType = null;
    @SerializedName("offer_to_doctor")
    @Expose
    private List<OfferToDoctor> offerToDoctor = null;
    @SerializedName("offer_to_dealer")
    @Expose
    private List<Object> offerToDealer = null;

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

    public List<ProSku> getProSku() {
        return proSku;
    }

    public void setProSku(List<ProSku> proSku) {
        this.proSku = proSku;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public List<SizeType> getSizeType() {
        return sizeType;
    }

    public void setSizeType(List<SizeType> sizeType) {
        this.sizeType = sizeType;
    }

    public List<OfferToDoctor> getOfferToDoctor() {
        return offerToDoctor;
    }

    public void setOfferToDoctor(List<OfferToDoctor> offerToDoctor) {
        this.offerToDoctor = offerToDoctor;
    }

    public List<Object> getOfferToDealer() {
        return offerToDealer;
    }

    public void setOfferToDealer(List<Object> offerToDealer) {
        this.offerToDealer = offerToDealer;
    }

}
