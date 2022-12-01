package com.example.helper.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.helper.databinding.FragmentHomeBinding;
import com.example.helper.ui.RecyclerAdapter;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private RecyclerAdapter recyclerAdapter;
    private String[] list = {"Видео Карта", "Процессор", "Блок Питания"};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.recycler.setHasFixedSize(true);

        recyclerAdapter = new RecyclerAdapter(list);
        binding.recycler.setAdapter(recyclerAdapter);
        return view;
    }
}