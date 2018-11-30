package com.marolix.laundryapp.models.Orders;

import java.io.Serializable;

public class OrdersPayloadModel implements Serializable {
    private String productId = "";
    private String productName = "";
    private String productPrice = "";
    private String productQuantity = "";
    private String stain = "";
    private String starch = "";

    public String getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(String str) {
        this.productQuantity = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(String str) {
        this.productPrice = str;
    }

    public String getStarch() {
        return this.starch;
    }

    public void setStarch(String str) {
        this.starch = str;
    }

    public String getStain() {
        return this.stain;
    }

    public void setStain(String str) {
        this.stain = str;
    }
}
