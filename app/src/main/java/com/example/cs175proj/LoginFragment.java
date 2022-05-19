package com.example.cs175proj;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Login Page Fragment.
 * Validates inputs and routes to ItemFragment.
 * Stores logged in User in session.
 */
public class LoginFragment extends Fragment {

    ImageButton loginButton;
    EditText logUser, logPass;

    /**
     * Inflates the LoginFragment.
     * LoginButton onClickListener() is set to route to ItemFragment.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return inflated view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        logUser = view.findViewById(R.id.login_user);
        logPass = view.findViewById(R.id.login_email);

        loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                User b = checkUser();
                if (b == null) {
                    warn();
                } else {
                    ((LogActivity) getActivity()).updateSession(b);
                    int u = ((LogActivity) getActivity()).session.getSession();
                    onClick1();
                }
            }

            /**
             * Checks user inputs to see if User exists
             * @return
             */
            private User checkUser() {
                for (User a : ((LogActivity) getActivity()).getUsers()) {
                    if (a.getUserName().equals(logUser.getText().toString())) {
                        if (a.getPassword().equals(logPass.getText().toString())) {
                            return a;
                        }
                    }
                }
                return null;
            }
        });

        return view;
    }

    /**
     * Invalid credentials Alert
     */
    private void warn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.bad_cred);
        builder.setMessage(R.string.try_again);
        builder.create().show();
    }

    /**
     * Routes LoginFragment to ItemFragment
     */
    public void onClick1(){
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_loginFragment_to_itemFragment);
    }
}
