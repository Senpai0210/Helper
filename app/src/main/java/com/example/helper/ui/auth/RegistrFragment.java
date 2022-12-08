package com.example.helper.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helper.databinding.FragmentRegistrBinding;
import com.example.helper.ui.MainActivity;

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
        setHasOptionsMenu(true);

        nLoginHelper = binding.login;
        nPasswordHelper = binding.password;
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
                    ((MainActivity) requireActivity()).onSupportNavigateUp();
                } else
                    Toast.makeText((getActivity()),  "Вы не подтвердили пароль!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item = menu.getItem(0);
        item.setVisible(false);
        ((MainActivity) requireActivity()).tvTitle.setText("Регистрация");
        super.onCreateOptionsMenu(menu, inflater);
    }

}