package com.example.helper.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.helper.R;
import com.example.helper.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    public NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navController = Navigation.findNavController(this, R.id.navHostFragmentActivityMain);

        BottomNavigationView navView = findViewById(R.id.BottomNavigation);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.registrFragment, R.id.homeFragment, R.id.authFragment).build();
        NavigationUI.setupWithNavController(binding.BottomNavigation, navController);
    }
}