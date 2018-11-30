package com.marolix.laundryapp.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.SthActivity;
import com.marolix.laundryapp.adapter.TabPagerAdapter;
import com.marolix.laundryapp.adapter.ViewPagerAdapter;
import com.marolix.laundryapp.interfaces.GetBannersInterface;
import com.marolix.laundryapp.interfaces.GetCategoryInterface;
import com.marolix.laundryapp.interfaces.GetTimeSlotsInterface;
import com.marolix.laundryapp.interfaces.Products.CategoryItemsAddedInterface;
import com.marolix.laundryapp.models.BannersModel;
import com.marolix.laundryapp.models.Products.CategoryModel;
import com.marolix.laundryapp.models.Products.ProductsAddedModel;
import com.marolix.laundryapp.models.TimeSlotsModel;
import com.marolix.laundryapp.utils.Networking;
import com.marolix.laundryapp.utils.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment implements OnClickListener, GetTimeSlotsInterface, GetBannersInterface, GetCategoryInterface, CategoryItemsAddedInterface {

    private static String dropDate = "";
    private static TextView mDropDateTV = null;
    private static TextView mPickupDateTV = null;
    private static String pickupDate = "";
    private static String selectedDateType = "";
    private String TAG = getClass().getSimpleName();
    private FrameLayout blueCircleFrameLayout;
    private LinearLayout cartImageView;
    private TextView countTextView;
    private String dropAddress = "";
    private String dropAddressId = "";
    private String dropAddressType = "";
    private String dropArea = "";
    private String dropCountry = "";
    private String dropDoorNo = "";
    private String dropLandmark = "";
    private double dropLat = 0.0d;
    private double dropLng = 0.0d;
    private String dropPinCode = "";
    private String dropState = "";
    private String dropStreet = "";
    private ArrayList<TimeSlotsModel> dropTimeSlotArrayList;
    private TextView dryCleaning;

    /*private GetBannersAsyncTask getBannersAsyncTask;
    private GetCategoriesAsyncTask getCategoriesAsyncTask;
    private GetTimeSlotsAsyncTask getTimeSlotsAsyncTask;
    private HomeBannerAdapter homeBannerAdapter;*/

    private ViewPager introPager;
    private LinearLayout sliderDotspanel;

    private LinearLayout mDeliveryAddressLL;
    private TextView mDeliveryAddressTV;
    private CheckBox mDeliveryPlaceCB;
    private TextView mDropAddressTypeTV;
    private LinearLayout mDropDateLL;
    private Spinner mDropTimeSpinner;
    private FrameLayout mHomeBannerFrameLayout;
    private TextView mHomeCleanTV;

    private LinearLayout mPickupAddressLL;
    private TextView mPickupAddressTV;
    private TextView mPickupAddressTypeTV;
    private LinearLayout mPickupDateLL;
    private Spinner mPickupTimeSpinner;
    private LinearLayout mSelectGarmentsLL;
    private TextView mSelectedGarmentsListTV;
    private TextView mSelectedGarmentsTV;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<TimeSlotsModel> pickUpTimeSlotArrayList;
    private String pickupAddress = "";
    private String pickupAddressId = "";
    private String pickupAddressType = "";
    private String pickupArea = "";
    private String pickupCountry = "";
    private String pickupDoorNo = "";
    private String pickupLandmark = "";
    private double pickupLat = 0.0d;
    private double pickupLng = 0.0d;
    private String pickupPinCode = "";
    private String pickupState = "";
    private String pickupStreet = "";
    private boolean premiumFlag = true;
    private TextView premiumLaundry;
    private ArrayList<ProductsAddedModel> productsAddedModelArrayList;
    private HashMap<String, ProductsAddedModel> productsAddedModelHashMap;
    private int productsTotalCount = 0;
    private ProgressDialog progressDialog;
    private ArrayList<TimeSlotsModel> timeSlotsModelArrayList;
    private String userAddress = "";
    private int dotscount;
    private ImageView[] dots;

    class C07412 implements OnItemSelectedListener {
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C07412() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            Singleton.getInstance().setPickTimeSlotId(i);
        }
    }


    class C07423 implements OnItemSelectedListener {
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C07423() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            Singleton.getInstance().setDropTimeSlotId(i);
        }
    }

    class TabSelectedListener implements OnTabSelectedListener {
        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
            /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition());
            TextView tabTextView = (TextView) tabLayout.getChildAt(1);
            tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);*/
        }



        public void onTabSelected(Tab tab) {
            /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition());
            TextView tabTextView = (TextView) tabLayout.getChildAt(1);
            tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);*/
            mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    public class CategoryAdapterNew extends FragmentStatePagerAdapter {
        private ArrayList<CategoryModel> categoryModelArrayList;
        private int mNumOfTabs;

        public CategoryAdapterNew(FragmentManager fragmentManager, int i, ArrayList<CategoryModel> arrayList) {
            super(fragmentManager);
            this.mNumOfTabs = i;
            this.categoryModelArrayList = arrayList;
        }

        public Fragment getItem(int i) {
            return displayFragment(i, this.categoryModelArrayList);
        }

        public int getCount() {
            return this.mNumOfTabs;
        }
    }



    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater view, ViewGroup viewGroup, Bundle bundle) {

       View layoutInflater = view.inflate(R.layout.fragment_home_new, viewGroup, false);

       findViews(layoutInflater);

        pickUpTimeSlotArrayList = new ArrayList();
        dropTimeSlotArrayList = new ArrayList();
        mPickupAddressLL.setOnClickListener(this);
        mDeliveryAddressLL.setOnClickListener(this);
        mPickupDateLL.setOnClickListener(this);
        mDropDateLL.setOnClickListener(this);
        mSelectGarmentsLL.setOnClickListener(this);
        mDeliveryPlaceCB.setOnClickListener(this);
        mHomeCleanTV.setOnClickListener(this);
        cartImageView.setOnClickListener(this);
        premiumLaundry.setOnClickListener(this);
        dryCleaning.setOnClickListener(this);
        mViewPager = layoutInflater.findViewById(R.id.products_viewPager);
        mTabLayout = layoutInflater.findViewById(R.id.tabs);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCanceledOnTouchOutside(false);

        setUpViewPager();

        mViewPager.setOffscreenPageLimit(1);
        mViewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(this.mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());
        mTabLayout.setupWithViewPager(mViewPager);

        /*getCategoryList();
        displayAddress();
        displayDates();
        getBannerImages();
        getTimeSlots();*/

        if (Singleton.getInstance().getShowDropAddressStatus()) {
            mDeliveryAddressLL.setVisibility(View.VISIBLE);
            mDeliveryPlaceCB.setChecked(false);
        } else {
            mDeliveryAddressLL.setVisibility(View.GONE);
            mDeliveryPlaceCB.setChecked(true);
        }
        mPickupTimeSpinner.setOnItemSelectedListener(new C07412());
        mDropTimeSpinner.setOnItemSelectedListener(new C07423());
        productsAddedModelHashMap = Singleton.getInstance().getProductsAddedModelHashMap();
        productsAddedModelArrayList = new ArrayList();
        for (Entry value : this.productsAddedModelHashMap.entrySet()) {
            productsAddedModelArrayList.add((ProductsAddedModel) value.getValue());
        }
        StringBuilder string = new StringBuilder();
        if (productsAddedModelArrayList.size() > 0) {
            for (int i = 0; i < productsAddedModelArrayList.size(); i++) {
                string.append(productsAddedModelArrayList.get(i).getProductName());
                string.append("-");
                string.append(productsAddedModelArrayList.get(i).getProductQuantity());
                string.append(", ");
            }
            string.setLength(string.length() - 1);
            String sth = string.toString().substring(0, string.toString().length() - 1);
            mSelectedGarmentsTV.setText(getString(R.string.text_selected_garments));
            mSelectedGarmentsListTV.setText(sth);
        } else {
            mSelectedGarmentsTV.setText(getString(R.string.text_select_garments));
            mSelectedGarmentsListTV.setText(getString(R.string.text_skip_this));
        }
        return layoutInflater;
    }

    private void findViews(View layoutInflater) {
        mPickupAddressLL = (LinearLayout) layoutInflater.findViewById(R.id.pickup_address_linearLayout);
        mDeliveryAddressLL = (LinearLayout) layoutInflater.findViewById(R.id.delivery_address_linearLayout);
        mPickupDateLL = (LinearLayout) layoutInflater.findViewById(R.id.pickup_date_linearLayout);
        mDropDateLL = (LinearLayout) layoutInflater.findViewById(R.id.drop_date_linearLayout);
        mSelectGarmentsLL = (LinearLayout) layoutInflater.findViewById(R.id.select_garments_linear_layout);
        mHomeBannerFrameLayout = (FrameLayout) layoutInflater.findViewById(R.id.home_banner_frame_layout);
        mHomeCleanTV = (TextView) layoutInflater.findViewById(R.id.home_clean_textView);
        mPickupAddressTypeTV = (TextView) layoutInflater.findViewById(R.id.pickup_address_type_textView);
        mDropAddressTypeTV = (TextView) layoutInflater.findViewById(R.id.drop_address_type_textView);
        mPickupAddressTV = (TextView) layoutInflater.findViewById(R.id.pickup_address_textView);
        mDeliveryAddressTV = (TextView) layoutInflater.findViewById(R.id.delivery_address_textView);
        mPickupDateTV = (TextView) layoutInflater.findViewById(R.id.pickup_date_textView);
        mDropDateTV = (TextView) layoutInflater.findViewById(R.id.drop_date_textView);
        mSelectedGarmentsTV = (TextView) layoutInflater.findViewById(R.id.selected_garments_textView);
        mSelectedGarmentsListTV = (TextView) layoutInflater.findViewById(R.id.selected_garments_list_textView);
        mDeliveryPlaceCB = (CheckBox) layoutInflater.findViewById(R.id.delivery_place_checkbox);
        mPickupTimeSpinner = (Spinner) layoutInflater.findViewById(R.id.pickup_time_spinner);
        mDropTimeSpinner = (Spinner) layoutInflater.findViewById(R.id.drop_time_spinner);

        introPager = layoutInflater.findViewById(R.id.home_banner_pager);
        sliderDotspanel = layoutInflater.findViewById(R.id.home_banner_pager_indicator);

        premiumLaundry = (TextView) layoutInflater.findViewById(R.id.premiumLaundry);
        dryCleaning = (TextView) layoutInflater.findViewById(R.id.dryCleaning);
        countTextView = (TextView) layoutInflater.findViewById(R.id.countTextView);
        blueCircleFrameLayout = (FrameLayout) layoutInflater.findViewById(R.id.blueCircleFrameLayout);
        cartImageView = (LinearLayout) layoutInflater.findViewById(R.id.cartImageView);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());

        introPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

        introPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    if (introPager.getCurrentItem() == 0) {
                        introPager.setCurrentItem(1);
                    } else if (introPager.getCurrentItem() == 1) {
                        introPager.setCurrentItem(2);
                    } else if (introPager.getCurrentItem() == 2) {
                        introPager.setCurrentItem(3);
                    } else {
                        introPager.setCurrentItem(0);
                    }

                }
            });

        }
    }


    private void setUpViewPager() {

        TabPagerAdapter adapter = new TabPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new HouseHold(), "Men");
        adapter.addFrag(new Women(), "Women");
        adapter.addFrag(new Kids(), "Kids");
        adapter.addFrag(new Men(), "HouseHold");
        adapter.addFrag(new Women(), "PremiumLaundry");
        adapter.addFrag(new Accessories(), "Accessories");
        adapter.addFrag(new Women(), "ExclusiveBrands");
        mViewPager.setAdapter(adapter);

        // viewPager.setOffscreenPageLimit(-1);
        adapter.notifyDataSetChanged();

    }

    public class ViewPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> FragmentListTitles = new ArrayList<>();

        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return FragmentListTitles.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return FragmentListTitles.get(position);
        }

        public void AddFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            FragmentListTitles.add(title);
        }
    }

    private void displayAddress() {
        if (Singleton.getInstance().getPreference().getPickupAddress(getActivity()).equals("")) {
            this.userAddress = Singleton.getInstance().getPreference().getAddress(getActivity());
            try {
                JSONArray jSONArray = new JSONArray(this.userAddress);
//                pickupAddressType = jSONArray.getJSONObject(0).getString(SettingsJsonConstants.PROMPT_TITLE_KEY);
                pickupDoorNo = jSONArray.getJSONObject(0).getString("doorNoFlatNo");
                pickupAddress = jSONArray.getJSONObject(0).getString("address");
                pickupStreet = jSONArray.getJSONObject(0).optString("street");
                pickupArea = jSONArray.getJSONObject(0).optString("area");
                pickupState = jSONArray.getJSONObject(0).optString("state");
                pickupCountry = jSONArray.getJSONObject(0).optString("country");
                pickupPinCode = jSONArray.getJSONObject(0).optString("pincode");
                pickupLandmark = jSONArray.getJSONObject(0).getString("landmark");
                pickupAddressId = jSONArray.getJSONObject(0).getString("id");
                pickupLat = jSONArray.getJSONObject(0).getJSONObject("coordinates").getDouble("lat");
                pickupLng = jSONArray.getJSONObject(0).getJSONObject("coordinates").getDouble("lng");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.userAddress = Singleton.getInstance().getPreference().getPickupAddress(getActivity());
            try {
                JSONObject jSONObject = new JSONObject(this.userAddress);
//                pickupAddressType = jSONObject.getString(SettingsJsonConstants.PROMPT_TITLE_KEY);
                pickupDoorNo = jSONObject.getString("doorNoFlatNo");
                pickupStreet = jSONObject.getString("street");
                pickupArea = jSONObject.getString("area");
                pickupState = jSONObject.optString("state");
                pickupCountry = jSONObject.optString("country");
                pickupPinCode = jSONObject.optString("pincode");
                pickupAddress = jSONObject.getString("address");
                pickupLandmark = jSONObject.getString("landmark");
                pickupAddressId = jSONObject.getString("id");
                pickupLat = Double.valueOf(jSONObject.getString("lat")).doubleValue();
                pickupLng = Double.valueOf(jSONObject.getString("lng")).doubleValue();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (Singleton.getInstance().getPreference().getDropAddress(getActivity()).equals("")) {
            dropAddressType = this.pickupAddressType;
            dropDoorNo = this.pickupDoorNo;
            dropAddress = this.pickupAddress;
            dropStreet = this.pickupStreet;
            dropArea = this.pickupArea;
            dropState = this.pickupState;
            dropCountry = this.pickupCountry;
            dropPinCode = this.pickupPinCode;
            dropLandmark = this.pickupLandmark;
            dropAddressId = this.pickupAddressId;
            dropLat = this.pickupLat;
            dropLng = this.pickupLng;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(Singleton.getInstance().getPreference().getDropAddress(getActivity()));
//                dropAddressType = jSONObject2.getString(SettingsJsonConstants.PROMPT_TITLE_KEY);
                dropDoorNo = jSONObject2.getString("doorNoFlatNo");
                dropAddress = jSONObject2.getString("address");
                dropStreet = jSONObject2.getString("street");
                dropArea = jSONObject2.getString("area");
                dropState = jSONObject2.optString("state");
                dropCountry = jSONObject2.optString("country");
                dropPinCode = jSONObject2.optString("pincode");
                dropLandmark = jSONObject2.getString("landmark");
                dropAddressId = jSONObject2.getString("id");
                dropLat = Double.valueOf(jSONObject2.getString("lat")).doubleValue();
                dropLng = Double.valueOf(jSONObject2.getString("lng")).doubleValue();
            } catch (JSONException e22) {
                e22.printStackTrace();
            }
        }
        this.mPickupAddressTypeTV.setText(this.pickupAddressType);
        TextView textView = this.mPickupAddressTV;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.pickupDoorNo);
        stringBuilder.append(", ");
        stringBuilder.append(this.pickupAddress);
        textView.setText(stringBuilder.toString());
        this.mDropAddressTypeTV.setText(this.dropAddressType);
        textView = this.mDeliveryAddressTV;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dropDoorNo);
        stringBuilder.append(", ");
        stringBuilder.append(this.dropAddress);
        textView.setText(stringBuilder.toString());
    }

    private void displayDates() {
        if (Singleton.getInstance().getPickUpDate().equals("")) {
            String format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
            pickupDate = format;
            mPickupDateTV.setText(format);
            Singleton.getInstance().setPickUpDate(format);
        } else {
            mPickupDateTV.setText(Singleton.getInstance().getPickUpDate());
        }
        if (Singleton.getInstance().getDropDate().equals("")) {
            Calendar instance = Calendar.getInstance();
//            instance.add(5, 2);
            String format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(instance.getTime());
            mDropDateTV.setText(format);
            Singleton.getInstance().setDropDate(format);
            return;
        }
        mDropDateTV.setText(Singleton.getInstance().getDropDate());
    }

    private void getBannerImages() {
        if (Networking.isNetworkAvailable(getActivity())) {
            /*this.getBannersAsyncTask = new GetBannersAsyncTask(getActivity());
            this.getBannersAsyncTask.delegate = this;
            AsyncTaskTools.execute(this.getBannersAsyncTask);*/
            return;
        }
        Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    public void onPostGetBanners(boolean bool, ArrayList<BannersModel> arrayList) {
        if (bool) {
            mHomeBannerFrameLayout.setVisibility(View.GONE);
        } else if (arrayList.size() > 0) {
            /*homeBannerAdapter = new HomeBannerAdapter(getActivity(), arrayList);
            introPager.setAdapter(this.homeBannerAdapter);
            introPager.startAutoScroll();
            introPager.setInterval(3000);
            mIndicator.setViewPager(this.introPager);
            mIndicator.setSnap(true);*/
        } else {
            this.mHomeBannerFrameLayout.setVisibility(View.GONE);
        }
    }

    private void getTimeSlots() {
        if (Networking.isNetworkAvailable(getActivity())) {
            /*this.getTimeSlotsAsyncTask = new GetTimeSlotsAsyncTask(getActivity());
            this.getTimeSlotsAsyncTask.delegate = this;
            AsyncTaskTools.execute(this.getTimeSlotsAsyncTask);*/
            return;
        }
        Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    public void onPostGetTimeSlots(boolean bool, ArrayList<TimeSlotsModel> arrayList) {
        if (bool) {
            timeSlotsModelArrayList = arrayList;
            pickUpTimeSlotArrayList = arrayList;
            dropTimeSlotArrayList = arrayList;
            HashMap map = new HashMap();
            HashMap hashMap = new HashMap();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            for (int i = 0; i < this.pickUpTimeSlotArrayList.size(); i++) {
                map.put((pickUpTimeSlotArrayList.get(i)).getSlotId(), ((TimeSlotsModel) this.pickUpTimeSlotArrayList.get(i)).getSlotTime());
                arrayList2.add(pickUpTimeSlotArrayList.get(i).getSlotTime());
            }
            mPickupTimeSpinner.setAdapter(new ArrayAdapter<String>(getActivity(), 17367043, arrayList2) {
                @NonNull
                public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
                    View wid = super.getView(i, view, viewGroup);
                    ((TextView) wid).setTypeface(Typeface.createFromAsset(HomeFragment.this.getActivity().getAssets(), "fonts/AvenirLTStd_Book.otf"));
                    return wid;
                }

                public View getDropDownView(int i, View view, @NonNull ViewGroup viewGroup) {
                   View  vi = super.getDropDownView(i, view, viewGroup);
                    ((TextView) vi).setTypeface(Typeface.createFromAsset(HomeFragment.this.getActivity().getAssets(), "fonts/AvenirLTStd_Book.otf"));
                    return vi;
                }
            });
            for (int i2 = 0; i2 < this.dropTimeSlotArrayList.size(); i2++) {
                hashMap.put(((TimeSlotsModel) this.dropTimeSlotArrayList.get(i2)).getSlotId(), ((TimeSlotsModel) this.dropTimeSlotArrayList.get(i2)).getSlotTime());
                arrayList3.add(((TimeSlotsModel) this.dropTimeSlotArrayList.get(i2)).getSlotTime());
            }
            this.mDropTimeSpinner.setAdapter(new ArrayAdapter<String>(getActivity(), 17367043, arrayList3) {
                @NonNull
                public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
                    View vi = super.getView(i, view, viewGroup);
                    ((TextView) vi).setTypeface(Typeface.createFromAsset(HomeFragment.this.getActivity().getAssets(), "fonts/AvenirLTStd_Book.otf"));
                    return vi;
                }

                public View getDropDownView(int i, View view, @NonNull ViewGroup viewGroup) {
                    View vi = super.getDropDownView(i, view, viewGroup);
                    ((TextView) vi).setTypeface(Typeface.createFromAsset(HomeFragment.this.getActivity().getAssets(), "fonts/AvenirLTStd_Book.otf"));
                    return vi;
                }
            });
            this.mPickupTimeSpinner.setSelection(Singleton.getInstance().getPickTimeSlotId());
            this.mDropTimeSpinner.setSelection(Singleton.getInstance().getDropTimeSlotId());
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cartImageView:
                placeOrder("PLACE_ORDER");
                return;
            case R.id.delivery_address_linearLayout:
                Intent wwIntent = new Intent(getActivity(), SthActivity.class);
                wwIntent.putExtra("ADDRESS_TYPE", "DROP");
                wwIntent.putExtra("TIME_SLOTS", this.timeSlotsModelArrayList);
                startActivityForResult(wwIntent, 3456);
                return;
            case R.id.delivery_place_checkbox:
                if (this.mDeliveryPlaceCB.isChecked()) {
                    this.mDeliveryAddressLL.setVisibility(View.GONE);
                    this.mDeliveryPlaceCB.setChecked(true);
                    Singleton.getInstance().setShowDropAddressStatus(false);
                    return;
                }
                this.mDeliveryAddressLL.setVisibility(View.VISIBLE);
                this.mDeliveryPlaceCB.setChecked(false);
                Singleton.getInstance().setShowDropAddressStatus(true);
                return;
            case R.id.drop_date_linearLayout:
//                new SelectDropDateFragment().show(getFragmentManager(), "DatePicker");
                selectedDateType = "DROP";
                return;
            case R.id.dryCleaning:
                this.premiumFlag = false;
                this.dryCleaning.setTextColor(getResources().getColor(R.color.dark_blue));
                this.dryCleaning.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_white_border_textview));
                this.premiumLaundry.setTextColor(getResources().getColor(R.color.greenish));
                this.premiumLaundry.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_blue_border_textview));
                return;
            case R.id.home_clean_textView:
                placeOrder("PLACE_ORDER");
                return;
            case R.id.pickup_address_linearLayout:
                Intent manageIntent = new Intent(getActivity(), SthActivity.class);
                manageIntent.putExtra("ADDRESS_TYPE", "PICKUP");
                manageIntent.putExtra("TIME_SLOTS", this.timeSlotsModelArrayList);
                manageIntent.putExtra("FROM_SCREEN", "HOME");
                startActivityForResult(manageIntent, 2345);
                return;
            case R.id.pickup_date_linearLayout:
