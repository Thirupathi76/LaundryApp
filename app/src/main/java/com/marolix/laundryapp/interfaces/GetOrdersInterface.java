package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.Orders.OrdersListModel;

import java.util.ArrayList;

public interface GetOrdersInterface {
    void onPostGetOrders(Boolean bool, ArrayList<OrdersListModel> arrayList);
}
