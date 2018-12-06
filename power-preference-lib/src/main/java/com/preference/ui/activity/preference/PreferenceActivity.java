package com.preference.ui.activity.preference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.preference.R;
import com.preference.model.PreferenceItem;
import com.preference.utils.DialogUtils;

import java.util.List;

/**
 * Created by Ali Esa Assadi on 10/10/2018.
 */
public class PreferenceActivity extends AppCompatActivity implements PreferenceView,
        PreferenceAdapter.PrefsListener, DialogUtils.OnSaveClicked {

    private RecyclerView recyclerView;
    private PreferenceAdapter adapter;
    private PreferencePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.PreferenceTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        setTitle("Preference");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        presenter = new PreferencePresenter(this);
        presenter.getExtras(getIntent().getExtras());
        presenter.getData();
    }

    @Override
    public void updateView(List<PreferenceAdapter.PreferenceGroup> list, boolean editable) {
        adapter = new PreferenceAdapter(list, this, editable);
        adapter.expandAll();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void refreshView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showEditValueDialog(PreferenceItem item) {
        DialogUtils.showEditValueDialog(this, item);
    }

    @Override
    public void onDefaultPreferenceClicked(PreferenceItem item) {
        presenter.onDefaultPreferenceClicked(item);
    }

    @Override
    public void onBooleanPreferenceClicked(PreferenceItem item, boolean isChecked) {
        presenter.onBooleanPreferenceClicked(item, isChecked);
    }

    @Override
    public void onSavePreferenceClicked(PreferenceItem item, String newValue) {
        try {
            presenter.onSavePreferenceClicked(item, newValue);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "you have entered an incorrect value", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onExpandClicked(MenuItem item) {
        item.setTitle("collapse");
        adapter.expandAll();
    }

    @Override
    public void onCollapseClicked(MenuItem item) {
        item.setTitle("expand");
        adapter.collapseAll();
    }

    @Override
    public void onBackButtonClicked() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.preference_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            presenter.onBackButtonClicked();
        } else if (id == R.id.expand_collapse) {
            if (item.getTitle().toString().equalsIgnoreCase("expand")) {
                presenter.onExpandClicked(item);
            } else {
                presenter.onCollapseClicked(item);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
