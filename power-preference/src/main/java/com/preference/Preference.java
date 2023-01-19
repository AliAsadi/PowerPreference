package com.preference;

import androidx.annotation.XmlRes;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by Ali Asadi on 12/01/2019.
 */
public interface Preference {

    /**
     * Store int in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putInt(String key, int value);

    /**
     * Store long in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putLong(String key, long value);

    /**
     * Store float in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putFloat(String key, float value);

    /**
     * Store double in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putDouble(String key, double value);

    /**
     * Store boolean in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putBoolean(String key, boolean value);

    /**
     * Store String in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putString(String key, String value);

    /**
     * Store Object in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putObject(String key, Object value);

    /**
     * Store Map in SharedPreference Data.
     *
     * Writes the data asynchronously
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return A reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putMap(String key, Map value);

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
    boolean setInt(String key, int value);

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
    boolean setLong(String key, long value);

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
    boolean setFloat(String key, float value);

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
    boolean setDouble(String key, double value);

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
    boolean setBoolean(String key, boolean value);

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
    boolean setString(String key, String value);

    /**
     * Store Object in SharedPreference Data.
     *
     * Writes the data synchronously (blocking the thread its called from).
     * It then informs you about the success of the operation
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return True if the save works, false otherwise.
     */
    boolean setObject(String key, Object value);

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
    boolean setMap(String key, Map value);

    /**
     * Retrieve a String value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns "".
     */
    String getString(String key);

    /**
     * Retrieve a String value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    String getString(String key, String defValue);

    /**
     * Retrieve a int value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    int getInt(String key);

    /**
     * Retrieve a int value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    int getInt(String key, int defValue);

    /**
     * Retrieve a long value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    long getLong(String key);

    /**
     * Retrieve a long value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return RPreference value if it exists otherwise, returns defValue.
     */
    long getLong(String key, long defValue);

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns false.
     */
    boolean getBoolean(String key);

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    boolean getBoolean(String key, boolean defValue);

    /**
     * Retrieve a float value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    float getFloat(String key);

    /**
     * Retrieve a float value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    float getFloat(String key, float defValue);

    /**
     * Retrieve a Object value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns null.
     */
    @SuppressWarnings("TypeParameterUnusedInFormals")
    <T> T getObject(String key, Class classType);

    /**
     * Retrieve a Object value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    <T> T getObject(String key, Class classType, T defValue);

    /**
     * Retrieve a Map value from the preferences
     *
     * @param key       - The name of the preference to retrieve.
     * @param mapType - the type of the Map -> HashMap,TreeMap..etc.
     * @param keyType   - the type of the key that used in the map.
     * @param valueType - the type of the value that used in the map.
     * @return Preference value if it exists otherwise, returns null.
     */
    @Deprecated
    <T extends AbstractMap> T getMap(String key, Class<T> mapType, Class keyType, Class valueType);

    /**
     * @param key       - The name of the preference to retrieve.
     * @param structure - map structure
     * @return Preference value if it exists otherwise, returns null
     */
    <T extends AbstractMap> T getMap(String key, MapStructure structure);

    /**
     * Retrieve a double value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Preference value if it exists otherwise, returns 0.
     */
    double getDouble(String key);

    /**
     * Retrieve a double value from the preferences
     *
     * @param key      - The name of the preference to retrieve.
     * @param defValue - Value to return if this preference does not exist.
     * @return Preference value if it exists otherwise, returns defValue.
     */
    double getDouble(String key, double defValue);

    /**
     * @param key - key name.
     * @return True if preference value exists otherwise, false.
     */
    boolean contains(String key);

    /**
     * remove key from preference synchronously.
     *
     * @param key - key name to remove.
     */
    boolean remove(String key);

    /**
     * remove key from preference asynchronously.
     *
     * @param key - key name to remove.
     */
    void removeAsync(String key);

    /**
     * Remove all data from this preference file synchronously.
     */
    boolean clear();

    /**
     * Remove all data from this preference file asynchronously.
     */
    void clearAsync();

    /**
     * Retrieve all data of this preference file.
     */
    Map<String, ?> getData();

    /**
     * Set defaults value fo this preference file.
     * defaults will uses when use one of the method getString, getInt...etc, and there is no value
     * for the key you entered then the library will use this default value.
     *
     * @param defaultValues - map.
     */
    void setDefaults(Map<String, Object> defaultValues);

    /**
     * Set defaults value fo this preference file.
     * <p>
     * defaults will uses when use one of the method getString, getInt...etc, and there is no value
     * for the key you entered then the library will use this default value.
     *
     * @param xml - xml.
     */
    void setDefaults(@XmlRes int xml);
}
