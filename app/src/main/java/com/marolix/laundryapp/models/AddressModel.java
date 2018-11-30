package com.marolix.laundryapp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddressModel implements Serializable {

    private List<String> addressLines = new ArrayList();
    private String administrativeArea = "";
    private String country = "";
    private GeoLocation latlng = new GeoLocation();
    private String locality = "";
    private String postalCode = "";
    private String subLocality = "";

    public List<String> getAddressLines() {
        return this.addressLines;
    }

    public void setAddressLines(List<String> list) {
        this.addressLines = list;
    }

    public String getSubLocality() {
        return this.subLocality;
    }

    public void setSubLocality(String str) {
        this.subLocality = str;
    }

    public String getLocality() {
        return this.locality;
    }

    public void setLocality(String str) {
        this.locality = str;
    }

    public String getAdministrativeArea() {
        return this.administrativeArea;
    }

    public void setAdministrativeArea(String str) {
        this.administrativeArea = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String str) {
        this.postalCode = str;
    }

    public GeoLocation getLatlng() {
        return this.latlng;
    }

    public void setLatlng(GeoLocation geoLocation) {
        this.latlng = geoLocation;
    }
}
