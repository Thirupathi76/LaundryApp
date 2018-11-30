package com.marolix.laundryapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SthActivity extends Activity  {

    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar animToolbar;
    private LinearLayout pickupAddressLinearLayout;
    private TextView pickupAddressTypeTextView;
    private TextView pickupAddressTextView;
    private LinearLayout cartImageView;
    private FrameLayout blueCircleFrameLayout;
    private TextView countTextView;
    private FrameLayout homeBannerFrameLayout;
    private ViewPager homeBannerPager;
    private LinearLayout homeBannerPagerIndicator;
    private TextView homeCleanTextView;
    private TextView oneDayDelivery;
    private TextView premiumLaundry;
    private TextView dryCleaning;
    private TabLayout tabs;
    private ViewPager productsViewPager;
    private LinearLayout pickupDateLinearLayout;
    private TextView pickupDateTextView;
    private Spinner pickupTimeSpinner;
    private CheckBox deliveryPlaceCheckbox;
    private LinearLayout deliveryAddressLinearLayout;
    private TextView dropAddressTypeTextView;
    private TextView deliveryAddressTextView;
    private LinearLayout dropDateLinearLayout;
    private TextView dropDateTextView;
    private Spinner dropTimeSpinner;
    private LinearLayout selectGarmentsLinearLayout;
    private TextView selectedGarmentsTextView;
    private TextView selectedGarmentsListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_new);

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        animToolbar = findViewById(R.id.anim_toolbar);
        pickupAddressLinearLayout = findViewById(R.id.pickup_address_linearLayout);
        pickupAddressTypeTextView = findViewById(R.id.pickup_address_type_textView);
        pickupAddressTextView = findViewById(R.id.pickup_address_textView);
        cartImageView = findViewById(R.id.cartImageView);
        blueCircleFrameLayout = findViewById(R.id.blueCircleFrameLayout);
        countTextView = findViewById(R.id.countTextView);
        homeBannerFrameLayout = findViewById(R.id.home_banner_frame_layout);
        homeBannerPager = findViewById(R.id.home_banner_pager);
        homeBannerPagerIndicator = findViewById(R.id.home_banner_pager_indicator);
        homeCleanTextView = findViewById(R.id.home_clean_textView);
        oneDayDelivery = findViewById(R.id.oneDayDelivery);
        premiumLaundry = findViewById(R.id.premiumLaundry);
        dryCleaning = findViewById(R.id.dryCleaning);
        tabs = findViewById(R.id.tabs);
        productsViewPager = findViewById(R.id.products_viewPager);
        pickupDateLinearLayout = findViewById(R.id.pickup_date_linearLayout);
        pickupDateTextView = findViewById(R.id.pickup_date_textView);
        pickupTimeSpinner = findViewById(R.id.pickup_time_spinner);
        deliveryPlaceCheckbox = findViewById(R.id.delivery_place_checkbox);
        deliveryAddressLinearLayout = findViewById(R.id.delivery_address_linearLayout);
        dropAddressTypeTextView = findViewById(R.id.drop_address_type_textView);
        deliveryAddressTextView = findViewById(R.id.delivery_address_textView);
        dropDateLinearLayout = findViewById(R.id.drop_date_linearLayout);
        dropDateTextView = findViewById(R.id.drop_date_textView);
        dropTimeSpinner = findViewById(R.id.drop_time_spinner);
        selectGarmentsLinearLayout = findViewById(R.id.select_garments_linear_layout);
        selectedGarmentsTextView = findViewById(R.id.selected_garments_textView);
        selectedGarmentsListTextView = findViewById(R.id.selected_garments_list_textView);
    }

}
