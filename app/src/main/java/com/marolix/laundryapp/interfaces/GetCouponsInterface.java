package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.Products.CouponsModel;

import java.util.ArrayList;

public interface GetCouponsInterface {
    void onPostGetCoupons(boolean z, ArrayList<CouponsModel> arrayList);
}
