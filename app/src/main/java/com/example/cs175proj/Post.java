package com.example.cs175proj;

public class Post {

    private String content;
    private String header;
    private int upvotes;
    private User originalPoster;
    private int index;

    public Post(User originalPoster, String content, String header) {
        this.originalPoster = originalPoster;
        this.content = content;
        upvotes = 0;
        this.header = header;
        originalPoster.addPost(this);
    }

    public Post() {
        content = "NULL CONTENT";
        header = "NULL HEADER";
        upvotes = 0;
        originalPoster = new User("a", "a", "a");
        index = 0;
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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void changeContent(String newContent) {
        content = newContent;
    }

    @Override
    public String toString() {
        return this.header;
    }
}
