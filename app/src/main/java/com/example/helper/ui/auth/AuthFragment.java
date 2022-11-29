package com.example.helper.ui.auth;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
        mLoginHelper = (EditText) container.findViewById(R.id.login_helper);
        mPasswordHelper = (EditText) container.findViewById(R.id.password_helper);

        mEnterHelper = (Button) container.findViewById(R.id.enter_helper);
        mEnterHelper.setEnabled(false);

        EditText[] edList = {mLoginHelper, mPasswordHelper};
        CustomTextWatcher textWatcher = new CustomTextWatcher(edList, mEnterHelper);
        for (EditText editText : edList) editText.addTextChangedListener(textWatcher);

        mEnterHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        mRegistrationHelper = (Button) container.findViewById(R.id.registration_helper);
        mRegistrationHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Helper.this, Helper_Registration.class);
//                startActivity(intent);
            }
        });

        return inflater.inflate(R.layout.fragment_auth, container, false);
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