package com.marolix.laundryapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marolix.laundryapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.RecyclerViewHolders> {

    private List<String> itemList = new ArrayList<>();
    private Context context;

    public HomeRecyclerViewAdapter(Context context, ArrayList<String> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public List<String> getData() {
        return this.itemList;
    }

    public void setData(ArrayList<String> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_home_item, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position));
//        holder.countryPhoto.setUrl(itemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView countryName;
        public ImageView countryPhoto;
        private Context context;
        TextView plus, minus;
        TextView count;
        int sum;
        int single_item_price;

        public RecyclerViewHolders(View itemView, Context context) {
            super(itemView);
            this.context = context;
            itemView.setOnClickListener(this);
            countryName = (TextView) itemView.findViewById(R.id.affliates_name);
            countryPhoto = (ImageView) itemView.findViewById(R.id.affliates_image);

            count = itemView.findViewById(R.id.tv_quantity);
            plus = itemView.findViewById(R.id.item_add);
            minus = itemView.findViewById(R.id.item_sub);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    sum = Integer.parseInt(count.getText().toString());
//                    single_item_price = Integer.parseInt(single_price.getText().toString());

                    sum = sum + 1;
                    Log.e("Quantity value2", "" + sum);
                    if (sum > 0) {
                        count.setVisibility(View.VISIBLE);
                        minus.setVisibility(View.VISIBLE);
//                        price.setVisibility(View.VISIBLE);
                    }
                    count.setText(String.valueOf(sum));

//                    price.setText("\u20B9 " +(single_item_price * sum));
//                    listener.itemClick(view, getAdapterPosition(), sum);
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sum = Integer.parseInt(count.getText().toString());
//                    single_item_price = Integer.parseInt(single_price.getText().toString());

                    if (sum > 0) {
                        sum = sum - 1;
                        if (sum == 0) {
                            count.setVisibility(View.INVISIBLE);
                            minus.setVisibility(View.INVISIBLE);
//                            price.setVisibility(View.GONE);
                        } else {
                            Log.e("Statement","else st");
//                            price.setVisibility(View.VISIBLE);
                        }
                        count.setText(String.valueOf(sum));
//                        price.setText("\u20B9 " +(single_item_price * sum));
//                        listener.itemClick(view, getAdapterPosition(), sum);
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (getAdapterPosition() != RecyclerView.NO_POSITION) {

                String affiliateModel = itemList.get(getAdapterPosition());

//                Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
                /*MenuFragment fragment = new MenuFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(BundleConstants.FROM_AFFILIATES, true);
                bundle.putString(BundleConstants.TITLE, affiliateModel.getName());
                bundle.putString(BundleConstants.AFFLIATE_ID, affiliateModel.getAffiliateId());
                fragment.setArguments(bundle);
                ((CustomerHomeActivity) context).fragmentTransaction(fragment, MenuFragment.class.getSimpleName());*/
            }
        }

    }

}
