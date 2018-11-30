package com.marolix.laundryapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.marolix.laundryapp.fragment.AccountFragment;
import com.marolix.laundryapp.fragment.HomeFragment;
import com.marolix.laundryapp.fragment.OrdersFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigation = findViewById(R.id.bottom_navigation);
        mBottomNavigation.inflateMenu(R.menu.menu_home_bottom_nav);
        fragmentManager = getSupportFragmentManager();
        Bundle bundle = getIntent().getExtras();
        String str = (bundle != null) ? bundle.getString("FRAGMENT_NAME") : null;
        if (str == null || str.equals("HOME")) {
            showOrdersFragment();
        } else {
            showHomeFragment();
        }

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menu) {
               int menuItem = menu.getItemId();
                if (menuItem == R.id.action_account) {
                    fragment = new AccountFragment();
                } else if (menuItem == R.id.action_home) {
                    fragment = new HomeFragment();
                } else if (menuItem == R.id.action_orders) {
                    fragment = new OrdersFragment();
                }
                fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }

    private void showHomeFragment() {
        fragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.main_container, this.fragment).commit();
    }

    private void showOrdersFragment() {
        fragment = new OrdersFragment();
        fragmentManager.beginTransaction().replace(R.id.main_container, this.fragment).commit();
        mBottomNavigation.setSelectedItemId(R.id.action_orders);
    }
    
}
