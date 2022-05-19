package com.example.cs175proj;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

/**
 * Register Page Fragment.
 * Validates inputs and routes to ItemFragment.
 * Stores logged in User in session.
 */
public class RegisterFragment extends Fragment {

    ImageButton registerButton;
    EditText regUser, regEmail, regPass;

    /**
     * Inflates RegisterFragment.
     * RegisterButton onClickListener() is set to route to ItemFragment.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return infalted view
     */
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

                //add new user
                ((LogActivity)getActivity()).addUser(b);

                //update session for logged in user
                ((LogActivity)getActivity()).updateSession(b);

                //move to next fragment
                onClick1();}
            }
        });

        return view;
    }

    /**
     * Invalid length of user input Alert
     */
    private void warnLength() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.field_length);
        builder.setMessage(R.string.field_3);
        builder.create().show();
    }

    /**
     * Username already exists Alert
     */
    private void warnUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.username_exists);
        builder.setMessage(R.string.new_username);
        builder.create().show();
    }

    /**
     * Invalid email Alert
     */
    private void warnEmail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.bad_email);
        builder.setMessage(R.string.new_email);
        builder.create().show();
    }

    /**
     * Routes RegisterFragment to ItemFragment
     */
    public void onClick1(){
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_registerFragment_to_itemFragment);
    }

    /**
     * Checks to see if length of credentials are valid
     * @param s input of credentials
     * @return true if valid length, false if invalid
     */
    public boolean checkLength(String s){
        if(s.length() <3 ){
            return false;
        }
        return true;
    }

    /**
     * Checks to see if userName exists in the database
     * @param s input of userName
     * @return true if valid userName, false if invalid
     */
    public boolean checkUserName(String s){
        for(User u:((LogActivity) getActivity()).getUsers()){
            if(s.equals(u.getUserName())){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks to see if email is of correct format
     * @param s input of email
     * @return true if valid email format, false if invalid
     */
    public boolean checkEmail(String s){
        if(!Patterns.EMAIL_ADDRESS.matcher(s).matches()){
            return false;
        }
        return true;
    }


}