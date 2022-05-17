package com.example.cs175proj;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    //used to store current logged in user

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public Session(Context cntx) {
        prefs = cntx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveSession(User user){
        //get user id
        int s = user.getId();

        //save user id in session
        editor = prefs.edit();
        editor.putInt(SESSION_KEY, s);
        editor.apply();
        System.out.println("SESSION KEY: " + SESSION_KEY);
    }

    public int getSession(){
        //return user id of session
        //return -1 if no current user
        return prefs.getInt(SESSION_KEY, -1);
    }
}
