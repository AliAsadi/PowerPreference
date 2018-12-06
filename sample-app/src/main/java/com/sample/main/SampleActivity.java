package com.sample.main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.preference.PowerPreference;
import com.preference.model.PreferenceItem;
import com.preference.model.PreferenceType;

import java.util.HashMap;
import java.util.Map;

public class SampleActivity extends Activity {

    private static final String TAG = "SampleActivity";

    private static final String USER_DETAILS = "UserDetails";
    private static final String ENVIRONMENT = "Environment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        //there is no defaults!
    }

    public void showPreferenceScreen(View view) {
        PowerPreference.showPreferenceScreen(true);
    }

    public void fill(View view) {
        PowerPreference.name(USER_DETAILS)
                .put("firstName", "ali")
                .put("lastName", "assadi")
                .put("email", "ali@assadi.com");

        PowerPreference.name(ENVIRONMENT)
                .put("env", "beta")
                .put("host", "google.com");

        PowerPreference.defult().put("firstOpen", true);
    }

    public void clearAllData(View view) {
        PowerPreference.clearAll();
    }
    public void clearUserDetailsData(View view) {
        PowerPreference.name(USER_DETAILS).clear();
    }
    public void clearEnvironmentData(View view) {
        PowerPreference.name(ENVIRONMENT).clear();
    }
    public void clearDefaultData(View view) {
        PowerPreference.defult().clear();
    }

    public void printUserDetails(View view) {

        String firstName = PowerPreference.name(USER_DETAILS).getString("firstName");
        String lastName = PowerPreference.name(USER_DETAILS).getString("lastName");
        String email = PowerPreference.name(USER_DETAILS).getString("email");

        Log.d(TAG, "env = [" + firstName + "]");
        Log.d(TAG, "host = [" + lastName + "]");
        Log.d(TAG, "host = [" + email + "]");

    }
    public void printEnv(View view) {

        String env = PowerPreference.name(ENVIRONMENT).getString("env");
        String host = PowerPreference.name(ENVIRONMENT).getString("host");

        Log.d(TAG, "env = [" + env + "]");
        Log.d(TAG, "host = [" + host + "]");

    }
    public void printDefault(View view) {
        boolean firstOpen = PowerPreference.defult().getBoolean("firstOpen");

        Log.d(TAG, "firstOpen = [" + firstOpen + "]");
    }

    public void setDefaultsByHashMap(View view) {

        Map<String, Object> userDefaults = new HashMap<>();
        userDefaults.put("firstName", "none");
        userDefaults.put("lastName", "none");
        userDefaults.put("email", "none@none.com");

        Map<String, Object> envDefaults = new HashMap<>();
        envDefaults.put("env", "production");
        envDefaults.put("host", "github.com");

        Map<String, Object> defaults = new HashMap<>();
        envDefaults.put("firstOpen", false);

        PowerPreference.name(USER_DETAILS).setDefaults(userDefaults);
        PowerPreference.name(ENVIRONMENT).setDefaults(envDefaults);
        PowerPreference.defult().setDefaults(defaults);
    }
    public void setDefaultsByXml(View view) {
        PowerPreference.name(USER_DETAILS).setDefaults(R.xml.prefs_user_details);
        PowerPreference.name(ENVIRONMENT).setDefaults(R.xml.prefs_environment);
        PowerPreference.defult().setDefaults(R.xml.prefs_defaults);
    }

}
