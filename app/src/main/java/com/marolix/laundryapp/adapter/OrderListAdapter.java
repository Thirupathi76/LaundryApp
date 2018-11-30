package com.marolix.laundryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.marolix.laundryapp.R;
import com.marolix.laundryapp.SthActivity;
import com.marolix.laundryapp.models.Orders.OrderStatusModel;
import com.marolix.laundryapp.models.Orders.OrdersListModel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderListAdapter extends Adapter<OrderListAdapter.MyViewHolder> {
    private String TAG = getClass().getSimpleName();
    private Context context;
    private ArrayList<OrdersListModel> ordersListModelArrayList;

    public class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        TextView addressTitle;
        TextView amount;
        private ImageView img_status;
        TextView mOrderListDateTV;
        TextView mOrderListIdTV;
        LinearLayout mOrderListLL;
        TextView mOrderListPayNowTV;
        TextView mOrderListStatusTV;

        public MyViewHolder(View view) {
            super(view);
            this.mOrderListIdTV = (TextView) view.findViewById(R.id.order_list_id_textView);
            this.mOrderListDateTV = (TextView) view.findViewById(R.id.order_list_date_textView);
            this.mOrderListPayNowTV = (TextView) view.findViewById(R.id.order_list_pay_now_textView);
            this.mOrderListStatusTV = (TextView) view.findViewById(R.id.order_list_status_textView);
            this.mOrderListLL = (LinearLayout) view.findViewById(R.id.order_list_linearLayout);
            this.amount = (TextView) view.findViewById(R.id.amount);
            this.addressTitle = (TextView) view.findViewById(R.id.addressTitle);
            this.img_status = (ImageView) view.findViewById(R.id.img_status);
        }
    }

    public OrderListAdapter(Context context, ArrayList<OrdersListModel> arrayList) {
        this.context = context;
        this.ordersListModelArrayList = arrayList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_orders_list, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder viewHolder, final int i) {
        String string;
        JSONException jSONException;
        TextView textView;
        StringBuilder stringBuilder;
        int i2;
        if (i < this.ordersListModelArrayList.size()) {
            ArrayList orderStatusModelArrayList;
            ArrayList arrayList;
            String str = this.TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onBindViewHolder: ");
            stringBuilder2.append(new Gson().toJson(this.ordersListModelArrayList));
            Log.e(str, stringBuilder2.toString());
            String charSequence = "";
            try {
                charSequence = new SimpleDateFormat("dd MMM, yyyy hh:mm a", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderedDate().replaceAll("Z$", "+0000")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Object ordersPayloadModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrdersPayloadModelArrayList();
            String str2 = this.TAG;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("onBindViewHolder: ");
            stringBuilder3.append(new Gson().toJson(ordersPayloadModelArrayList));
            Log.e(str2, stringBuilder3.toString());
            str2 = "";
            String str3 = "";
            try {
                JSONObject jSONObject = new JSONObject(((OrdersListModel) this.ordersListModelArrayList.get(i)).getPickupAddress());
                string = jSONObject.getString("title");
                try {
                    str2 = jSONObject.getString("area");
                } catch (JSONException e2) {
                    JSONException jSONException2 = e2;
                    str2 = string;
                    jSONException = jSONException2;
                    jSONException.printStackTrace();
                    string = str2;
                    str2 = str3;
                    viewHolder.addressTitle.setText(String.format("%s - %s", new Object[]{str2, string}));
                    textView = viewHolder.amount;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Rs. ");
                    stringBuilder.append(((OrdersListModel) this.ordersListModelArrayList.get(i)).getTotalPrice());
                    stringBuilder.append("");
                    textView.setText(stringBuilder.toString());
                    viewHolder.mOrderListIdTV.setText(((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderId());
                    viewHolder.mOrderListDateTV.setText(charSequence);
                    viewHolder.img_status.bringToFront();
                    orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderStatusModelArrayList();
                    if (orderStatusModelArrayList.size() > 0) {
                        arrayList = new ArrayList();
                        for (i2 = 0; i2 < orderStatusModelArrayList.size(); i2++) {
                            arrayList.add(((OrderStatusModel) orderStatusModelArrayList.get(i2)).getOrderStatus());
                        }
                        if (!arrayList.contains("2010")) {
                            viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_delivered));
                            viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                            viewHolder.img_status.setBackgroundResource((R.drawable.delivered));
                        } else if (!arrayList.contains("2009")) {
                            viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_dispatched));
                            viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                            viewHolder.img_status.setBackgroundResource((R.drawable.deliver));
                        } else if (arrayList.contains("2006")) {
                            viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_washed));
                            viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                            viewHolder.img_status.setBackgroundResource((R.drawable.washing));
                        } else if (!arrayList.contains("2002")) {
                            viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_picked));
                            viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                            viewHolder.img_status.setBackgroundResource((R.drawable.scooter));
                        } else if (arrayList.contains("2001")) {
                            viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.status_2001));
                            viewHolder.mOrderListPayNowTV.setVisibility(View.GONE);
                            viewHolder.img_status.setBackgroundResource((R.drawable.scooter));
                        }
                    }
                    viewHolder.mOrderListLL.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            Intent order = new Intent(OrderListAdapter.this.context, /*OrderDetailsActivity*/SthActivity.class);
                            order.putExtra("SELECTED_POSITION", i);
                            order.putExtra("SELECTED_ORDER", OrderListAdapter.this.ordersListModelArrayList);
                            context.startActivity(order);
                        }
                    });
                }
            } catch (JSONException e3) {
                jSONException = e3;
                jSONException.printStackTrace();
                string = str2;
                str2 = str3;
                viewHolder.addressTitle.setText(String.format("%s - %s", new Object[]{str2, string}));
                textView = viewHolder.amount;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Rs. ");
                stringBuilder.append(((OrdersListModel) this.ordersListModelArrayList.get(i)).getTotalPrice());
                stringBuilder.append("");
                textView.setText(stringBuilder.toString());
                viewHolder.mOrderListIdTV.setText(((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderId());
                viewHolder.mOrderListDateTV.setText(charSequence);
                viewHolder.img_status.bringToFront();
                orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderStatusModelArrayList();
                if (orderStatusModelArrayList.size() > 0) {
                    arrayList = new ArrayList();
                    for (i2 = 0; i2 < orderStatusModelArrayList.size(); i2++) {
                        arrayList.add(((OrderStatusModel) orderStatusModelArrayList.get(i2)).getOrderStatus());
                    }
                    if (!arrayList.contains("2010")) {
                        viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_delivered));
                        viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                        viewHolder.img_status.setBackgroundResource((R.drawable.delivered));
                    } else if (!arrayList.contains("2009")) {
                        viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_dispatched));
                        viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                        viewHolder.img_status.setBackgroundResource((R.drawable.deliver));
                    } else if (arrayList.contains("2006")) {
                        viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_washed));
                        viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                        viewHolder.img_status.setBackgroundResource((R.drawable.washing));
                    } else if (!arrayList.contains("2002")) {
                        viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_picked));
                        viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                        viewHolder.img_status.setBackgroundResource((R.drawable.scooter));
                    } else if (arrayList.contains("2001")) {
                        viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.status_2001));
                        viewHolder.mOrderListPayNowTV.setVisibility(View.GONE);
                        viewHolder.img_status.setBackgroundResource((R.drawable.scooter));
                    }
                }
                viewHolder.mOrderListLL.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
            viewHolder.addressTitle.setText(String.format("%s - %s", new Object[]{str2, string}));
            textView = viewHolder.amount;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Rs. ");
            stringBuilder.append(((OrdersListModel) this.ordersListModelArrayList.get(i)).getTotalPrice());
            stringBuilder.append("");
            textView.setText(stringBuilder.toString());
            viewHolder.mOrderListIdTV.setText(((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderId());
            viewHolder.mOrderListDateTV.setText(charSequence);
            viewHolder.img_status.bringToFront();
            orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(i)).getOrderStatusModelArrayList();
            if (orderStatusModelArrayList.size() > 0) {
                arrayList = new ArrayList();
                for (i2 = 0; i2 < orderStatusModelArrayList.size(); i2++) {
                    arrayList.add(((OrderStatusModel) orderStatusModelArrayList.get(i2)).getOrderStatus());
                }
                if (!arrayList.contains("2010")) {
                    viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_delivered));
                    viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                    viewHolder.img_status.setBackgroundResource((R.drawable.delivered));
                } else if (!arrayList.contains("2009")) {
                    viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_dispatched));
                    viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                    viewHolder.img_status.setBackgroundResource((R.drawable.deliver));
                } else {
                    if (!(arrayList.contains("2003") || arrayList.contains("2004") || arrayList.contains("2005"))) {
                        if (arrayList.contains("2006")) {
                            if (!arrayList.contains("2002")) {
                                viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_picked));
                                viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                                viewHolder.img_status.setBackgroundResource((R.drawable.scooter));
                            } else if (arrayList.contains("2001")) {
                                viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.status_2001));
                                viewHolder.mOrderListPayNowTV.setVisibility(View.GONE);
                                viewHolder.img_status.setBackgroundResource((R.drawable.scooter));
                            }
                        }
                    }
                    viewHolder.mOrderListStatusTV.setText(this.context.getResources().getString(R.string.text_washed));
                    viewHolder.mOrderListPayNowTV.setVisibility(View.VISIBLE);
                    viewHolder.img_status.setBackgroundResource((R.drawable.washing));
                }
            }
            viewHolder.mOrderListLL.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    public int getItemCount() {
        return this.ordersListModelArrayList.size();
    }
}
