package com.example.helper.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.helper.R;
import com.example.helper.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    public TextView tvTitle;
    public ImageView rightIcon;
    private Toolbar toolbar;
//    public NavController navController = Navigation.findNavController(MainActivity.this, R.id.navHostFragmentActivityMain);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rightIcon = (ImageView) findViewById(R.id.btnRight);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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