package com.marolix.laundryapp.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.marolix.laundryapp.R;
import com.marolix.laundryapp.adapter.OrderListAdapter;
import com.marolix.laundryapp.interfaces.GetOrdersInterface;
import com.marolix.laundryapp.models.Orders.OrdersListModel;
import com.marolix.laundryapp.utils.Networking;
import com.marolix.laundryapp.utils.Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdersFragment extends Fragment implements GetOrdersInterface {
//    private GetOrdersAsyncTask getOrdersAsyncTask;
    private RecyclerView mOrdersListRV;
    private LinearLayoutManager myLinearLayoutManager;
    private OrderListAdapter orderListAdapter;
    private ProgressDialog progressDialog;
    private String userId = "";

    class C07501 implements Comparator<OrdersListModel> {
        C07501() {
        }

        public int compare(OrdersListModel ordersListModel, OrdersListModel ordersListModel2) {
            return ordersListModel2.getOrderId().compareToIgnoreCase(ordersListModel.getOrderId());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View layoutInflater = inflater.inflate(R.layout.fragment_orders, viewGroup, false);
        this.mOrdersListRV = (RecyclerView) layoutInflater.findViewById(R.id.orders_list_recycler_view);
        this.progressDialog = new ProgressDialog(getActivity());
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.myLinearLayoutManager = new LinearLayoutManager(getActivity());
        this.mOrdersListRV.setLayoutManager(this.myLinearLayoutManager);
        this.userId = Singleton.getInstance().getPreference().getUserId(getActivity());
        return layoutInflater;
    }

    private void getOrderDetails() {
        if (Networking.isNetworkAvailable(getActivity())) {
            this.progressDialog.setMessage("Getting orders");
            this.progressDialog.show();
            /*this.getOrdersAsyncTask = new GetOrdersAsyncTask(getActivity());
            this.getOrdersAsyncTask.delegate = this;
            AsyncTaskTools.execute(this.getOrdersAsyncTask, this.userId);*/
            return;
        }
        Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    public void onPostGetOrders(Boolean bool, ArrayList<OrdersListModel> arrayList) {
        this.progressDialog.dismiss();
        if (bool.booleanValue()&& arrayList.size() > 0) {
            Collections.sort(arrayList, new C07501());
            this.orderListAdapter = new OrderListAdapter(getActivity(), arrayList);
            this.mOrdersListRV.setAdapter(orderListAdapter);
        }
    }

    public void onResume() {
        super.onResume();
        getOrderDetails();
    }

    public void onDestroy() {
        super.onDestroy();
        }
}
