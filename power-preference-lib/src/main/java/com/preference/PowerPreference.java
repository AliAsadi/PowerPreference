package com.preference;

import com.preference.model.PreferenceObject;
import com.preference.utils.PreferenceCreator;

import java.util.List;

/**
 * Created by Ali Esa Assadi on 28/11/2018.
 */
public class PowerPreference {
    /**
     * Lunch Preference screen that shows all the preference in the app.
     *
     * @param editable - Whether preference value able to edit or not.
     */
    public static void showPreferenceScreen(boolean editable) {
        PreferenceManager.get().showPreferenceScreen(editable);
    }

    /**
     * @return {@link PreferenceObject} that hold all the preference data in the app in all files.
     */
    public static List<PreferenceObject> getData() {
        return PreferenceManager.get().getData();
    }

    /**
     * @return A {@link PreferenceCreator} instance that can be used to to retrieve and modify
     * the default preference file.
     */
    public static PreferenceCreator defult() {
        return PreferenceManager.get().getDefaultPreference();
    }

    /**
     * @param name Preference file name. If a preferences file by this name
     * does not exist, it will be created
     *
     * @return A {@link PreferenceCreator} instance that can be used to to retrieve and modify
     * the {@code name} preference file.
     */
    public static PreferenceCreator name(String name) {
        return PreferenceManager.get().getPreferenceByName(name);
    }

    /**
     * clear all data in all preference file.
     */
    public static void clearAll() {
        defult().clear();
        for (String filename : PreferenceManager.get().getFilesName()) {
            PreferenceManager.get().getPreferenceByName(filename).clear();
        }
    }
}
