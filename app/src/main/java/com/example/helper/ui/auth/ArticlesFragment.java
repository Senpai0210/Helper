package com.example.helper.ui.auth;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helper.R;
import com.example.helper.databinding.FragmentArticlesBinding;
import com.example.helper.databinding.FragmentAuthBinding;
import com.example.helper.viewmodels.ArticlesViewModel;

public class ArticlesFragment extends Fragment {
    private FragmentArticlesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentArticlesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
}