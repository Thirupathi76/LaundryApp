package com.marolix.laundryapp.models.Orders;

import java.io.Serializable;
import java.util.ArrayList;

public class OrdersListModel implements Serializable {
    private String cityCode = "";
    private String couponCode = "";
    private String deliveryAddress = "";
    private int deliveryCharge = 0;
    private String deliveryDate = "";
    private String deliveryType = "";
    private int discount = 0;
    private String dropSlotId = "";
    private int extraServiceAmount = 0;
    private int extraServiceStainQuantity = 0;
    private int extraServiceStarchQuantity = 0;
    private String franchiseOrder = "";
    private String orderId = "";
    private String orderStatus = "";
    private ArrayList<OrderStatusModel> orderStatusModelArrayList = null;
    private String orderedDate = "";
    private ArrayList<OrdersPayloadModel> ordersPayloadModelArrayList = null;
    private String paymentMode = "";
    private String paymentStatus = "";
    private String pickupAddress = "";
    private String pickupDate = "";
    private String pickupSlotId = "";
    private int subTotal = 0;
    private int totalPrice = 0;
    private int totalQuantity = 0;
    private String userId = "";

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getDeliveryType() {
        return this.deliveryType;
    }

    public void setDeliveryType(String str) {
        this.deliveryType = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public String getOrderedDate() {
        return this.orderedDate;
    }

    public void setOrderedDate(String str) {
        this.orderedDate = str;
    }

    public String getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(String str) {
        this.pickupDate = str;
    }

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public String getPickupAddress() {
        return this.pickupAddress;
    }

    public void setPickupAddress(String str) {
        this.pickupAddress = str;
    }

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String str) {
        this.deliveryAddress = str;
    }

    public String getFranchiseOrder() {
        return this.franchiseOrder;
    }

    public void setFranchiseOrder(String str) {
        this.franchiseOrder = str;
    }

    public String getCouponCode() {
        return this.couponCode;
    }

    public void setCouponCode(String str) {
        this.couponCode = str;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public String getPickupSlotId() {
        return this.pickupSlotId;
    }

    public void setPickupSlotId(String str) {
        this.pickupSlotId = str;
    }

    public String getDropSlotId() {
        return this.dropSlotId;
    }

    public void setDropSlotId(String str) {
        this.dropSlotId = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public int getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(int i) {
        this.subTotal = i;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int i) {
        this.discount = i;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(int i) {
        this.totalPrice = i;
    }

    public int getDeliveryCharge() {
        return this.deliveryCharge;
    }

    public void setDeliveryCharge(int i) {
        this.deliveryCharge = i;
    }

    public int getExtraServiceAmount() {
        return this.extraServiceAmount;
    }

    public void setExtraServiceAmount(int i) {
        this.extraServiceAmount = i;
    }

    public int getExtraServiceStainQuantity() {
        return this.extraServiceStainQuantity;
    }

    public void setExtraServiceStainQuantity(int i) {
        this.extraServiceStainQuantity = i;
    }

    public int getExtraServiceStarchQuantity() {
        return this.extraServiceStarchQuantity;
    }

    public void setExtraServiceStarchQuantity(int i) {
        this.extraServiceStarchQuantity = i;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(String str) {
        this.paymentStatus = str;
    }

    public ArrayList<OrderStatusModel> getOrderStatusModelArrayList() {
        return this.orderStatusModelArrayList;
    }

    public void setOrderStatusModelArrayList(ArrayList<OrderStatusModel> arrayList) {
        this.orderStatusModelArrayList = arrayList;
    }

    public ArrayList<OrdersPayloadModel> getOrdersPayloadModelArrayList() {
        return this.ordersPayloadModelArrayList;
    }

    public void setOrdersPayloadModelArrayList(ArrayList<OrdersPayloadModel> arrayList) {
        this.ordersPayloadModelArrayList = arrayList;
    }

    public int getTotalQuantity() {
        return this.totalQuantity;
    }

    public void setTotalQuantity(int i) {
        this.totalQuantity = i;
    }
}
