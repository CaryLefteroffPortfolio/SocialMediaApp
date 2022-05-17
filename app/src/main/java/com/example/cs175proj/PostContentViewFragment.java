package com.example.cs175proj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PostContentViewFragment extends Fragment {

    private Post post = new Post();

    public PostContentViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(getArguments() != null) {
            int index = getArguments().getInt("PostIndex");
            LogActivity la = new LogActivity();
            post = la.getPostFromIndex(index);
        }
        Button likeButton = getView().findViewById(R.id.like_button);
        Button dislikeButton = getView().findViewById(R.id.dislike_button);
        TextView title = getView().findViewById(R.id.title_text);
        TextView content = getView().findViewById(R.id.Content_Text);
        TextView numLikes = getView().findViewById(R.id.votes);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post.upvote();
                numLikes.setText("Likes: " + String.valueOf(post.getUpvotes()));
            }
        });
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post.downvote();
                numLikes.setText("Likes: " + String.valueOf(post.getUpvotes()));
            }
        });

        title.setText(post.getHeader());
        content.setText(post.getContent());
        numLikes.setText("Likes: " + String.valueOf(post.getUpvotes()));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_content_view, container, false);
    }
}