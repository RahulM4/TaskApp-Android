package com.rahul.task.Controller;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.rahul.task.Model.Exceptions.BadAuthorizationException;
import com.rahul.task.Model.Exceptions.EmptyFieldException;
import com.rahul.task.Model.Repository;
import com.rahul.task.R;
import com.rahul.task.Util.UiUtil;
import com.rahul.task.Var.Constants;
import com.rahul.task.Var.Global;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public static final int DELAY_MILLIS = 1000;
    private LinearLayout mainLayout;
    private MaterialButton loginBtn, registerBtn;
    private TextInputEditText usernameEditText, passwordEditText;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Repository.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findItems(view);

        setEvents();

    }

    private void setEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                try {

                    if (username.equals(Constants.EMPTY_STRING) || password.equals(Constants.EMPTY_STRING))
                        throw new EmptyFieldException();

                    if (Repository.getInstance().checkAuthorization(username, password)) {

                        UiUtil.showSnackbar(mainLayout, getResources().getString(R.string.login_successfully), getResources().getString(R.color.task_app_green_dark));
                        Global.setOnlineUsername(username);
                        Global.setOnlineUserID(Repository.getInstance().getUserByUsername(username).getId());
                        Constants.TIME_HANDLER.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(TaskActivity.newIntent(getActivity()));
                            }
                        }, DELAY_MILLIS);

                    }

                } catch (EmptyFieldException e) {
                    UiUtil.showSnackbar(mainLayout, e.getMessage(), getResources().getString(R.color.task_app_red));
                } catch (BadAuthorizationException e) {
                    UiUtil.showSnackbar(mainLayout, e.getMessage(), getResources().getString(R.color.task_app_red));
                }

            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RegisterActivity.newIntent(getActivity()));
            }
        });
    }

    private void findItems(@NonNull View view) {
        mainLayout = view.findViewById(R.id.loginFragment_mainLayout);
        usernameEditText = view.findViewById(R.id.loginFragment_username);
        passwordEditText = view.findViewById(R.id.loginFragment_password);
        loginBtn = view.findViewById(R.id.loginFragment_loginBtn);
        registerBtn = view.findViewById(R.id.loginFragment_registerBtn);
    }


}
