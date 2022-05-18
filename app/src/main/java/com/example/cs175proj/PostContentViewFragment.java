package com.example.cs175proj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.TextView;

import org.w3c.dom.Text;

public class PostContentViewFragment extends Fragment {

    private Post post = new Post();

    public PostContentViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post_content_view, container, false);
        LogActivity la = (LogActivity)(getActivity());
        if(getArguments() != null) {
            int index = getArguments().getInt("PostIndex");
            post = la.getPostFromIndex(index);
        }
        Button likeButton = view.findViewById(R.id.like_button);
        Button dislikeButton = view.findViewById(R.id.dislike_button);
        TextView title = view.findViewById(R.id.title_text);
        TextView content = view.findViewById(R.id.Content_Text);
        TextView numLikes = view.findViewById(R.id.votes);
        TextView postedBy = view.findViewById(R.id.posted_by);

        User curr = la.getUser(la.session.getSession());

        postedBy.setText("Posted by: " + curr.getUserName());

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.hasLiked(post)) {
                    post.unupvote();
                    curr.removeLikedPost(post);
                    } else {
                    post.upvote();
                    curr.addLikedPost(post);
                }
                numLikes.setText("Likes: " + post.getUpvotes() +
                        " Dislikes: " + post.getDownvotes() );
            }
        });
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.hasDisliked(post)) {
                post.undownvote();
                curr.removeDislikedPost(post);
                } else {
                post.downvote();
                curr.addDislikedPost(post);
                }
                numLikes.setText("Likes: " + post.getUpvotes() +
                        " Dislikes: " + post.getDownvotes() );
            }
        });

        title.setText(post.getHeader());
        content.setText(post.getContent());
        numLikes.setText("Likes: " + post.getUpvotes() +
                " Dislikes: " + post.getDownvotes() );
        return view;
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.postmenu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.backToBoard){
//            NavController nav = NavHostFragment.findNavController(this);
//            nav.navigate(R.id.action_postContentViewFragment_to_itemFragment);
//        }
//        return super.onOptionsItemSelected(item);
//    }

}