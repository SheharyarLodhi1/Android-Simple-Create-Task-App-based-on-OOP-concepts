package com.next.sheharyar.dailytaskapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sheharyar on 2/1/2019.
 */

public class SharedPreference {

    public static final String PREF_NAME = "TASKS_APP";
    public static final String PREF_FAV = "TASKS_FAVORITES";

    public SharedPreference(){
        super();
    }

    // These four methods are used for adding saving and removing preferences

    public void saveFavorites(Context context, ArrayList<Tasks> favorite){
        SharedPreferences sharedPreferences;
        Editor editor;

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String jsonFav = gson.toJson(favorite);
        editor.putString(PREF_FAV, jsonFav);
        editor.commit();
    }

    public void addFavorite(Context context, Tasks tasks){
        ArrayList<Tasks> favorites = getFavorites(context);
        if (favorites != null){
            favorites.remove(tasks);
            saveFavorites(context,favorites);
        }


    }

    public ArrayList<Tasks> getFavorites(Context context){
        SharedPreferences sharedPreferences;
        List<Tasks> favorites;

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(PREF_FAV)){
            String jsonFav = sharedPreferences.getString(PREF_FAV, null);
            Gson gson = new Gson();
            Tasks[] favoriteTasks = gson.fromJson(jsonFav, Tasks[].class);

            favorites = Arrays.asList(favoriteTasks);
            favorites = new ArrayList<Tasks>(favorites);
        } else
            return null;
        return (ArrayList<Tasks>) favorites;
    }
}
