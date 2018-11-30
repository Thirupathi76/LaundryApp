package com.marolix.laundryapp.models;

public class BannersModel {
    private String bannerId = "";
    private String bannerImage = "";

    public String getBannerImage() {
        return this.bannerImage;
    }

    public void setBannerImage(String str) {
        this.bannerImage = str;
    }

    public String getBannerId() {
        return this.bannerId;
    }

    public void setBannerId(String str) {
        this.bannerId = str;
    }
}
