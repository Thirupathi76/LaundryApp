package com.marolix.laundryapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.adapter.ProductsAdapter;
import com.marolix.laundryapp.interfaces.GetProductsInterface;
import com.marolix.laundryapp.interfaces.Products.CategoryItemsAddedInterface;
import com.marolix.laundryapp.interfaces.Products.ProductsAddedInterface;
import com.marolix.laundryapp.models.Products.ProductsModel;
import com.marolix.laundryapp.utils.Networking;

import java.util.ArrayList;

public class ProductsFragment extends Fragment implements GetProductsInterface, ProductsAddedInterface {
    private String categoryId;
    public CategoryItemsAddedInterface categoryItemsAddedInterface;
//    private GetProductsAsyncTask getProductsAsyncTask;
    private RecyclerView mProductsListRV;
    private LinearLayoutManager myLinearLayoutManager;
    private ProductsAdapter productsAdapter;
    private int productsTotalCount = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View layoutInflater = inflater.inflate(R.layout.fragment_products, viewGroup, false);
        this.mProductsListRV = (RecyclerView) layoutInflater.findViewById(R.id.products_list_recycler_view);
        if (getArguments() != null) {
            this.categoryId = getArguments().getString("CATEGORY_ID");
        }
        this.myLinearLayoutManager = new LinearLayoutManager(getActivity());
        this.mProductsListRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        getProductsList(this.categoryId);
        return layoutInflater;
    }

    private void getProductsList(String str) {
        if (Networking.isNetworkAvailable(getActivity())) {
            /*this.getProductsAsyncTask = new GetProductsAsyncTask(getActivity());
            this.getProductsAsyncTask.delegate = this;
            AsyncTaskTools.execute(this.getProductsAsyncTask, str);*/
            return;
        }
        Toast.makeText(getActivity(), "No Internet Connection", 0).show();
    }


    public void onPostGetProducts(boolean bool, ArrayList<ProductsModel> arrayList) {
        if (bool ) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPostGetProducts");
            stringBuilder.append(arrayList.size());
            System.out.println(stringBuilder.toString());
            productsAdapter = new ProductsAdapter(getActivity(), arrayList);
            productsAdapter.delegate = this;
            mProductsListRV.setAdapter(productsAdapter);
        }
    }



    public void onProductsAdded() {
        categoryItemsAddedInterface.onCategoryItemsAdded();
    }


}
