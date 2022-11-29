package com.example.helper.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helper.databinding.ActivityMainBinding;
import com.example.helper.databinding.FragmentHomeBinding;
import com.example.helper.ui.MainActivity;
import com.example.helper.R;
import com.example.helper.viewmodels.HomeViewModel;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel mViewModel;
    private NavController navController;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding =FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.authFragment);
            }
        });
//        ((MainActivity) getActivity()).setTitle("Главная");
//        ((MainActivity) getActivity()).setRightIcon(R.drawable.ic_add);
//        ((MainActivity) getActivity()).rightIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navController.findDestination(R.id.action_homeFragment_to_authFragment);
//            }
//        });
        return view;
    }

}