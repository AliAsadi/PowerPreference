package com.sample.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.preference.PowerPreference;
import com.preference.utils.MapStructure;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static final String USER_DETAILS = "UserDetails";
    private static final String ENVIRONMENT = "Environment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PowerPreference.init(this);
    }

    public void showPreferenceScreen(View view) {
        PowerPreference.showDebugScreen(true);
    }

    public void fill(View view) {
        PowerPreference.getFileByName(USER_DETAILS)
                .putString("firstName", "ali")
                .putString("lastName", "asadi")
                .putString("email", "ali@asadi.com");

        PowerPreference.getFileByName(ENVIRONMENT)
                .putString("env", "beta")
                .putString("host", "google.com");


        PowerPreference.getDefaultFile()
                .putBoolean("firstOpen", true)
                .putMap("map", createMap());
    }

    private HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("ali", "AK!JK");
        map.put("asadi", "164288");
        return map;
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

        MapStructure structure = MapStructure.create(HashMap.class, String.class, String.class);
        HashMap<String, String> map = PowerPreference.getDefaultFile().getMap("map", structure);

        Log.d(TAG, "firstOpen = [" + firstOpen + "]");
        Log.d(TAG, "map = [" + map + "]");
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
