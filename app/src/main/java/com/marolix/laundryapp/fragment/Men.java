package com.marolix.laundryapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.adapter.MenAdapter;

public class Men extends Fragment {
    RecyclerView recyclerView;
    int [] images={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    String[] aa={"dcdc","dcdc"};
    ArrayAdapter<String> arrayAdapter;

    public Men() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.men, container, false);
        recyclerView= view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       // MenAdapter menAdapter=new MenAdapter(getActivity(),images,aa);
        MenAdapter menAdapter=new MenAdapter(getActivity(),images,aa);
        recyclerView.setAdapter(menAdapter);
        return view;
    }
}
