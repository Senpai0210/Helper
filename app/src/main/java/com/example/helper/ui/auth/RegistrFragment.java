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
import com.example.helper.ui.home.HomeFragment;
import com.example.helper.viewmodels.RegistrViewModel;

public class RegistrFragment extends Fragment {

    private RegistrViewModel mViewModel;

    public static RegistrFragment newInstance() {
        return new RegistrFragment();
    }

    public EditText nLoginHelper;
    public EditText nPasswordHelper;
    public EditText nPasswordPotverHelper;
    public Button nRegistrationHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registr, container, false);

        nLoginHelper = (EditText) view.findViewById(R.id.login_helper_2);
        nPasswordHelper = (EditText) view.findViewById(R.id.password_helper_2);
        nPasswordPotverHelper = (EditText) view.findViewById(R.id.password_potverd_helper_2);

        nRegistrationHelper = (Button) view.findViewById(R.id.registration_helper_2);
        nRegistrationHelper.setEnabled(false);

        EditText[] edList = {nLoginHelper, nPasswordHelper,nPasswordPotverHelper};
        AuthFragment.CustomTextWatcher textWatcher = new AuthFragment.CustomTextWatcher(edList, nRegistrationHelper);
        for (EditText editText : edList) editText.addTextChangedListener(textWatcher);

        nRegistrationHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nPasswordHelper.getText().toString().equals(nPasswordPotverHelper.getText().toString())) {
                    Navigation.findNavController(view).navigate(R.id.action_registrFragment_to_authFragment);
                } else {
                    Toast.makeText(getActivity(), "Вы не подтвердили пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}