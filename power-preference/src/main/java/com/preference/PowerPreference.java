package com.preference;

import android.content.Context;
import com.preference.model.PreferenceFile;
import java.util.List;

/**
 * Created by Ali Asadi on 28/11/2018.
 */
public class PowerPreference {

    /**
     * Initialize the library.
     */
    public static void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        PreferenceManager.init(context.getApplicationContext());
    }

    /**
     * @return A {@link Preference} instance that can be used to to retrieve and modify
     * the default preference file.
     */
    public static Preference getDefaultFile() {
        return PreferenceManager.getInstance().getDefaultPreference();
    }

    /**
     * @param name Preference file getFileByName. If a preferences file by this getFileByName
     *             does not exist, it will be created
     * @return A {@link Preference} instance that can be used to to retrieve and modify
     * the {@code getFileByName} preference file.
     */
    public static Preference getFileByName(String name) {
        return PreferenceManager.getInstance().getPreferenceByName(name);
    }

    /**
     * @return {@link PreferenceFile} that hold all the preference data in the app in all files.
     */
    public static List<PreferenceFile> getAllData() {
        return PreferenceManager.getInstance().getData();
    }

    /**
     * clear all data in all preference file synchronously.
     */
    public static void clearAllData() {
        getDefaultFile().clear();
        for (String filename : PreferenceManager.getInstance().getFilesName()) {
            getFileByName(filename).clear();
        }
    }

    /**
     * clear all data in all preference file asynchronously.
     */
    public static void clearAllDataAsync() {
        getDefaultFile().clearAsync();
        for (String filename : PreferenceManager.getInstance().getFilesName()) {
            getFileByName(filename).clearAsync();
        }
    }

    /**
     * Lunch debug screen that shows all the preference in the app.
     *
     * @param editable - Whether preference value able to edit or not.
     */
    public static void showDebugScreen(boolean editable) {
        PreferenceManager.getInstance().showPreferenceScreen(editable);
    }

}
