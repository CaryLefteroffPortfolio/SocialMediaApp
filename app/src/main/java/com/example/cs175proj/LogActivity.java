package com.example.cs175proj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainerView, new MainFragment());
        fragmentTransaction.commit();
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
        super.onBackPressed();
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

}