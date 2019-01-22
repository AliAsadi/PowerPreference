package com.preference;

import android.content.Context;
import android.support.annotation.NonNull;

import com.preference.model.PreferenceObject;

import java.util.List;

/**
 * Created by Ali Esa Assadi on 28/11/2018.
 */
public class PowerPreference {

    private Context context;

    private PowerPreference(Context context) {
        this.context = context;
    }

    /**
     * @return A {@link Preference} instance that can be used to to retrieve and modify
     * the default preference file.
     */
    public static Preference getDefaultFile() {
        return PreferenceManager.get().getDefaultPreference();
    }

    /**
     * @param name Preference file getFileByName. If a preferences file by this getFileByName
     *             does not exist, it will be created
     * @return A {@link Preference} instance that can be used to to retrieve and modify
     * the {@code getFileByName} preference file.
     */
    public static Preference getFileByName(String name) {
        return PreferenceManager.get().getPreferenceByName(name);
    }

    /**
     * Set the global instance returned from {@link PreferenceManager#get()}.
     */
    public static void setSingletonInstance(PowerPreference instance) {
        PreferenceManager.setSingletonInstance(new PreferenceManager.Builder(instance.context).build());
    }

    /**
     * @return {@link PreferenceObject} that hold all the preference data in the app in all files.
     */
    public static List<PreferenceObject> getAllData() {
        return PreferenceManager.get().getData();
    }

    /**
     * clear all data in all preference file.
     */
    public static void clearAllData() {
        getDefaultFile().clear();
        for (String filename : PreferenceManager.get().getFilesName()) {
            PreferenceManager.get().getPreferenceByName(filename).clear();
        }
    }

    /**
     * Lunch debug screen that shows all the preference in the app.
     *
     * @param editable - Whether preference value able to edit or not.
     */
    public static void showDebugScreen(boolean editable) {
        PreferenceManager.get().showPreferenceScreen(editable);
    }

    public static class Builder {
        private final Context context;

        /**
         * Start building a new {@link PowerPreference} instance.
         */
        public Builder(@NonNull Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }

        /**
         * Create the {@link PowerPreference} instance.
         */
        public PowerPreference build() {
            return new PowerPreference(context);
        }
    }
}
