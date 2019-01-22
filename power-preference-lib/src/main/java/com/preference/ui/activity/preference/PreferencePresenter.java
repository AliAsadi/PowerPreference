package com.preference.ui.activity.preference;

import android.os.Bundle;
import android.view.MenuItem;

import com.preference.PowerPreference;
import com.preference.Preference;
import com.preference.model.PreferenceItem;
import com.preference.model.PreferenceObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Esa Assadi on 24/11/2018.
 */
class PreferencePresenter {

    private final PreferenceView view;
    private boolean editable;

    PreferencePresenter(PreferenceView view) {
        this.view = view;
    }

    void getExtras(Bundle extras) {
        if (extras != null) {
            editable = extras.getBoolean("editable", false);
        }
    }

    void getData() {
        List<PreferenceAdapter.PreferenceGroup> list = new ArrayList<>();
        List<PreferenceObject> data = PowerPreference.getAllData();
        for (PreferenceObject object : data) {
            PreferenceAdapter.PreferenceGroup group = new PreferenceAdapter.PreferenceGroup(object.name, object.items);
            list.add(group);
        }

        view.updateView(list, editable);
    }

    void onBooleanPreferenceClicked(PreferenceItem item, boolean isChecked) {
        PowerPreference.getFileByName(item.parentName).put(item.key, isChecked);
        item.value = isChecked;
    }

    void onDefaultPreferenceClicked(PreferenceItem item) {
        view.showEditValueDialog(item);
    }

    void onSavePreferenceClicked(PreferenceItem item, String newValue) throws NumberFormatException {
        Preference preference = PowerPreference.getFileByName(item.parentName);
        switch (item.type) {
            case Integer:
                preference.put(item.key, Integer.parseInt(newValue));
                item.value = Integer.parseInt(newValue);
                break;
            case Float:
                preference.put(item.key, Float.parseFloat(newValue));
                item.value = Float.parseFloat(newValue);
                break;
            case Long:
                preference.put(item.key, Long.parseLong(newValue));
                item.value = Long.parseLong(newValue);
                break;
            case Boolean:
                preference.put(item.key, Boolean.parseBoolean(newValue));
                item.value = Boolean.parseBoolean(newValue);

                break;
            case String:
                preference.put(item.key, newValue);
                item.value = newValue;
                break;
        }

        view.refreshView();
    }

    public void onExpandClicked(MenuItem item) {
        view.onExpandClicked(item);
    }

    public void onCollapseClicked(MenuItem item) {
        view.onCollapseClicked(item);
    }

    public void onBackButtonClicked() {
        view.onBackButtonClicked();
    }
}
