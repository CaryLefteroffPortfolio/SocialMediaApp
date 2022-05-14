package com.example.cs175proj;

public class Post {

    private String content;
    private String header;
    private int upvotes;
    private User originalPoster;

    public Post(User originalPoster, String content, String header) {
        this.originalPoster = originalPoster;
        this.content = content;
        upvotes = 0;
        this.header = header;
        originalPoster.addPost(this);
    }

    public String getHeader() { return header; }

    public String getContent() {
        return content;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void upvote() {
        upvotes++;
        originalPoster.upvote();
    }

    public void downvote() {
        upvotes--;
        originalPoster.downvote();
    }

    public void changeContent(String newContent) {
        content = newContent;
    }

    @Override
    public String toString() {
        return this.header;
    }
}
