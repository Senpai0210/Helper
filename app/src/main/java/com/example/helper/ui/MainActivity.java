package com.example.helper.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.helper.R;
import com.example.helper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public TextView tvTitle;
    public ImageView rightIcon;
    public Toolbar toolbar;
    private Button button;
    public NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        navController = Navigation.findNavController(this, R.id.navHostFragmentActivityMain);
//
//        rightIcon = (ImageView) findViewById(R.id.btnRight);
//        rightIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.authFragment);
//            }
//        });
    }

    private void setSupportActionBar(Toolbar toolbar) {

    }
    public void setTitle(String title){
        tvTitle.setText(title);
    }
    public void setRightIcon(int icon){
        rightIcon.setImageResource(icon);
    }
}