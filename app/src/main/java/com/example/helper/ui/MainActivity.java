package com.example.helper.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.helper.R;

public class MainActivity extends AppCompatActivity {
    public TextView tvTitle;
    public ImageButton rightIcon;
    private Toolbar toolbar;
    public NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.navHostFragmentActivityMain);

        rightIcon = (ImageButton) findViewById(R.id.btnRight);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.authFragment);
            }
        });
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