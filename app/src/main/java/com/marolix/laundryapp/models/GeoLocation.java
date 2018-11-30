package com.marolix.laundryapp.models;

import java.io.Serializable;

public class GeoLocation implements Serializable {
    private double lat = 0.0d;
    private double lng = 0.0d;

    public double getLat() {
        return this.lat;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double d) {
        this.lng = d;
    }
}
