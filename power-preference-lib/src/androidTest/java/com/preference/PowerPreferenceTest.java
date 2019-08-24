package com.preference;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.preference.model.PreferenceFile;
import com.preference.model.PreferenceItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class PowerPreferenceTest {

    private Preference preference;

    private final static String KEY = "key";

    private final String STRING_VALUE = "ali";
    private final int INT_VALUE = 10;
    private final float FLOAT_VALUE = 1.5f;
    private final long LONG_VALUE = 47777;
    private final double DOUBLE_VALUE = 12.222D;
    private final boolean BOOLEAN_VALUE = true;
    private final SampleObject OBJECT_VALUE = new SampleObject();
    private final HashMap<String, String> MAP_VALUE = getHashMap();

    private final Context context = InstrumentationRegistry.getInstrumentation().getContext();

    private static HashMap<String, String> getHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("firstName", "ali");
        hashMap.put("lastName", "asadi");
        return hashMap;
    }

    @Before
    public void setUp() {

        PowerPreference.init(context);

        logCurrentData();
        PowerPreference.clearAllData();

        preference = PowerPreference.getDefaultFile();
    }

    ///////////// SET  /////////////

    @Test
    public void setStringTest() {
        preference.setString("key", STRING_VALUE);
        assertEquals(preference.getString("key"), STRING_VALUE);
    }

    @Test
    public void setIntTest() {
        preference.setInt(KEY, INT_VALUE);
        assertEquals(preference.getInt(KEY), INT_VALUE);
    }

    @Test
    public void setLongTest() {
        preference.setLong(KEY, LONG_VALUE);
        assertEquals(preference.getLong(KEY), LONG_VALUE, 0);
    }

    @Test
    public void setFloatTest() {
        preference.setFloat(KEY, FLOAT_VALUE);
        assertEquals(preference.getFloat(KEY), FLOAT_VALUE, 0);
    }

    @Test
    public void setDoubleTest() {
        preference.setDouble(KEY, DOUBLE_VALUE);
        assertEquals(preference.getDouble(KEY), DOUBLE_VALUE, 0);
    }

    @Test
    public void setBooleanTest() {
        preference.setBoolean(KEY, BOOLEAN_VALUE);
        assertEquals(preference.getBoolean(KEY), BOOLEAN_VALUE);
    }

    @Test
    public void setObjectTest() {
        preference.setObject(KEY, OBJECT_VALUE);
        SampleObject sampleObject = preference.getObject(KEY, SampleObject.class);
        assertEquals(sampleObject, OBJECT_VALUE);
    }

    @Test
    public void setMapTest() {
        preference.setMap(KEY, MAP_VALUE);
        MapStructure structure = MapStructure.create(HashMap.class, String.class, String.class);
        assertEquals(preference.getMap(KEY, structure), MAP_VALUE);
    }

    ///////////// GET  /////////////

    @Test
    public void getStringTest() {
        String defValue = "valueTest";
        assertEquals(preference.getString(KEY, defValue), defValue);
        assertEquals(preference.getString(KEY), "");
    }

    @Test
    public void getIntTest() {
        int defValue = 23123;
        assertEquals(preference.getInt(KEY, defValue), defValue);
        assertEquals(preference.getInt(KEY), 0);
    }

    @Test
    public void getLongTest() {
        long defValue = 890891;
        assertEquals(preference.getLong(KEY, defValue), defValue, 0);
        assertEquals(preference.getLong(KEY), 0, 0);
    }

    @Test
    public void getFloatTest() {
        float defValue = 1122.55f;
        assertEquals(preference.getFloat(KEY, defValue), defValue, 0);
        assertEquals(preference.getFloat(KEY), 0, 0);
    }

    @Test
    public void getDoubleTest() {
        double defValue = 757722.55;
        assertEquals(preference.getDouble(KEY, defValue), defValue, 0);
        assertEquals(preference.getDouble(KEY), 0, 0);
    }

    @Test
    public void getBooleanTest() {
        assertTrue(preference.getBoolean(KEY, true));
        assertFalse(preference.getBoolean(KEY));
    }

    @Test
    public void getObjectTest() {
        SampleObject defValue = new SampleObject();
        assertEquals(preference.getObject(KEY, Object.class, defValue), defValue);
        assertNull(preference.getObject(KEY, Object.class));
    }

    @Test
    public void getMapTest() {
        MapStructure structure = MapStructure.create(HashMap.class, String.class, String.class);
        assertNull(preference.getMap(KEY, structure));
    }

    @Test
    public void getHashMap_String_String_Test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");

        preference.setMap(KEY, map);

        MapStructure structure = MapStructure.create(HashMap.class, String.class, String.class);
        HashMap<String, String> mapResult = preference.getMap(KEY, structure);

        assertNotNull(mapResult);
        for (String value : mapResult.values()) assertNotNull(value);
        for (String key : mapResult.keySet()) assertNotNull(key);
    }

    @Test
    public void getHashMap_String_SampleObject_Test() {
        HashMap<String, SampleObject> map = new HashMap<>();
        map.put("key", new SampleObject());

        preference.setMap(KEY, map);

        MapStructure structure = MapStructure.create(HashMap.class, String.class, SampleObject.class);
        HashMap<String, SampleObject> mapResult = preference.getMap(KEY, structure);

        assertEquals(mapResult.getClass().getSimpleName(), "HashMap");
        for (String key : mapResult.keySet()) assertNotNull(key);
        for (SampleObject value : mapResult.values()) assertNotNull(value);
    }

    @Test
    public void getHashMap_Long_ArrayList_Test() {
        HashMap<Long, ArrayList> map = new HashMap<>();
        map.put(1231L, new ArrayList<>());

        preference.setMap(KEY, map);

        MapStructure structure = MapStructure.create(HashMap.class, Long.class, ArrayList.class);
        HashMap<Long, ArrayList> mapResult = preference.getMap(KEY, structure);

        assertEquals(mapResult.getClass().getSimpleName(), "HashMap");
        for (Long key : mapResult.keySet()) assertNotNull(key);
        for (ArrayList value : mapResult.values()) assertNotNull(value);
    }

    @Test
    public void getDataTest() {
        preference.setString("key1", STRING_VALUE);
        preference.setString("key2", STRING_VALUE);
        preference.setString("key3", STRING_VALUE);

        Map<String, ?> data = preference.getData();
        assertEquals(data.size(), 3);

        for (Object values : data.values()) {
            assertEquals(values, STRING_VALUE);
        }
    }

    @Test
    public void getAllDataTest() {
        PowerPreference.getDefaultFile().setString(KEY, STRING_VALUE);
        PowerPreference.getFileByName("TestFile").setString(KEY, STRING_VALUE);
        PowerPreference.getFileByName("AnotherFile").setString(KEY, STRING_VALUE);

        List<PreferenceFile> data = PowerPreference.getAllData();
        assertEquals(data.size(), 3);

        for (PreferenceFile file : data) {
            for (PreferenceItem item : file.items) {
                assertEquals(item.key, KEY);
            }
        }
    }

    ///////////// Clear  /////////////

    @Test
    public void removeTest() {
        preference.setString(KEY, "value");
        assertTrue(preference.contains(KEY));

        preference.remove(KEY);
        assertFalse(preference.contains(KEY));
    }

    @Test
    public void removeAsyncTest() {
        preference.setString(KEY, "value");
        assertTrue(preference.contains(KEY));

        preference.removeAsync(KEY);
        SystemClock.sleep(50);
        assertFalse(preference.contains(KEY));
    }

    @Test
    public void clearFileTest() {
        preference.setString("key1", STRING_VALUE);
        preference.setString("key2", STRING_VALUE);

        assertEquals(preference.getData().size(), 2);

        preference.clear();

        assertEquals(preference.getData().size(), 0);
    }

    @Test
    public void clearFileAsyncTest() {
        preference.setString("key1", STRING_VALUE);
        preference.setString("key2", STRING_VALUE);

        assertEquals(preference.getData().size(), 2);

        preference.clearAsync();
        SystemClock.sleep(50);

        assertEquals(preference.getData().size(), 0);
    }

    @Test
    public void clearAllDataTest() {
        PowerPreference.getDefaultFile().setString("key1", STRING_VALUE);
        PowerPreference.getFileByName("TestFile").setString("key2", STRING_VALUE);

        assertEquals(PowerPreference.getAllData().size(), 2);

        PowerPreference.clearAllData();

        assertEquals(PowerPreference.getAllData().size(), 0);
    }

    @Test
    public void clearAllDataAsyncTest() {
        PowerPreference.getDefaultFile().setString("key1", STRING_VALUE);
        PowerPreference.getFileByName("TestFile").setString("key2", STRING_VALUE);

        assertEquals(PowerPreference.getAllData().size(), 2);

        PowerPreference.clearAllDataAsync();
        SystemClock.sleep(50);

        assertEquals(PowerPreference.getAllData().size(), 0);
    }

    @Test
    public void containsTest() {
        preference.setString(KEY, STRING_VALUE);
        assertTrue(preference.contains(KEY));
    }

    @After
    public void printLog() {
        logCurrentData();
    }

    private void logCurrentData() {
        Log.d("PowerPreferenceTest", "data -> " + PowerPreference.getDefaultFile().getData().toString());
    }
}
