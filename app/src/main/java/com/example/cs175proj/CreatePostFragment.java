package com.example.cs175proj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CreatePostFragment extends Fragment {

    public CreatePostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EditText title = getView().findViewById(R.id.create_title);
        EditText content = getView().findViewById(R.id.create_content);
        Button submit = getView().findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new User("a", "a", "a"); //TODO: SUPPLY CURRENT USER TO POST
                Post p = new Post(u, content.getText().toString(), title.getText().toString());
                LogActivity la = new LogActivity();
                la.insertPost(p);
            }
        });

        return inflater.inflate(R.layout.fragment_create_post, container, false);
    }
}