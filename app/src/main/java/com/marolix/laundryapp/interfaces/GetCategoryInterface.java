package com.marolix.laundryapp.interfaces;

import com.marolix.laundryapp.models.Products.CategoryModel;

import java.util.ArrayList;

public interface GetCategoryInterface {
    void onPostGetCategory(boolean bool, ArrayList<CategoryModel> arrayList);
}
