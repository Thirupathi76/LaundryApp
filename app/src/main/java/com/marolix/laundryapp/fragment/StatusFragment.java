package com.marolix.laundryapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.models.Orders.OrderStatusModel;
import com.marolix.laundryapp.models.Orders.OrdersListModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class StatusFragment extends Fragment {
    private TextView mDeliveredMessageTV;
    private ImageView mDeliveredTickIB;
    private TextView mDispatchedMessageTV;
    private ImageView mDispatchedStatusLineIV;
    private ImageView mDispatchedTickIB;
    private TextView mPickedMessageTV;
    private ImageView mPickedStatusLineIV;
    private ImageView mPickedTickIB;
    private TextView mStatusAmountTV;
    private TextView mStatusDeliveryAddressTimeTV;
    private TextView mStatusDeliveryAddressTypeTV;
    private ImageView mStatusOrderStatusIV;
    private TextView mStatusPayNowTV;
    private TextView mStatusStatusTV;
    private ImageView mWashedStatusLineIV;
    private ImageView mWashedTickIB;
    private TextView mWashingMessageTV;
    private int orderPosition = 0;
    private ArrayList<OrdersListModel> ordersListModelArrayList;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View layoutInflater = inflater.inflate(R.layout.fragment_status, viewGroup, false);
        this.mStatusAmountTV = (TextView) layoutInflater.findViewById(R.id.status_amount_textView);
        this.mStatusStatusTV = (TextView) layoutInflater.findViewById(R.id.status_status_textView);
        this.mStatusPayNowTV = (TextView) layoutInflater.findViewById(R.id.status_pay_now_textView);
        this.mStatusDeliveryAddressTypeTV = (TextView) layoutInflater.findViewById(R.id.status_delivery_address_type_textView);
        this.mStatusDeliveryAddressTimeTV = (TextView) layoutInflater.findViewById(R.id.status_delivery_address_time_textView);
        this.mPickedMessageTV = (TextView) layoutInflater.findViewById(R.id.picked_message_textView);
        this.mWashingMessageTV = (TextView) layoutInflater.findViewById(R.id.washing_message_textView);
        this.mDispatchedMessageTV = (TextView) layoutInflater.findViewById(R.id.dispatched_message_textView);
        this.mDeliveredMessageTV = (TextView) layoutInflater.findViewById(R.id.delivered_message_textView);
        this.mStatusOrderStatusIV = (ImageView) layoutInflater.findViewById(R.id.status_order_status_imageView);
        this.mPickedStatusLineIV = (ImageView) layoutInflater.findViewById(R.id.picked_status_line_imageView);
        this.mWashedStatusLineIV = (ImageView) layoutInflater.findViewById(R.id.washed_status_line_imageView);
        this.mDispatchedStatusLineIV = (ImageView) layoutInflater.findViewById(R.id.dispatched_status_line_imageView);
        this.mPickedTickIB = (ImageView) layoutInflater.findViewById(R.id.picked_tick_imageButton);
        this.mWashedTickIB = (ImageView) layoutInflater.findViewById(R.id.washed_tick_imageButton);
        this.mDispatchedTickIB = (ImageView) layoutInflater.findViewById(R.id.dispatched_tick_imageButton);
        this.mDeliveredTickIB = (ImageView) layoutInflater.findViewById(R.id.delivered_tick_imageButton);
        Bundle args = getArguments();
        this.orderPosition = args.getInt("ORDER_POSITION");
        this.ordersListModelArrayList = (ArrayList) args.getSerializable("ORDER_LIST");
        orderStatus();
        return layoutInflater;
    }

    private void orderStatus() {
        int totalPrice = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getTotalPrice();
        this.mStatusStatusTV.setText("Unpaid");
        TextView textView = this.mStatusAmountTV;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rs.");
        stringBuilder.append(String.valueOf(totalPrice));
        textView.setText(stringBuilder.toString());
        CharSequence charSequence = "";
        try {
            charSequence = new JSONObject(ordersListModelArrayList.get(orderPosition).getDeliveryAddress()).getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mStatusDeliveryAddressTypeTV.setText(charSequence);
        charSequence = "";
        try {
            charSequence = new SimpleDateFormat("dd MMM,yyyy hh:mm aaa", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryDate().replaceAll("Z$", "+0000")));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        this.mStatusDeliveryAddressTimeTV.setText(charSequence);
        ArrayList orderStatusModelArrayList = (ordersListModelArrayList.get(orderPosition)).getOrderStatusModelArrayList();
        if (orderStatusModelArrayList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < orderStatusModelArrayList.size(); i++) {
                arrayList.add(((OrderStatusModel) orderStatusModelArrayList.get(i)).getOrderStatus());
            }
            if (arrayList.contains("2010")) {
                this.mStatusOrderStatusIV.setImageResource(R.drawable.orders_delivered);
                this.mPickedStatusLineIV.setImageResource(R.color.colorAccent);
                this.mWashedStatusLineIV.setImageResource(R.color.colorAccent);
                this.mDispatchedStatusLineIV.setImageResource(R.color.colorAccent);
                this.mPickedTickIB.setImageResource(R.drawable.tick);
                this.mWashedTickIB.setImageResource(R.drawable.tick);
                this.mDispatchedTickIB.setImageResource(R.drawable.tick);
                this.mDeliveredTickIB.setImageResource(R.drawable.tick);
                this.mPickedMessageTV.setVisibility(View.VISIBLE);
                this.mWashingMessageTV.setVisibility(View.VISIBLE);
                this.mDispatchedMessageTV.setVisibility(View.VISIBLE);
                this.mDeliveredMessageTV.setVisibility(View.VISIBLE);
                this.mStatusPayNowTV.setVisibility(View.VISIBLE);
            } else if (arrayList.contains("2009")) {
                this.mStatusOrderStatusIV.setImageResource(R.drawable.orders_dispatched);
                this.mPickedStatusLineIV.setImageResource(R.color.colorAccent);
                this.mWashedStatusLineIV.setImageResource(R.color.colorAccent);
                this.mPickedTickIB.setImageResource(R.drawable.tick);
                this.mWashedTickIB.setImageResource(R.drawable.tick);
                this.mDispatchedTickIB.setImageResource(R.drawable.tick);
                this.mPickedMessageTV.setVisibility(View.VISIBLE);
                this.mWashingMessageTV.setVisibility(View.VISIBLE);
                this.mDispatchedMessageTV.setVisibility(View.VISIBLE);
                this.mStatusPayNowTV.setVisibility(View.VISIBLE);
            } else if (arrayList.contains("2007")) {
                this.mStatusOrderStatusIV.setImageResource(R.drawable.orders_washing);
                this.mPickedStatusLineIV.setImageResource(R.color.colorAccent);
                this.mPickedTickIB.setImageResource(R.drawable.tick);
                this.mWashedTickIB.setImageResource(R.drawable.tick);
                this.mPickedMessageTV.setVisibility(View.VISIBLE);
                this.mWashingMessageTV.setVisibility(View.VISIBLE);
                this.mStatusPayNowTV.setVisibility(View.VISIBLE);
            } else if (arrayList.contains("2003")) {
                this.mStatusOrderStatusIV.setImageResource(R.drawable.orders_picked);
                this.mPickedTickIB.setImageResource(R.drawable.tick);
                this.mPickedMessageTV.setVisibility(View.VISIBLE);
                this.mStatusPayNowTV.setVisibility(View.VISIBLE);
            } else if (arrayList.contains("2001")) {
                this.mStatusOrderStatusIV.setImageDrawable(getResources().getDrawable(R.drawable.orders_placed));
                this.mStatusPayNowTV.setVisibility(View.GONE);
            }
        }
    }
}
