package com.marolix.laundryapp.models.Products;

public class CouponsModel {
    private int couponAmount = 0;
    private String couponCode = "";
    private String couponId = "";
    private int couponQuantity = 0;
    private String couponStatus = "";
    private String couponType = "";
    private String expiryDate = "";
    private int maxAmount = 0;
    private int percentage = 0;
    private int statusOption = 0;

    public String getCouponId() {
        return this.couponId;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public String getCouponType() {
        return this.couponType;
    }

    public void setCouponType(String str) {
        this.couponType = str;
    }

    public String getCouponStatus() {
        return this.couponStatus;
    }

    public void setCouponStatus(String str) {
        this.couponStatus = str;
    }

    public String getCouponCode() {
        return this.couponCode;
    }

    public void setCouponCode(String str) {
        this.couponCode = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public int getStatusOption() {
        return this.statusOption;
    }

    public void setStatusOption(int i) {
        this.statusOption = i;
    }

    public int getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(int i) {
        this.maxAmount = i;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int i) {
        this.percentage = i;
    }

    public int getCouponAmount() {
        return this.couponAmount;
    }

    public void setCouponAmount(int i) {
        this.couponAmount = i;
    }

    public int getCouponQuantity() {
        return this.couponQuantity;
    }

    public void setCouponQuantity(int i) {
        this.couponQuantity = i;
    }
}
