package com.example.cs175proj;

import androidx.appcompat.app.AppCompatActivity;

public class Post {

    private static int POST_ID = 0;

    private String content;
    private String header;
    private int upvotes;
    private int downvotes;
    private User originalPoster;
    private int id;

    public Post(User originalPoster, String content, String header) {
        this.originalPoster = originalPoster;
        this.content = content;
        upvotes = 0;
        downvotes = 0;
        this.header = header;
        originalPoster.addPost(this);
        id = POST_ID++;
    }

    public Post() {
        id = 0;
    }

    public String getHeader() { return header; }

    public String getContent() {
        return content;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() { return downvotes; }

    public void upvote() {
        upvotes++;
        originalPoster.upvote();
    }

    public void downvote() {
        downvotes++;
        originalPoster.downvote();
    }

    public void unupvote() {
        upvotes--;
        originalPoster.downvote();
    }

    public void undownvote() {
        downvotes--;
        originalPoster.upvote();
    }

    public void setIndex(int index) {
        this.id = index;
    }

    public int getId() {
        return id;
    }

    public void changeContent(String newContent) {
        content = newContent;
    }

    @Override
    public String toString() {
        return this.header;
    }

}
