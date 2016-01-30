package com.example.shreyvalia.evently;

import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by shreyvalia on 1/30/16.
 */
public class fireBase {
    private static Firebase ourInstance = null;

    public static Firebase getInstance(Context context) {
        if(ourInstance == null){
            new fireBase(context);
        }

        return ourInstance;
    }

    private fireBase(Context context) {
        Firebase.setAndroidContext(context);
        //firebase ref
        ourInstance = new Firebase("https://eventlyforthehack.firebaseio.com/");
    }
}
