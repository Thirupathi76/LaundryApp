package com.marolix.laundryapp.utils;

import com.marolix.laundryapp.models.ExtraServicesModel;
import com.marolix.laundryapp.models.Products.ProductsAddedModel;

import java.util.HashMap;

public class Singleton {
    private static Singleton singleton;
    private AppPreferences appPreferences = null;
    private String dropDate = "";
    private int dropTimeSlotId = 0;
    public HashMap<String, ExtraServicesModel> extraServicesHashMap = new HashMap();
    private String pickupDate = "";
    private int pickupTimeSlotId = 0;
    public HashMap<String, ProductsAddedModel> productsAddedModelHashMap = new HashMap();
    private boolean showDropAddress = false;

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public AppPreferences getPreference() {
        if (this.appPreferences == null) {
            this.appPreferences = new AppPreferences();
        }
        return this.appPreferences;
    }

    public HashMap<String, ProductsAddedModel> getProductsAddedModelHashMap() {
        if (productsAddedModelHashMap == null) {
            productsAddedModelHashMap = new HashMap();
        }
        return productsAddedModelHashMap;
    }

    public void setShowDropAddressStatus(boolean z) {
        this.showDropAddress = z;
    }

    public boolean getShowDropAddressStatus() {
        return this.showDropAddress;
    }

    public void setPickUpDate(String str) {
        this.pickupDate = str;
    }

    public String getPickUpDate() {
        return this.pickupDate;
    }

    public void setDropDate(String str) {
        this.dropDate = str;
    }

    public String getDropDate() {
        return this.dropDate;
    }

    public void setPickTimeSlotId(int i) {
        this.pickupTimeSlotId = i;
    }

    public int getPickTimeSlotId() {
        return this.pickupTimeSlotId;
    }

    public void setDropTimeSlotId(int i) {
        this.dropTimeSlotId = i;
    }

    public int getDropTimeSlotId() {
        return this.dropTimeSlotId;
    }

    public HashMap<String, ExtraServicesModel> getExtraServices() {
        if (this.extraServicesHashMap == null) {
            this.extraServicesHashMap = new HashMap();
        }
        return this.extraServicesHashMap;
    }
}
