package com.preference.ui.activity.preference;

import android.view.MenuItem;

import com.preference.model.PreferenceItem;

import java.util.List;

/**
 * Created by Ali Esa Assadi on 10/10/2018.
 */
public interface PreferenceView {
    void updateView(List<PreferenceAdapter.PreferenceGroup> list, boolean editable);

    void showEditValueDialog(PreferenceItem item);

    void refreshView();

    void onExpandClicked(MenuItem item);

    void onCollapseClicked(MenuItem item);

    void onBackButtonClicked();
}
