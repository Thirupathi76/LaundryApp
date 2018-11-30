package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.SavedAddressModel;

import java.util.ArrayList;

public interface GetSavedAddressInterface {
    void onPostGetAddress(Boolean bool, ArrayList<SavedAddressModel> arrayList);
}
