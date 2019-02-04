package com.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.XmlRes;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.preference.utils.WrongValueException;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ali Esa Assadi on 22/11/2018.
 */
class PreferenceCreator implements Preference {

    private static String TAG = "PowerPreference";

    private String name;
    private Context context;
    private SharedPreferences sharedPreferences;
    private Map<String, Object> defaults;

    /**
     * Initialize PreferenceCreator for accessing and modifying default preference data.
     */
    public PreferenceCreator(Context context, Map<String, Object> defaults) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;
        this.defaults = defaults;
        this.name = "default";
    }

    /**
     * Initialize PreferenceCreator for accessing and modifying preference data by name.
     *
     * @param name name of preference file.
     */
    public PreferenceCreator(String name, Context context, Map<String, Object> defaults) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.context = context;
        this.defaults = defaults;
        this.name = name;
    }


    /**
     * Store int in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
        return this;
    }

    /**
     * Store long in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
        return this;
    }

    /**
     * Store float in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
        return this;
    }

    /**
     * Store double in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, double value) {
        sharedPreferences.edit().putString(key, String.valueOf(value)).apply();
        return this;
    }

    /**
     * Store boolean in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
        return this;
    }

    /**
     * Store String in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
        return this;
    }

    /**
     * Store Object in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator put(String key, Object value) {
        String json = new Gson().toJson(value);
        sharedPreferences.edit().putString(key, json).apply();
        return this;
    }

    /**
     * Store int in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, int value) {
        return sharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * Store long in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, long value) {
        return sharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * Store float in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, float value) {
        return sharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * Store double in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, double value) {
        return sharedPreferences.edit().putString(key, String.valueOf(value)).commit();

    }

    /**
     * Store boolean in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, boolean value) {
        return sharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * Store String in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, String value) {
        return sharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * Store Object in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean set(String key, Object value) {
        String json = new Gson().toJson(value);
        return sharedPreferences.edit().putString(key, json).commit();
    }

    /**
     * Store int in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
        return this;
    }

    /**
     * Store long in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
        return this;
    }

    /**
     * Store float in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putFloat(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
        return this;
    }

    /**
     * Store double in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putDouble(String key, double value) {
        sharedPreferences.edit().putString(key, String.valueOf(value)).apply();
        return this;
    }

    /**
     * Store boolean in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
        return this;
    }

    /**
     * Store String in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
        return this;
    }

    /**
     * Store Object in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link PreferenceCreator} object, so you can
     * chain put calls together.
     */
    public PreferenceCreator putObject(String key, Object value) {
        String json = new Gson().toJson(value);
        sharedPreferences.edit().putString(key, json).apply();
        return this;
    }

    /**
     * Store int in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setInt(String key, int value) {
        return sharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * Store long in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setLong(String key, long value) {
        return sharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * Store float in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setFloat(String key, float value) {
        return sharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * Store double in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setDouble(String key, double value) {
        return sharedPreferences.edit().putString(key, String.valueOf(value)).commit();

    }

    /**
     * Store boolean in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setBoolean(String key, boolean value) {
        return sharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * Store String in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setString(String key, String value) {
        return sharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * Store Object in SharedPreference Data.
     * <p><p>
     * commit() writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return returns true if the save works, false otherwise.
     */
    public boolean setObject(String key, Object value) {
        String json = new Gson().toJson(value);
        return sharedPreferences.edit().putString(key, json).commit();
    }

    /**
     * @param key - key name.
     * @return Returns true if the preference exists in the preferences,
     * otherwise false.
     */
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * remove key from preference.
     *
     * @param key - key name to remove.
     */
    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    /**
     * remove all data from this preference.
     */
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    public Map<String, ?> getData() {
        return sharedPreferences.getAll();
    }

    /**
     * Retrieve a String value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@value ""} empty string.
     */
    public @NonNull
    String getString(String key) {
        Object value = getDefaultValue(key);

        String defaultValue = "";
        if (value != null) {
            defaultValue = String.valueOf(value);
        }
        return sharedPreferences.getString(key, defaultValue);
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * Retrieve a int value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    public int getInt(String key) {
        Object value = getDefaultValue(key);

        int defaultValue = 0;
        if (value != null) {
            if (value instanceof Integer) {
                defaultValue = (int) value;
            } else if (value instanceof String) {
                try {
                    defaultValue = Integer.parseInt((String) value);
                } catch (NumberFormatException e) {
                    Log.d(TAG, "you to must have a {Integer} default value! for the key => {" + key + "}", e);
                }
            } else {
                Log.d(TAG, "you to must have a {Integer} default value! for the key => {" + key + "}",
                        new WrongValueException(value));
            }
        }
        return sharedPreferences.getInt(key, defaultValue);
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    /**
     * Retrieve a long value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    public long getLong(String key) {
        Object value = getDefaultValue(key);

        long defaultValue = 0;
        if (value != null) {
            if (value instanceof Long) {
                defaultValue = (long) value;
            } else if (value instanceof String) {
                try {
                    defaultValue = Long.parseLong((String) value);
                } catch (NumberFormatException e) {
                    Log.d(TAG, "you to must have a {Long} default value! for the key => {" + key + "}", e);
                }
            } else {
                Log.d(TAG, "you to must have a {Long} default value! for the key => {" + key + "}",
                        new WrongValueException(value));
            }
        }
        return sharedPreferences.getLong(key, defaultValue);
    }

    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain false}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    public boolean getBoolean(String key) {
        Object value = getDefaultValue(key);

        boolean defaultValue = false;
        if (value != null) {
            if (value instanceof Boolean) {
                defaultValue = (boolean) value;
            } else if (value instanceof String) {
                defaultValue = Boolean.parseBoolean((String) value);
            } else {
                Log.d(TAG, "you to must have a {Boolean} default value! for the key => {" + key + "}",
                        new WrongValueException(value));
            }
        }
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * Retrieve a float value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    public float getFloat(String key) {
        Object value = getDefaultValue(key);

        float defaultValue = 0;
        if (value != null) {
            if (value instanceof Float) {
                defaultValue = (float) value;
            } else if (value instanceof String) {
                try {
                    defaultValue = Float.parseFloat((String) value);
                } catch (NumberFormatException e) {
                    Log.d(TAG, "you to must have a {Float} default value! for the key => {" + key + "}", e);
                }
            } else {
                Log.d(TAG, "you to must have a {Float} default value! for the key => {" + key + "}",
                        new WrongValueException(value));
            }
        }
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public float getFloat(String key, float defValue) {
        return sharedPreferences.getFloat(key, defValue);
    }

    public <T> T getObject(String key, Class classType, T defValue) {
        String json = sharedPreferences.getString(key, "");
        Object value = new Gson().fromJson(json, classType);
        if (value == null) {
            return defValue;
        }
        return (T) value;
    }

    /**
     * Retrieve a Object value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * <p>
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain null}.
     */
    public @Nullable
    <T> T getObject(String key, Class classType) {
        String json = sharedPreferences.getString(key, "");
        Object value = new Gson().fromJson(json, classType);
        if (value == null) {
            return (T) getDefaultValue(key);
        }
        return (T) value;
    }

    /**
     * Retrieve a Map value from the preferences
     *
     * @param key       - The name of the preference to retrieve.
     * @param classType - the type of the Map -> HashMap,TreeMap..etc.
     * @param keyType   - the type of the key that used in the map.
     * @param valueType - the type of the value that used in the map.
     * @return Returns the preference value if it exists, or null.
     */
    public @Nullable
    <T> T getMap(String key, Class classType, Class keyType, Class valueType) {
        String json = sharedPreferences.getString(key, "");
        Object value = new Gson().fromJson(json, TypeToken.getParameterized(classType, keyType,
                valueType).getType());
        if (value == null) {
            return (T) getDefaultValue(key);
        }
        return (T) value;
    }

    /**
     * Retrieve a double value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * <p>
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    public double getDouble(String key) {
        String string = sharedPreferences.getString(key, "");

        double value;
        double defaultDouble = 0;
        try {
            value = Double.valueOf(string);
        } catch (NumberFormatException exp) {
            Object defaultValue = getDefaultValue(key);
            if (defaultValue == null) {
                return 0;
            } else {
                if (defaultValue instanceof Double) {
                    defaultDouble = (double) defaultValue;
                } else if (defaultValue instanceof String) {
                    try {
                        defaultDouble = Double.parseDouble((String) defaultValue);
                    } catch (NumberFormatException e) {
                        Log.d(TAG, "you to must have a {Double} default value! for the key => {" + key + "}", e);
                    }
                } else {
                    Log.d(TAG, "you to must have a {Double} default value! for the key => {" + key + "}",
                            new WrongValueException(defaultValue));
                }
                return defaultDouble;
            }
        }

        return value;
    }

    public double getDouble(String key, double defValue) {
        String json = sharedPreferences.getString(key, "");
        Object value = new Gson().fromJson(json, double.class);
        if (value == null) {
            return defValue;
        }
        return (double) value;
    }

    /**
     * Set defaults value fo this preference file.
     * defaults will uses when use one of the method getString, getInt...etc, and there is no value
     * for the key you entered then the library will use this default value.
     *
     * @param defaultValues - map.
     */
    public void setDefaults(Map<String, Object> defaultValues) {
        if (defaultValues == null) {
            return;
        }
        defaults.put(name, defaultValues);
    }

    /**
     * Set defaults value fo this preference file.
     * <p>
     * defaults will uses when use one of the method getString, getInt...etc, and there is no value
     * for the key you entered then the library will use this default value.
     *
     * @param xml - xml.
     */
    public void setDefaults(@XmlRes int xml) {
        try {

            final String KEY = "key";
            final String VALUE = "value";
            final String ENTRY = "entry";

            XmlResourceParser parser = context.getResources().getXml(xml);
            int eventType = parser.getEventType();

            String tagName = null;
            String key = null;
            String value = null;
            Map<String, Object> defaultValues = new HashMap<>();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();

                        break;

                    case XmlPullParser.TEXT:
                        if (tagName != null) {
                            switch (tagName) {
                                case KEY:
                                    key = parser.getText();
                                    break;
                                case VALUE:
                                    value = parser.getText();
                                    break;
                                default:
                                    //do nothing
                                    break;
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals(ENTRY)) {
                            defaultValues.put(key, value);
                            key = null;
                            value = null;
                        }

                        break;
                }

                eventType = parser.next();
            }

            defaults.put(name, defaultValues);
        } catch (Exception e) {
            Log.d(TAG, "Caught exception while parsing XML resource. Skipping setDefaults.", e);
        }


    }

    private @Nullable
    Object getDefaultValue(String key) {
        Map<String, Object> defaultValues = (Map<String, Object>) defaults.get(name);
        if (defaultValues != null) {
            if (defaultValues.containsKey(key)) {
                return defaultValues.get(key);
            } else {
                return null;
            }
        }
        return null;
    }

}
