package com.example.helper.ui.auth;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.helper.R;
import com.example.helper.databinding.FragmentAuthBinding;
import com.example.helper.ui.MainActivity;

public class AuthFragment extends Fragment {
    private FragmentAuthBinding binding;
    private Button mEnterHelper;
    private EditText mLoginHelper;
    private EditText mPasswordHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setHasOptionsMenu(true);

        mLoginHelper = binding.login;
        mPasswordHelper = binding.password;

        mEnterHelper = binding.enter;
        mEnterHelper.setEnabled(false);

        EditText[] edList = {mLoginHelper, mPasswordHelper};
        CustomTextWatcher textWatcher = new CustomTextWatcher(edList, mEnterHelper);
        for (EditText editText : edList) editText.addTextChangedListener(textWatcher);

        mEnterHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) requireActivity()).onSupportNavigateUp();
            }
        });

        binding.registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.registrFragment);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        MenuItem item = menu.getItem(0);
        item.setVisible(false);
        ((MainActivity) requireActivity()).tvTitle.setText("Вход");
        super.onCreateOptionsMenu(menu, inflater);
    }

    public static class CustomTextWatcher implements TextWatcher {

        View v;
        EditText[] edList;

        public CustomTextWatcher(EditText[] edList, Button v) {
            this.v = v;
            this.edList = edList;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            for (EditText editText : edList) {
                if (editText.getText().toString().trim().length() == 0) {
                    v.setEnabled(false);
                    break;
                }
                else v.setEnabled(true);
            }
        }
    }
}