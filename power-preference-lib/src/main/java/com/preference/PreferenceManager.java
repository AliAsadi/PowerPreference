package com.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.preference.provider.PreferenceProvider;
import com.preference.ui.activity.preference.PreferenceActivity;
import com.preference.model.PreferenceItem;
import com.preference.model.PreferenceObject;
import com.preference.model.PreferenceType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ali Esa Assadi on 16/11/2018.
 */
class PreferenceManager {
    private static PreferenceManager singleton;

    private final Context context;
    private Map<String, Object> defaults;

    private PreferenceManager(Context context, Map<String, Object> defaults) {
        this.context = context;
        this.defaults = defaults;
    }

    public static void setSingletonInstance(PreferenceManager singleton) {
        PreferenceManager.singleton = singleton;
    }

    static PreferenceManager get() {
        if (singleton == null) {
            synchronized (PreferenceManager.class) {
                if (singleton == null) {
                    if (PreferenceProvider.context == null) {
                        throw new IllegalStateException("context == null");
                    }
                    singleton = new Builder(PreferenceProvider.context).build();
                }
            }
        }
        return singleton;
    }

    void showPreferenceScreen(boolean editable) {
        Intent intent = new Intent(context, PreferenceActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("editable", editable);
        context.startActivity(intent);
    }

    PreferenceCreator getPreferenceByName(String name) {
        return new PreferenceCreator(name, context, defaults);
    }

    PreferenceCreator getDefaultPreference() {
        return new PreferenceCreator(context, defaults);
    }

    List<PreferenceObject> getData() {
        Map<SharedPreferences, String> nameHelper = new HashMap<>(); //prefs name helper
        List<PreferenceObject> items = new ArrayList<>(); //items

        List<SharedPreferences> allFiles = getFiles(nameHelper);
        for (SharedPreferences sp : allFiles) {

            Map<String, ?> map = sp.getAll();
            if (map.size() > 0) {

                List<PreferenceItem> prefsItems = new ArrayList<>();
                for (Map.Entry<String, ?> obj : map.entrySet()) {
                    PreferenceType type = getValueType(obj.getValue());
                    prefsItems.add(new PreferenceItem(obj.getKey(), obj.getValue(), nameHelper.get(sp), type));
                }

                items.add(new PreferenceObject(sp, nameHelper.get(sp), prefsItems));
            }
        }
        return items;
    }

    ArrayList<String> getFilesName() {
        ArrayList<String> filesName = new ArrayList<>();

        String[] files = new File(get().context.getApplicationInfo().dataDir + "/shared_prefs").list();
        if (files != null) {
            for (String fileName : files) {
                String fileNameWithoutExtension = fileName.substring(0, TextUtils.indexOf(fileName, ".xml"));
                filesName.add(fileNameWithoutExtension);
            }
        }
        return filesName;
    }

    private PreferenceType getValueType(Object value) {
        if (value instanceof Boolean) {
            return PreferenceType.Boolean;
        } else if (value instanceof String) {
            return PreferenceType.String;
        } else if (value instanceof Integer) {
            return PreferenceType.Integer;
        } else if (value instanceof Float) {
            return PreferenceType.Float;
        } else if (value instanceof Long) {
            return PreferenceType.Long;
        }
        return PreferenceType.String;
    }

    private List<SharedPreferences> getFiles(Map<SharedPreferences, String> prefsNameHelper) {
        List<SharedPreferences> preferencesList = new ArrayList<>();

        for (String fileName : getFilesName()) {
            SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
            prefsNameHelper.put(sp, fileName);
            preferencesList.add(sp);
        }
        return preferencesList;
    }

    public static class Builder {

        private final Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public PreferenceManager build() {
            return new PreferenceManager(context, new HashMap<String, Object>());
        }
    }
}
