package com.example.cs175proj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Post> posts = new ArrayList<>();
    User currentUser;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new Session(LogActivity.this);
        //Create Users
        users.add(new User("jim@jim.com", "jim", "jim"));
        users.add(new User("cat@cat.com", "cat", "cat"));
        users.add(new User("jill@jim.com", "jill", "jill"));
        User jim = getUser(0);
        User cat = getUser(1);
        User jill = getUser(2);
        insertPost(new Post(jim,"Went to the Beach", "The Beach was so fun"));
        insertPost(new Post(cat,"Went to the Beach", "The Beach was so fun"));
        insertPost(new Post(jill,"Went to the Beach", "The Beach was so fun"));
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.fragmentContainerView, new MainFragment());
//        fragmentTransaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        Session session = new Session(LogActivity.this);
        int getSession = session.getSession();
        if(getSession != -1){
            //logged in

        }else{

        }
    }

    public void updateSession(User u){
        System.out.println("HERE: " + u.toString());
        //session = new Session(LogActivity.this);
        session.saveSession(u);
    }

    @Override
    public void onBackPressed() {

    }

    public void addUser(User u){
        users.add(u);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public static ArrayList<Post> getAllPosts() {
        return posts;
    }

    public static Post getPostFromIndex(int index) {
        return posts.get(index);
    }

    public static void insertPost(Post p) {
        p.setIndex(posts.size());
        posts.add(p);
    }

    public User getUser(int id){
        for(User a:users){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }
}