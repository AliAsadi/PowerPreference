package com.preference.ui.util;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.preference.R;
import com.preference.model.PreferenceItem;

/**
 * Created by Ali Asadi on 05/12/2018.
 */
public class DialogUtils {
    public interface OnSaveClicked {
        void onSavePreferenceClicked(PreferenceItem item, String newValue);
    }

    public static void showEditValueDialog(Context context, final PreferenceItem item) {

        final OnSaveClicked listener = (OnSaveClicked) context;

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_edit_value, null);

        final EditText edittext = view.findViewById(R.id.valueText);
        TextView textView = view.findViewById(R.id.keyText);

        textView.setText(item.key);
        edittext.setText(String.valueOf(item.value));

        alert.setView(view);

        alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.onSavePreferenceClicked(item,edittext.getText().toString());
                }
            }
        });
        alert.setNegativeButton("Cancel", null);
        alert.show();
    }
}
