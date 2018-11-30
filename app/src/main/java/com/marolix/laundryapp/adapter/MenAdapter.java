package com.marolix.laundryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marolix.laundryapp.R;

public class MenAdapter extends RecyclerView.Adapter<MenAdapter.ViewHolderClass> {
    Context context;
    int[] images;
    String[] aa;

    public MenAdapter(Context context, int[] images, String[] aa) {
        this.images = images;
        this.aa = aa;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.menlayout, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolder, int i) {
        viewHolder.txt1.setText(aa[i]);
        viewHolder.imageView.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return aa.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView txt1;
        ImageView imageView;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt);
            imageView = itemView.findViewById(R.id.img);
            //itemView=imageView.findViewById(R.id.img);
        }

    }
}