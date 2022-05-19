package com.example.cs175proj;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Session that stores current logged-in user
 */
public class Session {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    /**
     * Session constructor
     * @param cntx context of current SHARED_PREF_NAME
     */
    public Session(Context cntx) {
        prefs = cntx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Saves user ID in session
     * @param user the user the id is taken from
     */
    public void saveSession(User user){
        //get user id
        int s = user.getId();

        //save user id in session
        editor = prefs.edit();
        editor.putInt(SESSION_KEY, s);
        editor.apply();
    }

    /**
     * Gets current logged-in User ID .
     * Returns -1 if there is not a logged-in User.
     * @return id of logged-in User
     */
    public int getSession(){
        return prefs.getInt(SESSION_KEY, -1);
    }
}
