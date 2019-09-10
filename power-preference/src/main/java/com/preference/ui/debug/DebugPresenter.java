package com.preference.ui.debug;

import android.os.Bundle;
import android.view.MenuItem;

import com.preference.PowerPreference;
import com.preference.Preference;
import com.preference.model.PreferenceItem;
import com.preference.model.PreferenceFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Asadi on 24/11/2018.
 */
class DebugPresenter implements DebugContract.Presenter {

    private final DebugContract.View view;
    private boolean editable;

    DebugPresenter(DebugContract.View view) {
        this.view = view;
    }

    @Override
    public void getExtras(Bundle extras) {
        if (extras != null) {
            editable = extras.getBoolean("editable", false);
        }
    }

    @Override
    public void getData() {
        List<DebugAdapter.PreferenceGroup> list = new ArrayList<>();
        List<PreferenceFile> data = PowerPreference.getAllData();
        for (PreferenceFile object : data) {
            DebugAdapter.PreferenceGroup group = new DebugAdapter.PreferenceGroup(object.fileName, object.items);
            list.add(group);
        }

        view.updateView(list, editable);
    }

    @Override
    public void onBooleanPreferenceClicked(PreferenceItem item, boolean isChecked) {
        PowerPreference.getFileByName(item.fileName).putBoolean(item.key, isChecked);
        item.value = isChecked;
    }

    @Override
    public void onDefaultPreferenceClicked(PreferenceItem item) {
        view.showEditValueDialog(item);
    }

    @Override
    public void onSavePreferenceClicked(PreferenceItem item, String newValue) throws NumberFormatException {
        Preference preference = PowerPreference.getFileByName(item.fileName);
        switch (item.type) {
            case Integer:
                preference.putInt(item.key, Integer.parseInt(newValue));
                item.value = Integer.parseInt(newValue);
                break;
            case Float:
                preference.putFloat(item.key, Float.parseFloat(newValue));
                item.value = Float.parseFloat(newValue);
                break;
            case Long:
                preference.putLong(item.key, Long.parseLong(newValue));
                item.value = Long.parseLong(newValue);
                break;
            case Boolean:
                preference.putBoolean(item.key, Boolean.parseBoolean(newValue));
                item.value = Boolean.parseBoolean(newValue);

                break;
            case String:
                preference.putString(item.key, newValue);
                item.value = newValue;
                break;
        }

        view.refreshView();
    }

    @Override
    public void onExpandClicked(MenuItem item) {
        view.onExpandClicked(item);
    }

    @Override
    public void onCollapseClicked(MenuItem item) {
        view.onCollapseClicked(item);
    }

    @Override
    public void onBackButtonClicked() {
        view.onBackButtonClicked();
    }
}
