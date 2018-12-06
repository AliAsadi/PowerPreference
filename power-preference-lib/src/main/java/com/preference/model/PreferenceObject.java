package com.preference.model;

import android.content.SharedPreferences;

import java.util.List;

/**
 * Created by Ali Esa Assadi on 19/11/2018.
 */
public class PreferenceObject {
    public SharedPreferences sharedPreferences;
    public String name;
    public List<PreferenceItem> items;

    public PreferenceObject(SharedPreferences sharedPreferences, String name, List<PreferenceItem> items) {
        this.sharedPreferences = sharedPreferences;
        this.name = name;
        this.items = items;
    }

    @Override
    public String toString() {
        return "PreferenceObject{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}