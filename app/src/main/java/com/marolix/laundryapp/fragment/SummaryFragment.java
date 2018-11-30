package com.marolix.laundryapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.marolix.laundryapp.R;
import com.marolix.laundryapp.adapter.OrderSummaryProductsAdapter;
import com.marolix.laundryapp.models.Orders.OrderStatusModel;
import com.marolix.laundryapp.models.Orders.OrdersListModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SummaryFragment extends Fragment {
    private RelativeLayout createdRL;
    private RelativeLayout deliveredRL;
    private RelativeLayout dispatchedRL;
    private ImageView imgDelivered;
    private ImageView imgDispatched;
    private ImageView imgPicked;
    private ImageView imgWashing;
    private TextView mSummaryCancelOrderTV;
    private TextView mSummaryCouponAmountTV;
    private TextView mSummaryCouponAppliedTV;
    private TextView mSummaryDeliveryAddressTV;
    private TextView mSummaryDeliveryAmountTV;
    private TextView mSummaryDeliveryDateTV;
    private TextView mSummaryExtraServiceAmountTV;
    private TextView mSummaryFinalAmountTV;
    private RecyclerView mSummaryItemsListRV;
    private TextView mSummaryNoItemsTV;
    private LinearLayout mSummaryPaidLL;
    private TextView mSummaryPaidViaTV;
    private TextView mSummaryPickupAddressTV;
    private TextView mSummaryPickupDateTV;
    private TextView mSummaryTotalAmountTV;
    private LinearLayoutManager myLinearLayoutManager;
    private int orderPosition = 0;
    private OrderSummaryProductsAdapter orderSummaryProductsAdapter;
    private ArrayList<OrdersListModel> ordersListModelArrayList;
    private RelativeLayout pickedRL;
    private LinearLayout statusLL;
    private TextView totalQuantity;
    private TextView txtDelivered;
    private TextView txtDispatched;
    private TextView txtPicked;
    private TextView txtWashing;
    private RelativeLayout washingRL;

    /* renamed from: com.laundrykart.fragments.Orders.SummaryFragment$1 */
    class C07491 implements OnClickListener {
        public void onClick(View view) {
        }

        C07491() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
       View layoutInflater = inflater.inflate(R.layout.fragment_summary, viewGroup, false);
        this.mSummaryPickupAddressTV = (TextView) layoutInflater.findViewById(R.id.summary_pickup_address_textView);
        this.mSummaryPickupDateTV = (TextView) layoutInflater.findViewById(R.id.summary_pickup_date_textView);
        this.mSummaryTotalAmountTV = (TextView) layoutInflater.findViewById(R.id.summary_total_amount_textView);
        this.mSummaryExtraServiceAmountTV = (TextView) layoutInflater.findViewById(R.id.summary_extra_service_amount_textView);
        this.mSummaryDeliveryAmountTV = (TextView) layoutInflater.findViewById(R.id.summary_delivery_amount_textView);
        this.mSummaryCouponAppliedTV = (TextView) layoutInflater.findViewById(R.id.summary_coupon_applied_textView);
        this.mSummaryCouponAmountTV = (TextView) layoutInflater.findViewById(R.id.summary_coupon_amount_textView);
        this.mSummaryFinalAmountTV = (TextView) layoutInflater.findViewById(R.id.summary_final_amount_textView);
        this.mSummaryPaidViaTV = (TextView) layoutInflater.findViewById(R.id.summary_paid_via_textView);
        this.mSummaryNoItemsTV = (TextView) layoutInflater.findViewById(R.id.summary_no_items_text_view);
        this.mSummaryCancelOrderTV = (TextView) layoutInflater.findViewById(R.id.summary_cancel_order_textView);
        this.mSummaryItemsListRV = (RecyclerView) layoutInflater.findViewById(R.id.summary_items_list_recycler_view);
        this.mSummaryPaidLL = (LinearLayout) layoutInflater.findViewById(R.id.summary_paid_linearLayout);
        this.statusLL = (LinearLayout) layoutInflater.findViewById(R.id.statusLL);
        this.totalQuantity = (TextView) layoutInflater.findViewById(R.id.totalQuantity);
        this.imgPicked = (ImageView) layoutInflater.findViewById(R.id.imgPicked);
        this.imgWashing = (ImageView) layoutInflater.findViewById(R.id.imgWashing);
        this.imgDispatched = (ImageView) layoutInflater.findViewById(R.id.imgDispatched);
        this.imgDelivered = (ImageView) layoutInflater.findViewById(R.id.imgDelivered);
        this.txtPicked = (TextView) layoutInflater.findViewById(R.id.txtPicked);
        this.txtWashing = (TextView) layoutInflater.findViewById(R.id.txtWashing);
        this.txtDispatched = (TextView) layoutInflater.findViewById(R.id.txtDispatched);
        this.txtDelivered = (TextView) layoutInflater.findViewById(R.id.txtDelivered);
        this.pickedRL = (RelativeLayout) layoutInflater.findViewById(R.id.pickedRL);
        this.washingRL = (RelativeLayout) layoutInflater.findViewById(R.id.washingRL);
        this.dispatchedRL = (RelativeLayout) layoutInflater.findViewById(R.id.dispatchedRL);
        this.deliveredRL = (RelativeLayout) layoutInflater.findViewById(R.id.deliveredRL);
        this.createdRL = (RelativeLayout) layoutInflater.findViewById(R.id.createdRL);
        this.mSummaryItemsListRV.setNestedScrollingEnabled(false);
        this.myLinearLayoutManager = new LinearLayoutManager(getActivity());
        this.mSummaryItemsListRV.setLayoutManager(this.myLinearLayoutManager);
        this.mSummaryNoItemsTV.setVisibility(View.GONE);
        Bundle args = getArguments();
        this.orderPosition = args.getInt("ORDER_POSITION");
        this.ordersListModelArrayList = (ArrayList) args.getSerializable("ORDER_LIST");
        try {
            orderSummary();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.mSummaryCancelOrderTV.setOnClickListener(new C07491());
        return layoutInflater;
    }

    private void orderSummary() throws ParseException {
        JSONException e;
        SimpleDateFormat simpleDateFormat;
        Date parse;
        Date parse2;
        ArrayList orderStatusModelArrayList = (ordersListModelArrayList.get(this.orderPosition)).getOrderStatusModelArrayList();
        if (orderStatusModelArrayList.size() > 0) {
            int i;
            ArrayList arrayList = new ArrayList();
            for (i = 0; i < orderStatusModelArrayList.size(); i++) {
                arrayList.add(((OrderStatusModel) orderStatusModelArrayList.get(i)).getOrderStatus());
            }
            if (arrayList.contains("2010")) {
                this.imgDelivered.setBackgroundResource(R.drawable.delivered_dr_greenish_big);
                this.imgPicked.setBackgroundResource(R.drawable.scooter_dr_greenish);
                this.imgWashing.setBackgroundResource(R.drawable.washing_dr_greenish);
                this.imgDelivered.setBackgroundResource(R.drawable.delivered_dr_greenish);
                this.txtPicked.setVisibility(View.GONE);
                this.txtWashing.setVisibility(View.GONE);
                this.txtDispatched.setVisibility(View.GONE);
                this.txtDelivered.setVisibility(View.VISIBLE);
                this.pickedRL.setVisibility(View.VISIBLE);
                this.washingRL.setVisibility(View.VISIBLE);
                this.dispatchedRL.setVisibility(View.VISIBLE);
                this.deliveredRL.setVisibility(View.VISIBLE);
            } else if (arrayList.contains("2009")) {
                this.imgDispatched.setBackgroundResource(R.drawable.deliver_dr_greenish_big);
                this.imgPicked.setBackgroundResource(R.drawable.scooter_dr_greenish);
                this.imgWashing.setBackgroundResource(R.drawable.washing_dr_greenish);
                this.imgDelivered.setBackgroundResource(R.drawable.delivered_dr_blue);
                this.txtPicked.setVisibility(View.GONE);
                this.txtWashing.setVisibility(View.GONE);
                this.txtDispatched.setVisibility(View.VISIBLE);
                this.txtDelivered.setVisibility(View.GONE);
                this.pickedRL.setVisibility(View.VISIBLE);
                this.washingRL.setVisibility(View.VISIBLE);
                this.dispatchedRL.setVisibility(View.VISIBLE);
            } else {
                if (!(arrayList.contains("2004") || arrayList.contains("2005") || arrayList.contains("2006"))) {
                    if (!arrayList.contains("2003")) {
                        if (arrayList.contains("2002")) {
                            this.imgPicked.setBackgroundResource(R.drawable.scooter_dr_greenish_big);
                            this.imgDispatched.setBackgroundResource(R.drawable.deliver_dr_blue);
                            this.imgWashing.setBackgroundResource(R.drawable.washing_dr_blue);
                            this.imgDelivered.setBackgroundResource(R.drawable.delivered_dr_blue);
                            this.txtPicked.setVisibility(View.VISIBLE);
                            this.txtWashing.setVisibility(View.GONE);
                            this.txtDispatched.setVisibility(View.GONE);
                            this.txtDelivered.setVisibility(View.GONE);
                            this.pickedRL.setVisibility(View.VISIBLE);
                        } else if (arrayList.contains("2001")) {
                            this.imgPicked.setBackgroundResource(R.drawable.scooter_dr_blue);
                            this.imgDispatched.setBackgroundResource(R.drawable.deliver_dr_blue);
                            this.imgWashing.setBackgroundResource(R.drawable.washing_dr_blue);
                            this.imgDelivered.setBackgroundResource(R.drawable.delivered_dr_blue);
                            this.pickedRL.setVisibility(View.GONE);
                            this.txtPicked.setVisibility(View.GONE);
                            this.txtWashing.setVisibility(View.GONE);
                            this.txtDispatched.setVisibility(View.GONE);
                            this.txtDelivered.setVisibility(View.GONE);
                            this.txtDelivered.setVisibility(View.GONE);
                        }
                    }
                }
                this.imgWashing.setBackgroundResource(R.drawable.washing_dr_greenish_big);
                this.imgPicked.setBackgroundResource((R.drawable.scooter_dr_greenish));
                this.imgDispatched.setBackgroundResource(R.drawable.deliver_dr_blue);
                this.imgDelivered.setBackgroundResource(R.drawable.delivered_dr_blue);
                this.txtPicked.setVisibility(View.GONE);
                this.txtWashing.setVisibility(View.VISIBLE);
                this.txtDispatched.setVisibility(View.GONE);
                this.txtDelivered.setVisibility(View.GONE);
                this.pickedRL.setVisibility(View.VISIBLE);
                this.washingRL.setVisibility(View.VISIBLE);
            }
            int subTotal = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getSubTotal();
            int extraServiceAmount = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getExtraServiceAmount();
            i = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDiscount();
            int totalPrice = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getTotalPrice();
            int deliveryCharge = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryCharge();
            String couponCode = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getCouponCode();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rs. ");
            stringBuilder.append(subTotal);
            this.mSummaryTotalAmountTV.setText(stringBuilder);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Rs. ");
            stringBuilder2.append(extraServiceAmount);
            this.mSummaryExtraServiceAmountTV.setText(stringBuilder2);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Rs. ");
            stringBuilder2.append(deliveryCharge);
            this.mSummaryDeliveryAmountTV.setText(stringBuilder2);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Coupon Code: ");
            stringBuilder2.append(couponCode);
            this.mSummaryCouponAppliedTV.setText(stringBuilder2);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("- Rs. ");
            stringBuilder2.append(i);
            this.mSummaryCouponAmountTV.setText(stringBuilder2);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Rs. ");
            stringBuilder2.append(totalPrice);
            this.mSummaryFinalAmountTV.setText(stringBuilder2);
            TextView textView = this.totalQuantity;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("[ Total Quantity -");
            stringBuilder3.append(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getTotalQuantity());
            stringBuilder3.append(" ]");
            textView.setText(stringBuilder3.toString());
            String pickupAddress = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getPickupAddress();
            String deliveryAddress = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryAddress();
            String str = "";
            String str2 = "";
            String str3 = "";
            try {
                JSONObject jSONObject = new JSONObject(pickupAddress);
                String strTitle = jSONObject.getString("title");
                try {
                    str = jSONObject.getString("doorNoFlatNo");

                    str = str2;
                    str2 = str3;
                    this.mSummaryPickupAddressTV.setText(stringBuilder2);
                    textView = this.mSummaryPickupDateTV;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(", ");
                    stringBuilder3.append(str2);
                    textView.setText(stringBuilder3.toString());
                    simpleDateFormat = new SimpleDateFormat("dd MMM,yyyy hh:mm aaa", Locale.getDefault());
                    parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((ordersListModelArrayList.get(this.orderPosition)).getPickupDate().replaceAll("Z$", "+0000")));
                    parse2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((ordersListModelArrayList.get(this.orderPosition)).getDeliveryDate().replaceAll("Z$", "+0000")));
                    simpleDateFormat.format(parse);
                    simpleDateFormat.format(parse2);
                    orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList();
                    if (((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList() == null) {
                        this.mSummaryItemsListRV.setVisibility(View.GONE);
                        this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                    } else if (orderStatusModelArrayList.size() > 0) {
                        this.mSummaryItemsListRV.setVisibility(View.GONE);
                        this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                    } else {
                        this.orderSummaryProductsAdapter = new OrderSummaryProductsAdapter(getActivity(), orderStatusModelArrayList);
                        this.mSummaryItemsListRV.setAdapter(this.orderSummaryProductsAdapter);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                try {
                    str2 = jSONObject.getString("street");


                    str2 = str3;
                    this.mSummaryPickupAddressTV.setText(stringBuilder2);
                    textView = this.mSummaryPickupDateTV;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(", ");
                    stringBuilder3.append(str2);
                    textView.setText(stringBuilder3.toString());
                    simpleDateFormat = new SimpleDateFormat("dd MMM,yyyy hh:mm aaa", Locale.getDefault());
                    parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getPickupDate().replaceAll("Z$", "+0000"));
                    parse2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryDate().replaceAll("Z$", "+0000"));
                    simpleDateFormat.format(parse);
                    simpleDateFormat.format(parse2);
                    orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList();
                    if (((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList() == null) {
                        this.mSummaryItemsListRV.setVisibility(View.GONE);
                        this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                    } else if (orderStatusModelArrayList.size() > 0) {
                        this.orderSummaryProductsAdapter = new OrderSummaryProductsAdapter(getActivity(), orderStatusModelArrayList);
                        this.mSummaryItemsListRV.setAdapter(this.orderSummaryProductsAdapter);
                    } else {
                        this.mSummaryItemsListRV.setVisibility(View.GONE);
                        this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(deliveryAddress);
                    jSONObject2.getString("title");
                    jSONObject2.getString("doorNoFlatNo");
                    jSONObject2.getString("street");
                } catch (JSONException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.mSummaryPickupAddressTV.setText(stringBuilder2);
                    textView = this.mSummaryPickupDateTV;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(", ");
                    stringBuilder3.append(str2);
                    textView.setText(stringBuilder3.toString());
                    simpleDateFormat = new SimpleDateFormat("dd MMM,yyyy hh:mm aaa", Locale.getDefault());
                    parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getPickupDate().replaceAll("Z$", "+0000"));
                    parse2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryDate().replaceAll("Z$", "+0000"));
                    simpleDateFormat.format(parse);
                    simpleDateFormat.format(parse2);
                    orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList();
                    if (((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList() == null) {
                        this.mSummaryItemsListRV.setVisibility(View.GONE);
                        this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                    } else if (orderStatusModelArrayList.size() > 0) {
                        this.mSummaryItemsListRV.setVisibility(View.GONE);
                        this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                    } else {
                        this.orderSummaryProductsAdapter = new OrderSummaryProductsAdapter(getActivity(), orderStatusModelArrayList);
                        this.mSummaryItemsListRV.setAdapter(this.orderSummaryProductsAdapter);
                    }
                }
            } catch (JSONException e5) {
               /* e = e5;
                stringBuilder2 = str;
                str = str2;
                str2 = str3;
                e.printStackTrace();*/
                this.mSummaryPickupAddressTV.setText(str);
                textView = this.mSummaryPickupDateTV;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append(", ");
                stringBuilder3.append(str2);
                textView.setText(stringBuilder3.toString());
                simpleDateFormat = new SimpleDateFormat("dd MMM,yyyy hh:mm aaa", Locale.getDefault());
                parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getPickupDate().replaceAll("Z$", "+0000"));
                parse2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryDate().replaceAll("Z$", "+0000"));
                simpleDateFormat.format(parse);
                simpleDateFormat.format(parse2);
                orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList();
                if (((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList() == null) {
                    this.mSummaryItemsListRV.setVisibility(View.GONE);
                    this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                } else if (orderStatusModelArrayList.size() > 0) {
                    this.orderSummaryProductsAdapter = new OrderSummaryProductsAdapter(getActivity(), orderStatusModelArrayList);
                    this.mSummaryItemsListRV.setAdapter(this.orderSummaryProductsAdapter);
                } else {
                    this.mSummaryItemsListRV.setVisibility(View.GONE);
                    this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
                }
            }
            this.mSummaryPickupAddressTV.setText(stringBuilder2);
            textView = this.mSummaryPickupDateTV;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append(", ");
            stringBuilder3.append(str2);
            textView.setText(stringBuilder3.toString());
            simpleDateFormat = new SimpleDateFormat("dd MMM,yyyy hh:mm aaa", Locale.getDefault());
            try {
                parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getPickupDate().replaceAll("Z$", "+0000"));
                parse2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryDate().replaceAll("Z$", "+0000"));
                simpleDateFormat.format(parse);
                simpleDateFormat.format(parse2);
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
            orderStatusModelArrayList = ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList();
            if (((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrdersPayloadModelArrayList() == null) {
                this.mSummaryItemsListRV.setVisibility(View.GONE);
                this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
            } else if (orderStatusModelArrayList.size() > 0) {
                this.orderSummaryProductsAdapter = new OrderSummaryProductsAdapter(getActivity(), orderStatusModelArrayList);
                this.mSummaryItemsListRV.setAdapter(this.orderSummaryProductsAdapter);
            } else {
                this.mSummaryItemsListRV.setVisibility(View.GONE);
                this.mSummaryNoItemsTV.setVisibility(View.VISIBLE);
            }
        }
    }

    private void cancelOrder() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getUserId());
            jSONObject.put("typeofDelivery", ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getDeliveryType());
            jSONObject.put("orderStatus", ((OrdersListModel) this.ordersListModelArrayList.get(this.orderPosition)).getOrderStatus());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
