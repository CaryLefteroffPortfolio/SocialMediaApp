package com.example.cs175proj;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class CreatePostFragment extends Fragment {

    public CreatePostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_post, container, false);
        // Inflate the layout for this fragment
        EditText title = view.findViewById(R.id.create_title);
        EditText content = view.findViewById(R.id.create_content);
        Button submit = view.findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogActivity la = (LogActivity) getActivity();
                int uID = la.session.getSession();
                User u = new User("null", "null", "null");
                User temp = la.getUser(uID);
                if(temp != null) {
                u = temp;
                }
                Post p = new Post(u, content.getText().toString(), title.getText().toString());
                la.insertPost(p);
                goBackToList();
            }
        });

        return view;
    }

    public void goBackToList() {
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_createPostFragment_to_itemFragment);
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.createpostmenu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.backToBoard){
//            goBackToList();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}