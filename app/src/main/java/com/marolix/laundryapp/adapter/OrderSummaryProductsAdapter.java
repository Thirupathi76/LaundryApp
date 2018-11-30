package com.marolix.laundryapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.marolix.laundryapp.R;
import com.marolix.laundryapp.models.Orders.OrdersPayloadModel;

import java.util.ArrayList;

public class OrderSummaryProductsAdapter extends RecyclerView.Adapter<OrderSummaryProductsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<OrdersPayloadModel> ordersPayloadModelArrayList;

    public class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public TextView mSummaryProductNameTV;
        public TextView mSummaryProductPriceTV;
        public TextView mSummaryProductQuantityTV;
        public TextView mSummaryProductStainTV;
        public TextView mSummaryProductStarchTV;

        public MyViewHolder(View view) {
            super(view);
            mSummaryProductNameTV = view.findViewById(R.id.summary_product_name_textView);
            mSummaryProductQuantityTV = view.findViewById(R.id.summary_product_quantity_textView);
            mSummaryProductPriceTV = view.findViewById(R.id.summary_product_price_textView);
            mSummaryProductStainTV = view.findViewById(R.id.summary_product_stain_textView);
            mSummaryProductStarchTV = view.findViewById(R.id.summary_product_starch_textView);
        }
    }

    public OrderSummaryProductsAdapter(Context context, ArrayList<OrdersPayloadModel> arrayList) {
        this.context = context;
        this.ordersPayloadModelArrayList = arrayList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_summary_items_list, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        if (i < this.ordersPayloadModelArrayList.size()) {
            viewHolder.mSummaryProductNameTV.setText(((OrdersPayloadModel) this.ordersPayloadModelArrayList.get(i)).getProductName());
            viewHolder.mSummaryProductQuantityTV.setText(((OrdersPayloadModel) this.ordersPayloadModelArrayList.get(i)).getProductQuantity());
            int parseInt = Integer.parseInt(((OrdersPayloadModel) this.ordersPayloadModelArrayList.get(i)).getProductPrice());
            viewHolder.mSummaryProductPriceTV.setText(String.format("Rs. %s", new Object[]{String.valueOf(parseInt)}));
            if (((OrdersPayloadModel) this.ordersPayloadModelArrayList.get(i)).getStain().equals("false")) {
                viewHolder.mSummaryProductStainTV.setVisibility(View.GONE);
            }
            if ((ordersPayloadModelArrayList.get(i)).getStarch().equals("false")) {
                viewHolder.mSummaryProductStarchTV.setVisibility(View.GONE);
            }
        }
    }

    public int getItemCount() {
        return this.ordersPayloadModelArrayList.size();
    }
}
