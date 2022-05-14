package com.example.cs175proj;

        import java.util.ArrayList;
        import java.util.HashMap;

public class User {

    private int netUpvotes;
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
//        setLoginInfo(userName, password);
    }

//    public HashMap<String, String> getLoginInfo() {
//        return loginInfo;
//    }
//
//    public void setLoginInfo(String username, String password) {
//        loginInfo.put(username, password);
//    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void upvote() {
        netUpvotes++;
    }

    public void downvote() {
        netUpvotes--;
    }
}