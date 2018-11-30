package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.BannersModel;

import java.util.ArrayList;

public interface GetBannersInterface {
    void onPostGetBanners(boolean bool, ArrayList<BannersModel> arrayList);
}
