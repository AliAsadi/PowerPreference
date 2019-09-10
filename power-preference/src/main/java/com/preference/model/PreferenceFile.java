package com.preference.model;

import android.content.SharedPreferences;

import java.util.List;

/**
 * Created by Ali Asadi on 19/11/2018.
 */
public class PreferenceFile {
    public SharedPreferences sharedPreferences;
    public String fileName;
    public List<PreferenceItem> items;

    public PreferenceFile(SharedPreferences sharedPreferences, String fileName, List<PreferenceItem> items) {
        this.sharedPreferences = sharedPreferences;
        this.fileName = fileName;
        this.items = items;
    }

    @Override
    public String toString() {
        return "PreferenceFile{" +
                "fileName='" + fileName + '\'' +
                ", items=" + items +
                '}';
    }
}