package com.example.helper.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.helper.R;

public class MainActivity extends AppCompatActivity {
    public TextView tvTitle;
    public ImageView rightIcon;
    public NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //navController = Navigation.findNavController(this, R.id.navHostFragmentActivityMain);
    }
    public void showToolbar(){

    }
    public void setTitle(String title){
        tvTitle.setText(title);
    }
    public void setRightIcon(int icon){
        rightIcon.setImageResource(icon);
    }
}