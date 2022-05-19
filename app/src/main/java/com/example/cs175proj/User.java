package com.example.cs175proj;

import java.util.ArrayList;

/**
 * User class holds data for each user
 */
public class User {

    private static int USER_ID = 0;

    private int id;
    private String email;
    private String userName;
    private String password;
    private ArrayList<Post> liked;
    private ArrayList<Post> disliked;
    private ArrayList<Post> posts;

    /**
     * Constructor allows creation of users
     * @param email the user's email
     * @param userName the user's username
     * @param password the user's password
     */
    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        posts = new ArrayList<>();
        liked = new ArrayList<>();
        disliked = new ArrayList<>();
        this.id = USER_ID++;
    }

    /**
     * Checks if the user had liked a specific post
     * @param a specific post being checked
     * @return true if the post has been liked by the user, false otherwise
     */
    public boolean hasLiked(Post a) {
        for(Post p : liked) {
            if(a.getId() == p.getId()) {
                return true;
            }
        }
        return false;
        }

    /**
     * Checks if the user had disliked a specific post
     * @param a specific post being checked
     * @return true if the post has been disliked by the user, false otherwise
     */
     public boolean hasDisliked(Post a) {
         for(Post p : disliked) {
             if(a.getId() == p.getId()) {
                return true;
             }
         }
         return false;
     }

    /**
     * Adds a post to the list of posts liked by the user
      * @param p the post to be added
     */
    public void addLikedPost(Post p) {
        liked.add(p);
    }

    /**
     * Removes a post from the list of liked posts by the user
     * @param p the post to be removed
     */
    public void removeLikedPost(Post p) {
        liked.remove(p);
    }

    /**
     * Adds a post to the list of posts disliked by the user
     * @param p the post to be added
     */
    public void addDislikedPost(Post p) {
        disliked.add(p);
    }

    /**
     * Removes a post from the list of disliked posts by the user
     * @param p the post to be removed
     */
    public void removeDislikedPost(Post p) {
        disliked.remove(p);
    }

    /**
     * Adds a post to the User's posts
     * @param post the post to be added
     */
    public void addPost(Post post) {
        posts.add(post);
    }


    /**
     * Gets the user's username
     * @return the user's username, a String
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Gets the user's password
     * @return the user's password, a String
     */
    public String getPassword() {
        return password;
    }


    /**
     * Gets the user's id
     * @return the user's id, an int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's id to a new id
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Converts the user to a readable String and returns it
     * @return a String representing the user
     */
    @Override
    public String toString(){
        return "UserName: " + this.userName + " ID: " + this.id;
    }
}