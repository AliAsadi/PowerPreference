package com.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.preference.model.PreferenceFile;
import com.preference.provider.PreferenceProvider;
import com.preference.ui.debug.DebugActivity;
import com.preference.model.PreferenceItem;
import com.preference.model.PreferenceType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ali Asadi on 16/11/2018.
 */
class PreferenceManager {
    private static PreferenceManager singleton;

    private final Context context;
    private Map<String, Object> defaults;

    private PreferenceManager(Context context, Map<String, Object> defaults) {
        this.context = context;
        this.defaults = defaults;
    }

    synchronized static void init(Context context) {
        singleton = new PreferenceManager(context, new HashMap<String, Object>());
    }

    synchronized static PreferenceManager getInstance() {
        if (singleton == null) {
            if (PreferenceProvider.context == null) {
                throw new IllegalStateException("context == null");
            }
            singleton = new PreferenceManager(PreferenceProvider.context, new HashMap<String, Object>());
        }
        return singleton;
    }

    void showPreferenceScreen(boolean editable) {
        DebugActivity.start(context, editable);
    }

    PreferenceCreator getPreferenceByName(String name) {
        return new PreferenceCreator(name, context, defaults);
    }

    PreferenceCreator getDefaultPreference() {
        return new PreferenceCreator(context, defaults);
    }

    List<PreferenceFile> getData() {
        Map<SharedPreferences, String> nameHelper = new HashMap<>(); //prefs name helper
        List<PreferenceFile> items = new ArrayList<>(); //items

        List<SharedPreferences> allFiles = getFiles(nameHelper);
        for (SharedPreferences sp : allFiles) {

            Map<String, ?> map = sp.getAll();
            if (map.size() > 0) {

                List<PreferenceItem> prefsItems = new ArrayList<>();
                for (Map.Entry<String, ?> obj : map.entrySet()) {
                    PreferenceType type = getValueType(obj.getValue());
                    prefsItems.add(new PreferenceItem(obj.getKey(), obj.getValue(), nameHelper.get(sp), type));
                }

                items.add(new PreferenceFile(sp, nameHelper.get(sp), prefsItems));
            }
        }
        return items;
    }

    ArrayList<String> getFilesName() {
        ArrayList<String> filesName = new ArrayList<>();

        String[] files = new File(getInstance().context.getApplicationInfo().dataDir + "/shared_prefs").list();
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

}
