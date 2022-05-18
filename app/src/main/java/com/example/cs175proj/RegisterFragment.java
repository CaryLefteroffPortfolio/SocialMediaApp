package com.example.cs175proj;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.util.Patterns;
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
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        regUser = view.findViewById(R.id.register_user);
        regEmail = view.findViewById(R.id.register_email);
        regPass = view.findViewById(R.id.register_password);

        registerButton = view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if((!checkLength(regUser.getText().toString())) ||
                        !checkLength(regPass.getText().toString()) ||
                        !checkLength(regEmail.getText().toString())){
                    warnLength();
                }else if(!checkUserName(regUser.getText().toString())){
                    warnUser();
                }else if(!checkEmail(regEmail.getText().toString())){
                    warnEmail();
                }else {
                User b = new User(regEmail.getText().toString(),
                        regUser.getText().toString(),
                        regPass.getText().toString());
                System.out.println("User Created: " + b.toString());

                //add new user
                ((LogActivity)getActivity()).addUser(b);
                System.out.println("User added!");

                //update session for logged in user
                ((LogActivity)getActivity()).updateSession(b);
                System.out.println("Session Saved!");

                //move to next fragment
                onClick1();}
            }
        });

        return view;
    }

    private void warnLength() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Field Length");
        builder.setMessage("Fields must be at least 3 characters");
        builder.create().show();
    }

    private void warnUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Username Exists");
        builder.setMessage("Please enter another username");
        builder.create().show();
    }

    private void warnEmail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Invalid email");
        builder.setMessage("Please enter a valid email address");
        builder.create().show();
    }

    public void onClick1(){
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_registerFragment_to_itemFragment);
    }

    public boolean checkLength(String s){
        if(s.length() <3 ){
            return false;
        }
        return true;
    }

    public boolean checkUserName(String s){
        for(User u:((LogActivity) getActivity()).getUsers()){
            if(s.equals(u.getUserName())){
                return false;
            }
        }
        return true;
    }

    public boolean checkEmail(String s){
        if(!Patterns.EMAIL_ADDRESS.matcher(s).matches()){
            return false;
        }
        return true;
    }


}