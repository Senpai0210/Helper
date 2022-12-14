package com.example.helper.ui.auth;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helper.R;
import com.example.helper.viewmodels.AuthViewModel;

public class AuthFragment extends Fragment {
    private Button mEnterHelper;
    private Button mRegistrationHelper;
    private EditText mLoginHelper;
    private EditText mPasswordHelper;
    private String LoginHelper, PasswordHelper;

    private AuthViewModel mViewModel;

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        mLoginHelper = (EditText) view.findViewById(R.id.login_helper);
        mPasswordHelper = (EditText) view.findViewById(R.id.password_helper);

        mEnterHelper = (Button) view.findViewById(R.id.enter_helper);
        mEnterHelper.setEnabled(false);

        EditText[] edList = {mLoginHelper, mPasswordHelper};
        CustomTextWatcher textWatcher = new CustomTextWatcher(edList, mEnterHelper);
        for (EditText editText : edList) editText.addTextChangedListener(textWatcher);

        mEnterHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Ура вы вошли", Toast.LENGTH_SHORT).show();
            }
        });

        mRegistrationHelper = (Button) view.findViewById(R.id.registration_helper);
        mRegistrationHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_authFragment_to_registrFragment);
            }
        });

        return view;
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