package com.example.cs175proj;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Front page Fragment
 */
public class MainFragment extends Fragment {

    /**
     * Inflates the Main Fragment.
     * LoginButton onClickListener() is set to route to LoginFragment.
     * RegisterButton onClickListener() is set to route to RegisterFragment.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return inflated view
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button loginButton = (Button)view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1();
            }
        });


        Button registerButton = (Button)view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick2();
            }
        });

        return view;
    }

    /**
     * Routes LoginButton to LoginFragment
     */
    public void onClick1(){
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_mainFragment_to_loginFragment);
    }

    /**
     * Routes RegisterButton to RegisterFragment
     */
    public void onClick2(){
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_mainFragment_to_registerFragment);
    }

}