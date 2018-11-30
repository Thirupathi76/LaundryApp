package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.Products.ProductsModel;

import java.util.ArrayList;

public interface GetProductsInterface {
    void onPostGetProducts(boolean bool, ArrayList<ProductsModel> arrayList);
}
