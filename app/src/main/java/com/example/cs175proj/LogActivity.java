package com.example.cs175proj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LogActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Post> posts = new ArrayList<>();

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
        insertPost(new Post(cat,"Went to the Hills", "The Hills were so fun"));
        insertPost(new Post(jill,"Went to the Lake", "The Lake was so fun"));

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
//        p.setIndex(posts.size());
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

    public void floatBtnClicked(View v){
        System.out.println("HERE");
        List<Fragment> b = getSupportFragmentManager().getFragments();
        for(Fragment frag : b){
            System.out.println(frag);
            if(frag instanceof NavHostFragment){
                System.out.println("FOUND");
                NavController nav = NavHostFragment.findNavController(frag);
                nav.navigate(R.id.action_itemFragment_to_createPostFragment);
            }
        }
    }

}