package com.marolix.laundryapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.adapter.HomeRecyclerViewAdapter;

import java.util.ArrayList;

public class HouseHold extends Fragment {
    private String[] names = {"Hyderabad", "Amaravati", "Mumbai", "Chennai", "Karimnagar", "Amaravati",
            "Mumbai", "Chennai", "Karimnagar", "Amaravati", "Mumbai", "Chennai", "Karimnagar"};

    HomeRecyclerViewAdapter rcAdapter;

    public HouseHold() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kids, container, false);
        // Inflate the layout for this fragment
        RecyclerView gridView = view.findViewById(R.id.recyclerView);
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 2);


        gridView.setHasFixedSize(true);
        gridView.setLayoutManager(lLayout);

        rcAdapter = new HomeRecyclerViewAdapter(getActivity(), getAllItemList());
        gridView.setAdapter(rcAdapter);
        return view;
    }

    private ArrayList<String> getAllItemList() {

        /*if (response != null) {*/

        ArrayList<String> modelData = new ArrayList<>();
        for (String arr : names) {
            String model = arr;

            modelData.add(model);
        }
            /*return new ArrayList<>(response.getData());
        } else
            return new ArrayList<String>();*/

        return modelData;
    }
}
