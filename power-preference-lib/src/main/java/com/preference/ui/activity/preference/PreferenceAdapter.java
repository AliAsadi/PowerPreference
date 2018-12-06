package com.preference.ui.activity.preference;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.preference.R;
import com.preference.model.PreferenceItem;
import com.thoughtbot.expandablerecyclerview.MultiTypeExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

/**
 * Created by Ali Esa Assadi on 10/10/2018.
 */
public class PreferenceAdapter extends MultiTypeExpandableRecyclerViewAdapter<PreferenceAdapter.TitleViewHolder, ChildViewHolder> implements View.OnClickListener {

    private final PrefsListener listener;

    private static final int DEFAULT_VIEW_TYPE = 3;
    private static final int BOOLEAN_VIEW_TYPE = 4;
    private final boolean editable;

    public void expandAll() {
        for (int i = getGroups().size() - 1; i >= 0; i--) {
            if (isGroupExpanded(i)) {
                return;
            }
            toggleGroup(i);
        }
        notifyDataSetChanged();
    }


    public void collapseAll() {
        for (ExpandableGroup group : getGroups()) {
            if (isGroupExpanded(group)) {
                toggleGroup(group);
            }
        }
    }

    public interface PrefsListener {
        void onDefaultPreferenceClicked(PreferenceItem item);

        void onBooleanPreferenceClicked(PreferenceItem item, boolean checked);
    }

    public PreferenceAdapter(List<? extends ExpandableGroup> groups, PrefsListener listener, boolean editable) {
        super(groups);
        this.listener = listener;
        this.editable = editable;
    }

    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_preference_title, parent, false);
        return new TitleViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        ChildViewHolder viewHolder = null;
        View view;
        switch (viewType) {
            case DEFAULT_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_preference_default, parent, false);
                viewHolder = new StringChildViewHolder(view);
                break;

            case BOOLEAN_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_preference_boolean, parent, false);
                viewHolder = new BooleanChildViewHolder(view);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {
        final PreferenceItem item = (PreferenceItem) group.getItems().get(childIndex);

        switch (item.type) {
            case Boolean:
                BooleanChildViewHolder booleanHolder = (BooleanChildViewHolder) holder;
                booleanHolder.keyText.setText(item.key);
                booleanHolder.checkBox.setChecked((Boolean) item.value);

                if (editable) {
                    booleanHolder.checkBox.setClickable(true);
                    booleanHolder.checkBox.setTag(item);
                    booleanHolder.checkBox.setOnClickListener(this);
                } else {
                    booleanHolder.checkBox.setClickable(false);
                }
                break;
                default:

                    StringChildViewHolder stringHolder = (StringChildViewHolder) holder;
                    stringHolder.keyText.setText(item.key);
                    stringHolder.valueText.setText(item.value + "");
                    if (editable) {
                        stringHolder.valueText.setTextColor(Color.WHITE);
                        holder.itemView.setTag(item);
                        holder.itemView.setOnClickListener(this);
                    } else {
                        //do nothing
                    }

                    break;
        }


    }

    @Override
    public int getChildViewType(int position, ExpandableGroup group, int childIndex) {
        final PreferenceItem item = (PreferenceItem) group.getItems().get(childIndex);
        switch (item.type) {
            case String:
            case Long:
            case Float:
            case Integer:
                return DEFAULT_VIEW_TYPE;
            case Boolean:
                return BOOLEAN_VIEW_TYPE;
            default:
                throw new IllegalStateException("unknown type");
        }
    }

    @Override
    public boolean isChild(int viewType) {
        return viewType == DEFAULT_VIEW_TYPE || viewType == BOOLEAN_VIEW_TYPE;
    }

    @Override
    public void onBindGroupViewHolder(TitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setPrefsTitle(group);
    }

    @Override
    public void onClick(View v) {

        PreferenceItem item = (PreferenceItem) v.getTag();
        switch (item.type) {
            case Boolean:
                CheckBox view = (CheckBox) v;
                if (listener != null) {
                    listener.onBooleanPreferenceClicked(item, view.isChecked());
                }
                break;

            default:
                if (listener != null) {
                    listener.onDefaultPreferenceClicked(item);
                }
                break;
        }

    }

    //ViewHolder
    public class TitleViewHolder extends GroupViewHolder {

        private TextView prefsTitle;

        public TitleViewHolder(View itemView) {
            super(itemView);
            prefsTitle = itemView.findViewById(R.id.prefs_title);
        }

        @Override
        public void expand() {
            super.expand();
        }

        public void setPrefsTitle(ExpandableGroup group) {
            prefsTitle.setText(group.getTitle());
        }
    }

    public class StringChildViewHolder extends ChildViewHolder {

        TextView keyText;
        TextView valueText;

        public StringChildViewHolder(View itemView) {
            super(itemView);
            keyText = itemView.findViewById(R.id.key);
            valueText = itemView.findViewById(R.id.value);
        }

    }

    public class BooleanChildViewHolder extends ChildViewHolder {

        TextView keyText;
        CheckBox checkBox;

        public BooleanChildViewHolder(View itemView) {
            super(itemView);
            keyText = itemView.findViewById(R.id.key);
            checkBox = itemView.findViewById(R.id.value);
        }

    }

    //Group
    public static class PreferenceGroup extends ExpandableGroup<PreferenceItem> {

        public PreferenceGroup(String title, List<PreferenceItem> items) {
            super(title, items);
        }
    }

}