//                new SelectPickupDateFragment().show(getFragmentManager(), "DatePicker");
                selectedDateType = "PICKUP";
                return;
            case R.id.premiumLaundry:
                premiumFlag = true;
                premiumLaundry.setTextColor(getResources().getColor(R.color.dark_blue));
                premiumLaundry.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_white_border_textview));
                dryCleaning.setTextColor(getResources().getColor(R.color.greenish));
                dryCleaning.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_blue_border_textview));
                return;
            case R.id.select_garments_linear_layout:
                placeOrder("SELECT_CLOTHES");
                return;
            default:
                return;
        }
    }

    private void placeOrder(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
//            jSONObject2.put(SettingsJsonConstants.PROMPT_TITLE_KEY, this.pickupAddressType);
            jSONObject2.put("doorNoFlatNo", this.pickupDoorNo);
            jSONObject2.put("address", this.pickupAddress);
            jSONObject2.put("street", this.pickupStreet);
            jSONObject2.put("area", this.pickupArea);
            jSONObject2.put("state", this.pickupState);
            jSONObject2.put("country", this.pickupCountry);
            jSONObject2.put("pincode", this.pickupPinCode);
            jSONObject2.put("landmark", this.pickupLandmark);
            jSONObject2.put("id", this.pickupAddressId);
            jSONObject = new JSONObject();
            jSONObject.put("lat", this.pickupLat);
            jSONObject.put("lng", this.pickupLng);
            jSONObject2.put("coordinates", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jSONObject = new JSONObject();
        try {
//            jSONObject.put(SettingsJsonConstants.PROMPT_TITLE_KEY, this.dropAddressType);
            jSONObject.put("doorNoFlatNo", this.dropDoorNo);
            jSONObject.put("address", this.dropAddress);
            jSONObject.put("street", this.dropStreet);
            jSONObject.put("area", this.dropArea);
            jSONObject.put("state", this.dropState);
            jSONObject.put("country", this.dropCountry);
            jSONObject.put("pincode", this.dropPinCode);
            jSONObject.put("landmark", this.dropLandmark);
            jSONObject.put("id", this.dropAddressId);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("lat", this.dropLat);
            jSONObject3.put("lng", this.dropLng);
            jSONObject.put("coordinates", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        int selectedItemPosition = this.mPickupTimeSpinner.getSelectedItemPosition();
        int selectedItemPosition2 = this.mDropTimeSpinner.getSelectedItemPosition();
        if (str.equals("PLACE_ORDER")) {
            Intent conIntent = new Intent(getActivity(), SthActivity.class);
            conIntent.putExtra("PICKUP_ADDRESS", jSONObject2.toString());
            if (this.mDeliveryPlaceCB.isChecked()) {
                conIntent.putExtra("DROP_ADDRESS", jSONObject2.toString());
            } else {
                conIntent.putExtra("DROP_ADDRESS", jSONObject.toString());
            }
            conIntent.putExtra("PICKUP_DATE", mPickupDateTV.getText().toString());
            conIntent.putExtra("DROP_DATE", mDropDateTV.getText().toString());
            startActivity(conIntent);
        } else if (str.equals("SELECT_CLOTHES") ) {
            Intent selIntent = new Intent(getActivity(), SthActivity.class);
            selIntent.putExtra("PICKUP_ADDRESS", jSONObject2.toString());
            if (this.mDeliveryPlaceCB.isChecked()) {
                selIntent.putExtra("DROP_ADDRESS", jSONObject2.toString());
            } else {
                selIntent.putExtra("DROP_ADDRESS", jSONObject.toString());
            }
            selIntent.putExtra("PICKUP_DATE", mPickupDateTV.getText().toString());
            selIntent.putExtra("DROP_DATE", mDropDateTV.getText().toString());
            selIntent.putExtra("PICKUP_TIMESLOT_ID", ((TimeSlotsModel) this.timeSlotsModelArrayList.get(selectedItemPosition)).getSlotId());
            selIntent.putExtra("DROP_TIMESLOT_ID", ((TimeSlotsModel) this.timeSlotsModelArrayList.get(selectedItemPosition2)).getSlotId());
            startActivityForResult(selIntent, 4567);
        }
    }

    public void onResume() {
        super.onResume();
        displayProductsCartDetails();
        getCategoryList();
    }

    public void onDestroy() {
        super.onDestroy();

        throw new UnsupportedOperationException("Method not decompiled: com.laundrykart.fragments.HomeFragment.onDestroy():void");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            displayAddress();
            displayDates();
            if (i == 2345) {
                mPickupTimeSpinner.setSelection(Singleton.getInstance().getPickTimeSlotId());
            } else if (i == 3456) {
                mDropTimeSpinner.setSelection(Singleton.getInstance().getDropTimeSlotId());
            } else if (i == 4567) {
                productsAddedModelHashMap = Singleton.getInstance().getProductsAddedModelHashMap();
                productsAddedModelArrayList = new ArrayList();
                for (Entry value : productsAddedModelHashMap.entrySet()) {
                    productsAddedModelArrayList.add((ProductsAddedModel) value.getValue());
                }
               StringBuilder sb = new StringBuilder();
                if (this.productsAddedModelArrayList.size() > 0) {
                    for (int val = 0; val < this.productsAddedModelArrayList.size(); val++) {
                        sb.append(productsAddedModelArrayList.get(val).getProductName());
                        sb.append("-");
                        sb.append(productsAddedModelArrayList.get(val).getProductQuantity());
                        sb.append(", ");
                    }
                    sb.setLength(sb.length() - 1);
                   String sth = sb.toString().substring(0, sb.toString().length() - 1);
                    mSelectedGarmentsTV.setText(getString(R.string.text_selected_garments));
                    mSelectedGarmentsListTV.setText(sth);
                    return;
                }
                mSelectedGarmentsTV.setText(getString(R.string.text_select_garments));
                mSelectedGarmentsListTV.setText(getString(R.string.text_skip_this));
            }
        }
    }

    private void getCategoryList() {
        /*if (Networking.isNetworkAvailable(getActivity())) {
            this.progressDialog.setMessage("Loading Categories...");
            this.progressDialog.show();
            this.getCategoriesAsyncTask = new GetCategoriesAsyncTask(getActivity());
            this.getCategoriesAsyncTask.delegate = this;
            AsyncTaskTools.execute(this.getCategoriesAsyncTask);
            return;
        }*/
        Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    public void onPostGetCategory(boolean bool, ArrayList<CategoryModel> arrayList) {
        this.progressDialog.dismiss();
        if (bool) {
            this.mTabLayout.removeAllTabs();
            for (int val = 0; val < arrayList.size(); val++) {
                this.mTabLayout.addTab(this.mTabLayout.newTab().setText((arrayList.get(val)).getCategoryName()));
            }
            if (getActivity() != null) {
                this.mViewPager.setAdapter(new CategoryAdapterNew(getActivity().getSupportFragmentManager(), this.mTabLayout.getTabCount(), arrayList));
            }
            displayProductsCartDetails();
        }
    }

    public void onCategoryItemsAdded() {
        displayProductsCartDetails();
    }

    private void displayProductsCartDetails() {
        Log.e("Products Cart", String.valueOf(Singleton.getInstance().getProductsAddedModelHashMap().size()));
        int i = 0;
        for (Entry value : Singleton.getInstance().getProductsAddedModelHashMap().entrySet()) {
            i += ((ProductsAddedModel) value.getValue()).getProductQuantity();
        }
        productsTotalCount = i;
        updateAlertIcon(productsTotalCount);
        Log.e("Products Total", String.valueOf(this.productsTotalCount));
    }

    private Fragment displayFragment(int i, ArrayList<CategoryModel> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString("CATEGORY_ID", (arrayList.get(i)).getCategoryId());
        Fragment frag = new ProductsFragment();
        frag.setArguments(bundle);
        return frag;
    }

    public void updateAlertIcon(int i) {
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onUpdateCartIcon: ");
        stringBuilder.append(i);
        Log.e(str, stringBuilder.toString());
        if (i > 0) {
            countTextView.setText(String.valueOf(i));
        } else {
            countTextView.setText("");
        }
        blueCircleFrameLayout.setVisibility(i > 0 ? View.VISIBLE : View.GONE);
    }
}
