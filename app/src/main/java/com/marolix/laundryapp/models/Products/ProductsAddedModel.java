package com.marolix.laundryapp.models.Products;

public class ProductsAddedModel {
    private String productId = "";
    private String productImage = "";
    private String productName = "";
    private int productPrice = 0;
    private int productQuantity = 0;
    private boolean productStainStatus = false;
    private boolean productStarchStatus = false;
    private boolean stainStatus = false;
    private boolean starchStatus = false;

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(int i) {
        this.productPrice = i;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int i) {
        this.productQuantity = i;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public boolean getProductStainStatus() {
        return this.productStainStatus;
    }

    public void setProductStainStatus(boolean z) {
        this.productStainStatus = z;
    }

    public boolean getProductStarchStatus() {
        return this.productStarchStatus;
    }

    public void setProductStarchStatus(boolean z) {
        this.productStarchStatus = z;
    }

    public boolean isStainStatus() {
        return this.stainStatus;
    }

    public void setStainStatus(boolean z) {
        this.stainStatus = z;
    }

    public boolean isStarchStatus() {
        return this.starchStatus;
    }

    public void setStarchStatus(boolean z) {
        this.starchStatus = z;
    }
}
