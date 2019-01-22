package com.sample.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.preference.PowerPreference;

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
        PowerPreference.showDebugScreen(true);
    }

    public void fill(View view) {
        PowerPreference.getFileByName(USER_DETAILS)
                .put("firstName", "ali")
                .put("lastName", "assadi")
                .put("email", "ali@assadi.com");

        PowerPreference.getFileByName(ENVIRONMENT)
                .put("env", "beta")
                .put("host", "google.com");

        PowerPreference.getDefaultFile().put("firstOpen", true);
    }

    public void clearAllData(View view) {
        PowerPreference.clearAllData();
    }
    public void clearUserDetailsData(View view) {
        PowerPreference.getFileByName(USER_DETAILS).clear();
    }
    public void clearEnvironmentData(View view) {
        PowerPreference.getFileByName(ENVIRONMENT).clear();
    }
    public void clearDefaultData(View view) {
        PowerPreference.getDefaultFile().clear();
    }

    public void printUserDetails(View view) {

        String firstName = PowerPreference.getFileByName(USER_DETAILS).getString("firstName");
        String lastName = PowerPreference.getFileByName(USER_DETAILS).getString("lastName");
        String email = PowerPreference.getFileByName(USER_DETAILS).getString("email");

        Log.d(TAG, "env = [" + firstName + "]");
        Log.d(TAG, "host = [" + lastName + "]");
        Log.d(TAG, "host = [" + email + "]");

    }
    public void printEnv(View view) {

        String env = PowerPreference.getFileByName(ENVIRONMENT).getString("env");
        String host = PowerPreference.getFileByName(ENVIRONMENT).getString("host");

        Log.d(TAG, "env = [" + env + "]");
        Log.d(TAG, "host = [" + host + "]");

    }
    public void printDefault(View view) {
        boolean firstOpen = PowerPreference.getDefaultFile().getBoolean("firstOpen");

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

        PowerPreference.getFileByName(USER_DETAILS).setDefaults(userDefaults);
        PowerPreference.getFileByName(ENVIRONMENT).setDefaults(envDefaults);
        PowerPreference.getDefaultFile().setDefaults(defaults);
    }
    public void setDefaultsByXml(View view) {
        PowerPreference.getFileByName(USER_DETAILS).setDefaults(R.xml.prefs_user_details);
        PowerPreference.getFileByName(ENVIRONMENT).setDefaults(R.xml.prefs_environment);
        PowerPreference.getDefaultFile().setDefaults(R.xml.prefs_defaults);
    }

}
