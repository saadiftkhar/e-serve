package com.codesses.e_serve.customer.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.codesses.e_serve.R;
import com.codesses.e_serve.activity.RoutingActivity;
import com.codesses.e_serve.databinding.ActivityCustomerMainBinding;
import com.codesses.e_serve.utils.Constants;
import com.codesses.e_serve.utils.SharedPrefManager;

public class CustomerMainActivity extends AppCompatActivity {

    //     Context
    AppCompatActivity mContext;

    //    View binding
    private ActivityCustomerMainBinding binding;

    //    Nav bar
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        binding = DataBindingUtil.setContentView(mContext, R.layout.activity_customer_main);

        // Check if navigation is running, open RoutingActivity
        if (isNavRunning()) {
            startActivity(new Intent(mContext, RoutingActivity.class));
            finish();
        }


        // Get the navigation host fragment from this Activity
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.customer_host_fragment);

        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.customerBottomMenu, navController);


    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }


    private boolean isNavRunning() {

        SharedPrefManager prefManager = SharedPrefManager.getInstance(mContext);
        return prefManager.getBooleanData(Constants.IS_NAVIGATION_RUNNING);

    }

}