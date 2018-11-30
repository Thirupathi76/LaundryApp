package com.marolix.laundryapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.interfaces.Products.ProductsAddedInterface;
import com.marolix.laundryapp.models.Products.ProductsAddedModel;
import com.marolix.laundryapp.models.Products.ProductsModel;
import com.marolix.laundryapp.utils.Singleton;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {
    private Context context;
    public ProductsAddedInterface delegate;
    private HashMap<String, ProductsAddedModel> productsAddedModelHashMap;
    private ArrayList<ProductsModel> productsModelArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView product_count_minus;
        public ImageView product_count_plus;
        public ImageView product_image_imageView;
        public TextView product_name_textView;
        public TextView product_price_textView;
        public TextView product_quantity_textView;
        public LinearLayout product_row_LinearLayout;

        public MyViewHolder(View view) {
            super(view);
            product_name_textView = (TextView) view.findViewById(R.id.product_name_textView);
            product_price_textView = (TextView) view.findViewById(R.id.product_price_textView);
            product_quantity_textView = (TextView) view.findViewById(R.id.product_quantity_textView);
            product_image_imageView = (ImageView) view.findViewById(R.id.product_image_imageView);
            product_count_minus = (ImageView) view.findViewById(R.id.product_count_minus);
            product_count_plus = (ImageView) view.findViewById(R.id.product_count_plus);
            product_row_LinearLayout = (LinearLayout) view.findViewById(R.id.product_row_LinearLayout);
        }
    }

    public ProductsAdapter(Context context, ArrayList<ProductsModel> arrayList) {
        context = context;
        productsModelArrayList = arrayList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_category_products, viewGroup, false));
    }

    public void onBindViewHolder(final MyViewHolder viewHolder, final int i) {
        final ProductsAddedModel productsAddedModel = new ProductsAddedModel();
        System.out.println("onBindViewHolder");
        productsAddedModelHashMap = Singleton.getInstance().getProductsAddedModelHashMap();
        if (i < productsModelArrayList.size()) {

            System.out.println("productsModelArrayList.size()- "+productsModelArrayList.size());
            viewHolder.product_name_textView.setText((productsModelArrayList.get(i)).getProductName());
            TextView textView = viewHolder.product_price_textView;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rs. ");
            stringBuilder.append(String.valueOf((productsModelArrayList.get(i)).getProductPrice()));
            textView.setText(stringBuilder.toString());
            viewHolder.product_quantity_textView.setText("0");
            /*Picasso picasso = Picasso.get();
            stringBuilder = new StringBuilder();
            stringBuilder.append(Urls.mainUrl);
            stringBuilder.append((productsModelArrayList.get(i)).getProductImage());
            picasso.load(stringBuilder.toString()).error((int) R.drawable.product_place_holder).into(viewHolder.product_image_imageView);
            */
            if (productsAddedModelHashMap.size() > 0) {
                for (String str : productsAddedModelHashMap.keySet()) {
                    if (str.equals((productsModelArrayList.get(i)).getProductId())) {
                        viewHolder.product_quantity_textView.setText(String.valueOf((productsAddedModelHashMap.get(str)).getProductQuantity()));
                    }
                }
            }
            viewHolder.product_count_plus.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    viewHolder.product_quantity_textView.setText(String.valueOf(Integer.parseInt(viewHolder.product_quantity_textView.getText().toString()) + 1));
                    productsAddedModel.setProductName(( productsModelArrayList.get(i)).getProductName());
                    productsAddedModel.setProductId(( productsModelArrayList.get(i)).getProductId());
                    productsAddedModel.setProductPrice(( productsModelArrayList.get(i)).getProductPrice());
                    productsAddedModel.setProductQuantity(Integer.parseInt(viewHolder.product_quantity_textView.getText().toString()));
                    productsAddedModel.setProductImage(( productsModelArrayList.get(i)).getProductImage());
                    if ((productsModelArrayList.get(i)).getStainStatus().equals("true")) {
                        productsAddedModel.setStainStatus(true);
                    } else {
                        productsAddedModel.setStainStatus(false);
                    }
                    if ((productsModelArrayList.get(i)).getStarchStatus().equals("true")) {
                        productsAddedModel.setStarchStatus(true);
                    } else {
                        productsAddedModel.setStarchStatus(false);
                    }
                    Singleton.getInstance().productsAddedModelHashMap.put( productsModelArrayList.get(i).getProductId(), productsAddedModel);
                    delegate.onProductsAdded();
                }
            });
            viewHolder.product_count_minus.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int count = Integer.parseInt(viewHolder.product_quantity_textView.getText().toString());
                    if (view == null) {
                        viewHolder.product_quantity_textView.setText("0");
                        return;
                    }
                    count -= 1;
                    if (view == null) {
                        viewHolder.product_quantity_textView.setText(String.valueOf(count));
                        Singleton.getInstance().productsAddedModelHashMap.remove((productsModelArrayList.get(i)).getProductId());
                        delegate.onProductsAdded();
                        return;
                    }
                    viewHolder.product_quantity_textView.setText(String.valueOf(view));
                    productsAddedModel.setProductName((productsModelArrayList.get(i)).getProductName());
                    productsAddedModel.setProductId((productsModelArrayList.get(i)).getProductId());
                    productsAddedModel.setProductPrice((productsModelArrayList.get(i)).getProductPrice());
                    productsAddedModel.setProductQuantity(Integer.parseInt(viewHolder.product_quantity_textView.getText().toString()));
                    productsAddedModel.setProductImage((productsModelArrayList.get(i)).getProductImage());
                    if ((productsModelArrayList.get(i)).getStainStatus().equals("true")) {
                        productsAddedModel.setStainStatus(true);
                    } else {
                        productsAddedModel.setStainStatus(false);
                    }
                    if ((productsModelArrayList.get(i)).getStarchStatus().equals("true")) {
                        productsAddedModel.setStarchStatus(true);
                    } else {
                        productsAddedModel.setStarchStatus(false);
                    }
                    Singleton.getInstance().productsAddedModelHashMap.put((productsModelArrayList.get(i)).getProductId(), productsAddedModel);
                    delegate.onProductsAdded();
                }
            });
        }
    }

    public int getItemCount() {
        return productsModelArrayList.size();
    }
}
