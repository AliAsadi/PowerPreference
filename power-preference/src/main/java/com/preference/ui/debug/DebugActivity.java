package com.preference.ui.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.preference.R;
import com.preference.model.PreferenceItem;
import com.preference.ui.util.DialogUtils;

import java.util.List;

/**
 * Created by Ali Asadi on 10/10/2018.
 */
public class DebugActivity extends AppCompatActivity implements DebugContract.View,
        DebugAdapter.PrefsListener, DialogUtils.OnSaveClicked {

    private RecyclerView recyclerView;
    private DebugAdapter adapter;
    private DebugPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.PreferenceTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        setTitle("Debug");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        presenter = new DebugPresenter(this);
        presenter.getExtras(getIntent().getExtras());
        presenter.getData();
    }

    @Override
    public void updateView(List<DebugAdapter.PreferenceGroup> list, boolean editable) {
        adapter = new DebugAdapter(list, this, editable);
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

    public static void start(Context context, boolean editable) {
        Intent starter = new Intent(context, DebugActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        starter.putExtra("editable", editable);
        context.startActivity(starter);
    }
}
