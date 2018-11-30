package com.marolix.laundryapp.interfaces;

import android.location.Address;
import java.util.List;

public interface GetAddressInterface {
    void onAddressDecoded(List<Address> list);
}
