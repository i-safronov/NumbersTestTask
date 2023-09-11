package com.sfr.numberstesttask.presentation.screen.activity.main_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.sfr.numberstesttask.R;
import com.sfr.numberstesttask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String className = MainActivity.this.getClass().getName();
    private String TAG = "sfrLog";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        try {
            setupAllContentGraph();
        } catch (Exception e) {
            Log.e(TAG, className + " , " + e.getMessage());
        }
    }

    private void setupAllContentGraph() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.all_content_container);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController);
    }

}