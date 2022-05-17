package com.example.cs175proj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;


public class RegisterFragment extends Fragment {

    ImageButton registerButton;
    EditText regUser, regEmail, regPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        buttonRegister = view.findViewById(R.id.registerButton);
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        regUser = view.findViewById(R.id.register_user);
        regEmail = view.findViewById(R.id.register_email);
        regPass = view.findViewById(R.id.register_password);

        registerButton = view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                User b = new User(regEmail.getText().toString(),
                        regUser.getText().toString(),
                        regPass.getText().toString());
                System.out.println("**********************");
                System.out.println("User Created: " + b.toString());

                //add new user
                ((LogActivity)getActivity()).addUser(b);
                System.out.println("User added!");

                //update session for logged in user
                ((LogActivity)getActivity()).updateSession(b);
                System.out.println("Session Saved!");

                //move to next fragment
                ItemFragment next = new ItemFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, next, "find").addToBackStack(null).commit();
            }
        });

        return view;
    }
}