package com.example.helper.ui.auth;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helper.R;
import com.example.helper.databinding.FragmentRegistrBinding;
import com.example.helper.ui.home.HomeFragment;
import com.example.helper.viewmodels.RegistrViewModel;

public class RegistrFragment extends Fragment {
    private FragmentRegistrBinding binding;
    public EditText nLoginHelper;
    public EditText nPasswordHelper;
    public EditText nPasswordPotverHelper;
    public Button nRegistrationHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        nLoginHelper = binding.login;
        nPasswordHelper =binding.password;
        nPasswordPotverHelper = binding.passwordRepeat;

        nRegistrationHelper = binding.registration;
        nRegistrationHelper.setEnabled(false);

        EditText[] edList = {nLoginHelper, nPasswordHelper,nPasswordPotverHelper};
        AuthFragment.CustomTextWatcher textWatcher = new AuthFragment.CustomTextWatcher(edList, nRegistrationHelper);
        for (EditText editText : edList) editText.addTextChangedListener(textWatcher);

        nRegistrationHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nPasswordHelper.getText().toString().equals(nPasswordPotverHelper.getText().toString())) {
                    Navigation.findNavController(view).navigate(R.id.authFragment);
                } else
                    Toast.makeText((getActivity()),  "Вы не подтвердили пароль!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}