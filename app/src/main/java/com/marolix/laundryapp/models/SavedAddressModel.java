package com.marolix.laundryapp.models;

public class SavedAddressModel {
    private String address = "";
    private String addressId = "";
    private String addressType = "";
    private String area = "";
    private String city = "";
    private String country = "";
    private String doorNo = "";
    private String landmark = "";
    private String lat = "";
    private String lng = "";
    private String pinCode = "";
    private String state = "";
    private String street = "";

    public String getDoorNo() {
        return this.doorNo;
    }

    public void setDoorNo(String str) {
        this.doorNo = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(String str) {
        this.pinCode = str;
    }

    public String getLandmark() {
        return this.landmark;
    }

    public void setLandmark(String str) {
        this.landmark = str;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public void setAddressType(String str) {
        this.addressType = str;
    }

    public String getAddressId() {
        return this.addressId;
    }

    public void setAddressId(String str) {
        this.addressId = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }
}
