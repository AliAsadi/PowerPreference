package com.preference;

import android.support.annotation.XmlRes;

import com.preference.utils.WrongValueException;

import java.util.Map;

/**
 * Created by Ali Esa Assadi on 12/01/2019.
 */
public interface Preference {

    //////////////////// PUT /////////////////////////

    /**
     * Store int in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, int value);

    /**
     * Store long in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, long value);

    /**
     * Store float in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, float value);

    /**
     * Store double in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, double value);

    /**
     * Store boolean in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, boolean value);

    /**
     * Store String in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, String value);

    /**
     * Store Object in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference put(String key, Object value);

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
    boolean set(String key, int value);

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
    boolean set(String key, long value);

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
    boolean set(String key, float value);

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
    boolean set(String key, double value);

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
    boolean set(String key, boolean value);

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
    boolean set(String key, String value);

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
    boolean set(String key, Object value);

    /**
     * Store int in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putInt(String key, int value);

    /**
     * Store long in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putLong(String key, long value);

    /**
     * Store float in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putFloat(String key, float value);

    /**
     * Store double in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putDouble(String key, double value);

    /**
     * Store boolean in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putBoolean(String key, boolean value);

    /**
     * Store String in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putString(String key, String value);

    /**
     * Store Object in SharedPreference Data.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @return a reference to the same {@link Preference} object, so you can
     * chain put calls together.
     */
    Preference putObject(String key, Object value);

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
    boolean setInt(String key, int value);

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
    boolean setLong(String key, long value);

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
    boolean setFloat(String key, float value);

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
    boolean setDouble(String key, double value);

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
    boolean setBoolean(String key, boolean value);

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
    boolean setString(String key, String value);

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
    boolean setObject(String key, Object value);

    //////////////////// GET /////////////////////////

    /**
     * Retrieve a String value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@value ""} empty string.
     */
    String getString(String key);

    String getString(String key, String defValue);

    /**
     * Retrieve a int value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    int getInt(String key);

    int getInt(String key, int defValue);

    /**
     * Retrieve a long value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    long getLong(String key);

    long getLong(String key, long defValue);

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain false}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    boolean getBoolean(String key);

    boolean getBoolean(String key, boolean defValue);

    /**
     * Retrieve a float value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain 0}.
     * @throws WrongValueException print error exception to the console if used
     *                             an invalid value type for the default key.
     */
    float getFloat(String key);

    float getFloat(String key, float defValue);

    <T> T getObject(String key, Class classType, T defValue);

    /**
     * Retrieve a Object value from the preferences
     *
     * @param key - The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * <p>
     * if preference value did'nt exists and defValue didn't exists will return {@linkplain null}.
     */
    <T> T getObject(String key, Class classType);

    /**
     * Retrieve a Map value from the preferences
     *
     * @param key       - The name of the preference to retrieve.
     * @param classType - the type of the Map -> HashMap,TreeMap..etc.
     * @param keyType   - the type of the key that used in the map.
     * @param valueType - the type of the value that used in the map.
     * @return Returns the preference value if it exists, or null.
     */
    <T> T getMap(String key, Class classType, Class keyType, Class valueType);

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
    double getDouble(String key);

    double getDouble(String key, double defValue);

    //////////////////// OTHER /////////////////////////

    /**
     * @param key - key name.
     * @return Returns true if the preference exists in the preferences,
     * otherwise false.
     */
    boolean contains(String key);

    /**
     * remove key from preference.
     *
     * @param key - key name to remove.
     */
    void remove(String key);

    /**
     * remove all data from this preference.
     */
    void clear();

    Map<String, ?> getData();

    //////////////////// DEFAULTS /////////////////////////

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
