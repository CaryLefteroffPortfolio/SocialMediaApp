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


public class LoginFragment extends Fragment {

    ImageButton loginButton;
    EditText logUser, logPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        logUser = view.findViewById(R.id.login_user);
        logPass = view.findViewById(R.id.login_email);

        loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                User b = checkUser();
                if (b == null) {
                    System.out.println("NULL USER");
                    warn();
                } else {
                    ((LogActivity) getActivity()).updateSession(b);
                    System.out.println("Session Saved!");
                    int u = ((LogActivity) getActivity()).session.getSession();
                    System.out.println("User ID: " + u + " is logged in");
                    onClick1();
                }
            }

            private User checkUser() {
                System.out.println("Looking for " + logUser.getText().toString());
                for (User a : ((LogActivity) getActivity()).getUsers()) {
                    if (a.getUserName().equals(logUser.getText().toString())) {
                        System.out.println("FOUND");
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

    private void warn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Incorrect Credentials");
        builder.setMessage("Please try again");
        builder.create().show();
    }

    public void onClick1(){
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_loginFragment_to_itemFragment);
    }
}
