package com.example.cs175proj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//NOTE: USED EXERCISE 3 INSTRUCTION TO SET UP LIST
public class ListOfPostsFragment extends Fragment {

    public ListOfPostsFragment() {
        // Required empty public constructor
    }

    public static ListOfPostsFragment newInstance(String param1, String param2) {
        ListOfPostsFragment fragment = new ListOfPostsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_posts, container, false);
    }
}