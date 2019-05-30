package com.sample.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.preference.PowerPreference;
import com.preference.model.PreferenceItem;
import com.preference.model.PreferenceType;

import java.util.HashMap;
import java.util.Map;

public class TestActivity extends Activity {

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }

    Map<String, Object> getDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("boolean", true);
        defaults.put("string", "Hello World!");
        defaults.put("int", 123);
        defaults.put("long", 111L);
        defaults.put("float", 1.1f);
        defaults.put("double", 1.111d);
        defaults.put("object", new Object());

        return defaults;

    }

    Map<String, Object> getWrongDefaults() {
        Map<String, Object> defaultValues = new HashMap<>();
        defaultValues.put("boolean", new Object());
        defaultValues.put("string", new Object());
        defaultValues.put("int", new Object());
        defaultValues.put("long", new Object());
        defaultValues.put("float", new Object());
        defaultValues.put("double", new Object());
        defaultValues.put("object", new Object());

        return defaultValues;

    }

    Map<String, Object> getWrong2Defaults() {
        Map<String, Object> defaultValues = new HashMap<>();
        defaultValues.put("boolean", 123213);
        defaultValues.put("string", 134+"asd");
        defaultValues.put("int", 111.1f);
        defaultValues.put("long", "asdas");
        defaultValues.put("float", 12312L);
        defaultValues.put("double", 11f);
        defaultValues.put("object", "!23");

        return defaultValues;
    }

    Map<String, Object> getWrong3Defaults() {
        Map<String, Object> defaultValues = new HashMap<>();
        defaultValues.put("boolean", null);
        defaultValues.put("string", null);
        defaultValues.put("int", null);
        defaultValues.put("long", null);
        defaultValues.put("float", null);
        defaultValues.put("double", null);
        defaultValues.put("object", null);

        return defaultValues;
    }

    Map<String, Object> getWrong4Defaults() {
        Map<String, Object> defaultValues = new HashMap<>();
        defaultValues.put(null, null);
        defaultValues.put(null, null);
        defaultValues.put(null, null);
        defaultValues.put(null, null);
        defaultValues.put(null, null);
        defaultValues.put(null, null);
        defaultValues.put(null, null);

        return defaultValues;
    }

    public void showPreferenceScreen(View view) {
        PowerPreference.showDebugScreen(true);
    }

    public void setDefaultValueByXml(View view) {
        PowerPreference.getDefaultFile().setDefaults(R.xml.preferences_defaults);
    }

    public void setDefaultValueByMap(View view) {
        Map<String, Object> defaultValues = getDefaults();
        PowerPreference.getDefaultFile().setDefaults(defaultValues);
    }

    public void fill(View view) {
        PreferenceItem object = new PreferenceItem("test", "test", "test", PreferenceType.String);

        PowerPreference.getDefaultFile()
                .put("boolean", true)
                .put("string", "Hello World!")
                .put("int", 123)
                .put("long", 111L)
                .put("float", 1.1f)
                .put("double", 1.111d)
                .put("object", object);

        PowerPreference.getFileByName("Old")
                .putBoolean("boolean", true)
                .putString("string", "Hello World!")
                .putInt("int", 123)
                .putLong("long", 111L)
                .putFloat("float", 1.1f)
                .putDouble("double", 1.111d)
                .putObject("object", object);

        PowerPreference.getFileByName("Test")
                .put("boolean", true)
                .put("string", "Hello World!")
                .put("int", 123)
                .put("long", 111L)
                .put("float", 1.1f)
                .put("double", 1.111d)
                .put("object", object);

    }

    public void clearData(View view) {
        PowerPreference.clearAllData();
    }

    public void print(View view) {

        boolean bool = PowerPreference.getDefaultFile().getBoolean("boolean");
        String str = PowerPreference.getDefaultFile().getString("string");
        int integer = PowerPreference.getDefaultFile().getInt("int");
        long aLong = PowerPreference.getDefaultFile().getLong("long");
        float aFloat = PowerPreference.getDefaultFile().getFloat("float");
        double aDouble = PowerPreference.getDefaultFile().getDouble("double");
        Object aObject = PowerPreference.getDefaultFile().getObject("object", Object.class);

        Log.d(TAG, "boolean = [" + bool + "]");
        Log.d(TAG, "string = [" + str + "]");
        Log.d(TAG, "int = [" + integer + "]");
        Log.d(TAG, "long = [" + aLong + "]");
        Log.d(TAG, "float = [" + aFloat + "]");
        Log.d(TAG, "double = [" + aDouble + "]");
        Log.d(TAG, "object = [" + aObject + "]");

    }

}
