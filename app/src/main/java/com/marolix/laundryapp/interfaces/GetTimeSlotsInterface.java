package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.TimeSlotsModel;

import java.util.ArrayList;

public interface GetTimeSlotsInterface {
    void onPostGetTimeSlots(boolean bool, ArrayList<TimeSlotsModel> arrayList);
}
