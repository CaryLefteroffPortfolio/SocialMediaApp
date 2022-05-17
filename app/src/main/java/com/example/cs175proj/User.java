package com.example.cs175proj;

import java.util.ArrayList;

public class User {

    private static int USER_ID = 0;

    private int netUpvotes;
    private int id;
    private String email;
    private String userName;
    private String password;
    private ArrayList<Post> posts;

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        posts = new ArrayList<>();
        netUpvotes = 0;
        this.id = USER_ID++;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void upvote() {
        netUpvotes++;
    }

    public void downvote() {
        netUpvotes--;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "UserName: " + this.userName + " ID: " + this.id;
    }
}