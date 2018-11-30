package com.marolix.laundryapp.models.Products;

public class ProductsModel {
    private String ProductCategoryId = "";
    private String productDesc = "";
    private String productId = "";
    private String productImage = "";
    private String productName = "";
    private int productPrice = 0;
    private String productQuantity = "";
    private String productStatus = "";
    private String stainStatus = "";
    private String starchStatus = "";

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(String str) {
        this.productQuantity = str;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(int i) {
        this.productPrice = i;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String str) {
        this.productDesc = str;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(String str) {
        this.productStatus = str;
    }

    public String getProductCategoryId() {
        return this.ProductCategoryId;
    }

    public void setProductCategoryId(String str) {
        this.ProductCategoryId = str;
    }

    public String getStarchStatus() {
        return this.starchStatus;
    }

    public void setStarchStatus(String str) {
        this.starchStatus = str;
    }

    public String getStainStatus() {
        return this.stainStatus;
    }

    public void setStainStatus(String str) {
        this.stainStatus = str;
    }
}
