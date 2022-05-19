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

    //
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
        users.add(new User("billgates@gmail.com", "Bill Gates", "microsoft"));
        User jim = getUser(0);
        User cat = getUser(1);
        User jill = getUser(2);
        User bill = getUser(3);
        insertPost(new Post(jim,"Went to the Beach", "The Beach was so fun"));
        insertPost(new Post(jill, "I sent over 100 job applications out to various companies, and after months of applying and interviewing, I finally got my dream job!", "I GOT A JOB!!!"));
        insertPost(new Post(cat,"Went to the Hills", "The Hills were so fun"));
        insertPost(new Post(jim, "The Memphis Grizzlies have been eliminated from the NBA playoffs", "GG MEMPHIS"));
        insertPost(new Post(jim, "My android app has this nasty nav bug and I have tried to fix it but haven't been able to. If you know a lot about navs, please email me at jim@jim.com to help me with this" +
                " annoying bug, it is driving me insane.", "Nasty Android Nav Bug. HELP???!!!"));
        insertPost(new Post(jill,"Went to the Lake", "The Lake was so fun"));
        insertPost(new Post(jim, "Today I went to my local golf course. I hit my first ever hole in one. It was an amazing experience!", "I hit a HOLE IN ONE in GOLF!"));
        insertPost(new Post(bill, "I am proud to announce that Microsoft will be releasing a new XBOX, a new version of Windows, and a new mobile phone all on the same day! The sky is the limit here at Microsoft.", "" +
                "BREAKING: Microsoft announcing 3 new products"));
        insertPost(new Post(cat, "I like potatoes, like if you agree, dislike if you don't", "Do you like potatoes???"));
        insertPost(new Post(bill, "Microsoft is for sale to the highest bidder. Bidding starts at 100 trillion dollars.", "BREAKING: Microsoft put up for sale by owner Bill Gates"));
        insertPost(new Post(jim, "Can I have an A on my final project for CS175? PLEEEEASE?", "Can I have an A on my final project for CS175?"));

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
        List<Fragment> b = getSupportFragmentManager().getFragments();
        for(Fragment frag : b){
            System.out.println(frag);
            if(frag instanceof NavHostFragment){
                NavController nav = NavHostFragment.findNavController(frag);
                nav.navigate(R.id.action_itemFragment_to_createPostFragment);
            }
        }
    }

    public void backBtnClickedPostContent(View v){
        List<Fragment> b = getSupportFragmentManager().getFragments();
        for(Fragment frag : b){
            System.out.println(frag);
            if(frag instanceof NavHostFragment){
                NavController nav = NavHostFragment.findNavController(frag);
                nav.navigate(R.id.action_postContentViewFragment_to_itemFragment);
            }
        }
    }

    public void backBtnClickedCreatePost(View v){
        List<Fragment> b = getSupportFragmentManager().getFragments();
        for(Fragment frag : b){
            System.out.println(frag);
            if(frag instanceof NavHostFragment){
                NavController nav = NavHostFragment.findNavController(frag);
                nav.navigate(R.id.action_createPostFragment_to_itemFragment);
            }
        }
    }

    public void backBtnLogin(View v){
        List<Fragment> b = getSupportFragmentManager().getFragments();
        for(Fragment frag : b){
            System.out.println(frag);
            if(frag instanceof NavHostFragment){
                NavController nav = NavHostFragment.findNavController(frag);
                nav.navigate(R.id.action_loginFragment_to_mainFragment);
            }
        }
    }

    public void backBtnRegister(View v){
        List<Fragment> b = getSupportFragmentManager().getFragments();
        for(Fragment frag : b){
            System.out.println(frag);
            if(frag instanceof NavHostFragment){
                NavController nav = NavHostFragment.findNavController(frag);
                nav.navigate(R.id.action_registerFragment_to_mainFragment);
            }
        }
    }

}