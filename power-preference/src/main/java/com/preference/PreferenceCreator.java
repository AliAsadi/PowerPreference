package com.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.XmlRes;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xmlpull.v1.XmlPullParser;

import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ali Asadi on 22/11/2018.
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
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
        return this;
    }

    /**
     * Store long in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
        return this;
    }

    /**
     * Store float in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putFloat(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
        return this;
    }

    /**
     * Store double in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putDouble(String key, double value) {
        sharedPreferences.edit().putString(key, String.valueOf(value)).apply();
        return this;
    }

    /**
     * Store boolean in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
        return this;
    }

    /**
     * Store String in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
        return this;
    }

    /**
     * Store Object in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public PreferenceCreator putObject(String key, Object value) {
        String json = new Gson().toJson(value);
        sharedPreferences.edit().putString(key, json).apply();
        return this;
    }

    /**
     * Store Map in SharedPreference Data.
     * <p>
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    @Override
    public Preference putMap(String key, Map value) {
        putObject(key, value);
        return this;
    }

    /**
     * Store int in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setInt(String key, int value) {
        return sharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * Store long in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setLong(String key, long value) {
        return sharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * Store float in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setFloat(String key, float value) {
        return sharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * Store double in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setDouble(String key, double value) {
        return sharedPreferences.edit().putString(key, String.valueOf(value)).commit();

    }

    /**
     * Store boolean in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setBoolean(String key, boolean value) {
        return sharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * Store String in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setString(String key, String value) {
        return sharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * Store Object in SharedPreference Data.
     * <p>
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setObject(String key, Object value) {
        String json = new Gson().toJson(value);
        return sharedPreferences.edit().putString(key, json).commit();
    }

    /**
     * Store Map in SharedPreference Data.
     *
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    @Override
    public boolean setMap(String key, Map value) {
        return setObject(key,value);
    }

    /**
     * @param key - key name.
     * @return True if preference value exists otherwise, false.
     */
    @Override
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * remove key from preference synchronously.
     *
     * @param key - key name to remove.
     */
    @Override
    public boolean remove(String key) {
        return sharedPreferences.edit().remove(key).commit();
    }

    /**
     * remove key from preference asynchronously.
     *
     * @param key - key name to remove.
     */
    @Override
    public void removeAsync(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    /**
     * Remove all data from this preference file synchronously.
     */
    @Override
    public boolean clear() {
        return sharedPreferences.edit().clear().commit();
    }

    /**
     * Remove all data from this preference file asynchronously.
     */
    @Override
    public void clearAsync() {
        sharedPreferences.edit().clear().apply();
    }

    /**
     * Retrieve all data of this preference file.
     */
    @Override
    public Map<String, ?> getData() {
        return sharedPreferences.getAll();
    }

    /**
     * Retrieve a String value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns "".
     */
    @Override
    public @NonNull
    String getString(String key) {
        Object value = getDefaultValue(key);
        String defaultValue = (value != null) ? String.valueOf(value) : "";
        return getString(key, defaultValue);
    }

    /**
     * Retrieve a String value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    @Override
    public String getString(String key, String defValue) {
        try {
            return sharedPreferences.getString(key, defValue);
        } catch (ClassCastException e) {
            logClassCastException(key, "String", e);
            return defValue;
        }
    }

    /**
     * Retrieve a int value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    @Override
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
                    logWrongValueException(key, "Integer", e);
                }
            } else {
                logWrongValueException(key, "Integer", new WrongValueException(value));

            }
        }
        return getInt(key, defaultValue);
    }

    /**
     * Retrieve a int value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    @Override
    public int getInt(String key, int defValue) {
        try {
            return sharedPreferences.getInt(key, defValue);
        } catch (ClassCastException e) {
            logClassCastException(key, "Int", e);
            return defValue;
        }
    }

    /**
     * Retrieve a long value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    @Override
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
                    logWrongValueException(key, "Long", e);
                }
            } else {
                logWrongValueException(key, "Long", new WrongValueException(value));
            }
        }
        return getLong(key, defaultValue);
    }

    /**
     * Retrieve a long value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return RPreference value if it exists otherwise, returns defValue.
     */
    @Override
    public long getLong(String key, long defValue) {
        try {
            return sharedPreferences.getLong(key, defValue);
        } catch (ClassCastException e) {
            logClassCastException(key, "Long", e);
            return defValue;
        }
    }

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns false.
     */
    @Override
    public boolean getBoolean(String key) {
        Object value = getDefaultValue(key);

        boolean defaultValue = false;
        if (value != null) {
            if (value instanceof Boolean) {
                defaultValue = (boolean) value;
            } else if (value instanceof String) {
                defaultValue = Boolean.parseBoolean((String) value);
            } else {
                logWrongValueException(key, "Boolean", new WrongValueException(value));
            }
        }
        return getBoolean(key, defaultValue);
    }

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    @Override
    public boolean getBoolean(String key, boolean defValue) {
        try {
            return sharedPreferences.getBoolean(key, defValue);
        } catch (ClassCastException e) {
            logClassCastException(key, "Boolean", e);
            return defValue;
        }
    }

    /**
     * Retrieve a float value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    @Override
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
                    logWrongValueException(key, "Float", e);
                }
            } else {
                logWrongValueException(key, "Float", new WrongValueException(value));
            }
        }
        return getFloat(key, defaultValue);
    }

    /**
     * Retrieve a float value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    @Override
    public float getFloat(String key, float defValue) {
        try {
            return sharedPreferences.getFloat(key, defValue);
        } catch (ClassCastException e) {
            logClassCastException(key, "Float", e);
            return defValue;
        }
    }

    /**
     * Retrieve a Object value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns null.
     */
    @Override
    @SuppressWarnings("TypeParameterUnusedInFormals")
    public @Nullable
    <T> T getObject(String key, Class classType) {
        String json = getString(key, "");
        Object value = new Gson().fromJson(json, classType);
        if (value == null) {
            return (T) getDefaultValue(key);
        }
        return (T) value;
    }

    /**
     * Retrieve a Object value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    @Override
    public <T> T getObject(String key, Class classType, T defValue) {
        String json = getString(key, "");
        Object value = new Gson().fromJson(json, classType);
        if (value == null) {
            return defValue;
        }
        return (T) value;
    }

    /**
     * Retrieve a Map value from the preferences
     *
     * @param key       - The name of the preference to retrieve.
     * @param mapType - the type of the Map -> HashMap,TreeMap..etc.
     * @param keyType   - the type of the key that used in the map.
     * @param valueType - the type of the value that used in the map.
     * @return Preference value if it exists otherwise, returns null.
     */
    @Override
    public @Nullable <T extends AbstractMap> T getMap(String key, Class<T> mapType, Class keyType, Class valueType) {
        String json = getString(key, "");

        T value = null;
        try {
            value = new Gson().fromJson(json, TypeToken.getParameterized(mapType, keyType,
                    valueType).getType());
        } catch (Exception e) {
            Log.d(TAG, "something went wrong!!", e);
        }

        if (value == null) {
            return (T) getDefaultValue(key);
        }
        return value;
    }

    /**
     * @param key       - The name of the preference to retrieve.
     * @param structure - map structure
     * @return Preference value if it exists otherwise, returns null
     */
    @Override
    public @Nullable <T extends AbstractMap> T getMap(String key, MapStructure structure) {
        String json = getString(key, "");

        T value = null;
        try {
            Type type = TypeToken.getParameterized(
                    structure.getType(),
                    structure.getKey(),
                    structure.getValue()
            ).getType();

            value = new Gson().fromJson(json, type);
        } catch (Exception e) {
            Log.d(TAG, "something went wrong!!", e);
        }

        if (value == null) {
            return (T) getDefaultValue(key);
        }
        return value;
    }

    /**
     * Retrieve a double value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    @Override
    public double getDouble(String key) {
        String string = getString(key, "");

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
                        logWrongValueException(key, "Double", e);
                    }
                } else {
                    logWrongValueException(key, "Double", new WrongValueException(defaultValue));
                }
                return defaultDouble;
            }
        }

        return value;
    }

    /**
     * Retrieve a double value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    @Override
    public double getDouble(String key, double defValue) {
        String json = getString(key, "");
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
    @Override
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
    @Override
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

    /**
     * print error exception to the console if used an invalid value type for the default key.
     *
     * @param key  - requested key
     * @param type - Integer, String ...etc
     * @param th   - exception
     */
    private void logWrongValueException(String key, String type, Throwable th) {
        Log.e(TAG, "you to must have a {" + type + "} default value!" +
                " for the key => {" + key + "}", th);
    }

    /**
     * The key have a different value that the requested.
     * <p>
     * For example if you call getInt("key") and the value of the "key" is String it will
     * throw class cast exception.
     *
     * @param key  - requested key
     * @param type - Integer, String ...etc
     * @param th   - exception
     */
    private void logClassCastException(String key, String type, Throwable th) {
        Log.e(TAG, "The value of {" + key + "} key is not a " + type + ".", th);
    }

    private static class WrongValueException extends IllegalArgumentException {
        WrongValueException(Object value) {
            super("value => {" + value + "}");
        }
    }
}
