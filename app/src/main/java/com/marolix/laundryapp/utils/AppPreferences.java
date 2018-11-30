package com.marolix.laundryapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    private final String DEVICE_TOKEN = "DEVICETOKEN";
    private final String DROP_ADDRESS_ID = "DROP_ADDRESS_ID";
    private final String LOGIN_STATE = "LOGIN_STATE";
    private final String PICKUP_ADDRESS_ID = "PICKUP_ADDRESS_ID";
    private final String SAVED_ADDRESS = "SAVED_ADDRESS";
    private final String SAVED_DROP_ADDRESS = "SAVED_DROP_ADDRESS";
    private final String SAVED_PICKUP_ADDRESS = "SAVED_PICKUP_ADDRESS";
    private final String USER_DETAILS = "USER_DETAILS";
    private final String USER_ID = "USER_ID";
    private final String USER_PHONE = "USER_PHONE";

    public void saveDeviceToken(Context context, String str) {
       SharedPreferences.Editor con = context.getSharedPreferences("DEVICETOKEN", 0).edit();
        con.putString("deviceToken", str);
        con.apply();
    }

    public String getDeviceToken(Context context) {
        return context.getSharedPreferences("DEVICETOKEN", 0).getString("deviceToken", "");
    }

    public void saveUserPhone(Context context, String str) {
        SharedPreferences.Editor con = context.getSharedPreferences("USER_PHONE", 0).edit();
        con.putString("userPhone", str);
        con.apply();
    }

    public String getUserPhone(Context context) {
        return context.getSharedPreferences("USER_PHONE", 0).getString("userPhone", "");
    }

    public void saveUserId(Context context, String str) {

        SharedPreferences.Editor con = context.getSharedPreferences("USER_ID", 0).edit();
        con.putString("userId", str);
        con.apply();
    }

    public String getUserId(Context context) {
        return context.getSharedPreferences("USER_ID", 0).getString("userId", "");
    }

    public void saveLoginState(Context context, boolean z) {
        SharedPreferences.Editor con = context.getSharedPreferences("LOGIN_STATE", 0).edit();
        con.putBoolean("status", z);
        con.apply();
    }

    public boolean getLoginState(Context context) {
        return context.getSharedPreferences("LOGIN_STATE", 0).getBoolean("status", false);
    }

    public void saveUserDetails(Context con, String str) {
        SharedPreferences.Editor context = con.getSharedPreferences("USER_DETAILS", 0).edit();
        context.putString("userDetails", str);
        context.apply();
    }

    public String getUserDetails(Context context) {
        return context.getSharedPreferences("USER_DETAILS", 0).getString("userDetails", "");
    }

    public void saveAddress(Context con, String str) {
        SharedPreferences.Editor context = con.getSharedPreferences("SAVED_ADDRESS", 0).edit();
        context.putString("saveAddress", str);
        context.apply();
    }

    public String getAddress(Context context) {
        return context.getSharedPreferences("SAVED_ADDRESS", 0).getString("saveAddress", "");
    }

    public void savePickupAddress(Context con, String str) {
        SharedPreferences.Editor context = con.getSharedPreferences("SAVED_PICKUP_ADDRESS", 0).edit();
        context.putString("savePickupAddress", str);
        context.apply();
    }

    public String getPickupAddress(Context context) {
        return context.getSharedPreferences("SAVED_PICKUP_ADDRESS", 0).getString("savePickupAddress", "");
    }

    public void saveDropAddress(Context con, String str) {
        SharedPreferences.Editor context = con.getSharedPreferences("SAVED_DROP_ADDRESS", 0).edit();
        context.putString("saveDropAddress", str);
        context.apply();
    }

    public String getDropAddress(Context context) {
        return context.getSharedPreferences("SAVED_DROP_ADDRESS", 0).getString("saveDropAddress", "");
    }

    public void savePickupAddressID(Context con, String str) {
        SharedPreferences.Editor context = con.getSharedPreferences("PICKUP_ADDRESS_ID", 0).edit();
        context.putString("savePickupAddressId", str);
        context.apply();
    }

    public String getPickupAddressId(Context context) {
        return context.getSharedPreferences("PICKUP_ADDRESS_ID", 0).getString("savePickupAddressId", "");
    }

    public void saveDropAddressId(Context con, String str) {
        SharedPreferences.Editor context = con.getSharedPreferences("DROP_ADDRESS_ID", 0).edit();
        context.putString("saveDropAddressId", str);
        context.apply();
    }

    public String getDropAddressId(Context context) {
        return context.getSharedPreferences("DROP_ADDRESS_ID", 0).getString("saveDropAddressId", "");
    }
}
