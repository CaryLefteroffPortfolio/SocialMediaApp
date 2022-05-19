package com.example.cs175proj;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Post class holds data for each post
 */
public class Post {

    private static int POST_ID = 0;

    private String content;
    private String header;
    private int upvotes;
    private int downvotes;
    private User originalPoster;
    private int id;

    /**
     * Post constructor
     * @param originalPoster the user who created the post
     * @param content the content of the post
     * @param header the header/title of the post
     */
    public Post(User originalPoster, String content, String header) {
        this.originalPoster = originalPoster;
        this.content = content;
        upvotes = 0;
        downvotes = 0;
        this.header = header;
        originalPoster.addPost(this);
        id = POST_ID++;
    }

    /**
     * Post constructor with no parameters, only sets the id to 0
     */
    public Post() {
        id = 0;
    }

    /**
     * Gets the post header, a String
     * @return the post header
     */
    public String getHeader() { return header; }

    /**
     * Gets the post content, a String
     * @return the post content
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns the number of upvotes/likes for the post
     * @return the number of likes
     */
    public int getUpvotes() {
        return upvotes;
    }

    /**
     * Returns the number of downvotes/dislikes for the post
     * @return the number of dislikes
     */
    public int getDownvotes() { return downvotes; }

    /**
     * Increments the upvotes/likes, and calls upvote on the original poster
     */
    public void upvote() {
        upvotes++;
    }

    /**
     * Increments the downvotes/dislikes, and calls downvote on the original poster
     */
    public void downvote() {
        downvotes++;
    }

    /**
     * Removes an upvote/like by deincrementing the upvotes/likes, and calling downvote on the original poster
     */
    public void unupvote() {
        upvotes--;
    }

    /**
     * Removes a downvote/dislike by deincrementing the downvotes/dislikes, and calling upvote on the original poster
     */
    public void undownvote() {
        downvotes--;
    }

    /**
     * Sets the index of the post, which is the position on the ArrayList in LogActivity
     * @param index the post's index
     */
    public void setIndex(int index) {
        this.id = index;
    }

    /**
     * Gets the id of the post, an int
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Converts the post into a readable String by returning the title/header of the post
     * @return the title/header of the post
     */
    @Override
    public String toString() {
        return this.header;
    }

    /**
     * Gets the original poster of the post, a User
     * @return the original poster
     */
    public User getOriginalPoster() {
        return originalPoster;
    }

}
