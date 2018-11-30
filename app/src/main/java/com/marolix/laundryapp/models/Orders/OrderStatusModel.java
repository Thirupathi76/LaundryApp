package com.marolix.laundryapp.models.Orders;

import java.io.Serializable;

public class OrderStatusModel implements Serializable {
    private String orderStatus = "";
    private String timeStamp = "";

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }
}
