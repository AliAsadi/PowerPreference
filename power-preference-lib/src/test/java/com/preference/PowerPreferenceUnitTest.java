package com.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PowerPreferenceUnitTest {

    private Preference preference;

    @Mock
    Context context;

    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    SharedPreferences.Editor editor;

    private final static String KEY = "key";

    //values
    private final static String STRING_VALUE = "ali";
    private final static int INT_VALUE = 1;
    private final static float FLOAT_VALUE = 1;
    private final static long LONG_VALUE = 1;
    private final static double DOUBLE_VALUE = 1;
    private final static boolean BOOLEAN_VALUE = false;
    private final static Object OBJECT_VALUE = new Object();
    private final static HashMap MAP_VALUE = new HashMap();

    @Before
    public void setUp() {

        mockContext();
        mockEditor();

        PowerPreference.init(context);

        preference = PowerPreference.getFileByName("name");
        assertNotNull(preference);
    }

    private void mockContext() {
        //cause the builder use the application context.
        when(context.getApplicationContext()).thenReturn(context);

        //return shared preference.
        when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreferences);
    }

    private void mockEditor() {
        //mock editor
        when(sharedPreferences.edit()).thenReturn(editor);

        when(editor.putInt(anyString(), anyInt())).thenReturn(editor);
        when(editor.putLong(anyString(), anyLong())).thenReturn(editor);
        when(editor.putFloat(anyString(), anyFloat())).thenReturn(editor);
        when(editor.putBoolean(anyString(), anyBoolean())).thenReturn(editor);
        when(editor.putString(anyString(), anyString())).thenReturn(editor);
        when(editor.commit()).thenReturn(true);
    }

    @Test
    public void getDefaultFileByNameTest() {
        preference = PowerPreference.getFileByName("name");
        Assert.assertNotNull(preference);
    }

    //--------------------------------------------------------//

    // PUT //
    @Test
    public void putStringTest() {
        preference.putString(KEY, STRING_VALUE);

        verify(editor).putString(KEY, STRING_VALUE);
        verify(editor).apply();
    }

    @Test
    public void putIntTest() {
        preference.putInt(KEY, INT_VALUE);

        verify(editor).putInt(KEY, INT_VALUE);
        verify(editor).apply();
    }

    @Test
    public void putFloatTest() {
        preference.putFloat(KEY, FLOAT_VALUE);

        verify(editor).putFloat(KEY, FLOAT_VALUE);
        verify(editor).apply();
    }

    @Test
    public void putDoubleTest() {
        preference.putDouble(KEY, DOUBLE_VALUE);

        verify(editor).putString(KEY, String.valueOf(DOUBLE_VALUE));
        verify(editor).apply();
    }

    @Test
    public void putLongTest() {
        preference.putLong(KEY, LONG_VALUE);

        verify(editor).putLong(KEY, LONG_VALUE);
        verify(editor).apply();
    }

    @Test
    public void putBooleanTest() {
        preference.putBoolean(KEY, BOOLEAN_VALUE);

        verify(editor).putBoolean(KEY, BOOLEAN_VALUE);
        verify(editor).apply();
    }

    @Test
    public void putObjectTest() {
        preference.putObject(KEY, OBJECT_VALUE);

        String value = new Gson().toJson(OBJECT_VALUE);
        verify(editor).putString(KEY, value);
        verify(editor).apply();
    }

    @Test
    public void putMapTest() {
        preference.putMap(KEY, MAP_VALUE);

        String value = new Gson().toJson(MAP_VALUE);
        verify(editor).putString(KEY, value);
        verify(editor).apply();
    }

    //--------------------------------------------------------//

    /// SET ///
    @Test
    public void setStringTest() {
        boolean result = preference.setString(KEY, STRING_VALUE);
        assertTrue(result);

        verify(editor).putString(KEY, STRING_VALUE);
        verify(editor).commit();
    }

    @Test
    public void setIntTest() {
        boolean result = preference.setInt(KEY, INT_VALUE);
        assertTrue(result);

        verify(editor).putInt(KEY, INT_VALUE);
        verify(editor).commit();
    }

    @Test
    public void setFloatTest() {
        boolean result = preference.setFloat(KEY, FLOAT_VALUE);
        assertTrue(result);

        verify(editor).putFloat(KEY, FLOAT_VALUE);
        verify(editor).commit();
    }

    @Test
    public void setDoubleTest() {
        boolean result = preference.setDouble(KEY, DOUBLE_VALUE);
        assertTrue(result);

        verify(editor).putString(KEY, String.valueOf(DOUBLE_VALUE));
        verify(editor).commit();
    }

    @Test
    public void setLongTest() {
        boolean result = preference.setLong(KEY, LONG_VALUE);
        assertTrue(result);

        verify(editor).putLong(KEY, LONG_VALUE);
        verify(editor).commit();
    }

    @Test
    public void setBooleanTest() {
        boolean result = preference.setBoolean(KEY, BOOLEAN_VALUE);

        verify(editor).putBoolean(KEY, BOOLEAN_VALUE);
        verify(editor).commit();
    }

    @Test
    public void setObjectTest() {
        boolean result = preference.setObject(KEY, OBJECT_VALUE);
        assertTrue(result);

        String value = new Gson().toJson(OBJECT_VALUE);
        verify(editor).putString(KEY, value);
        verify(editor).commit();
    }

    @Test
    public void setMapTest() {
        boolean result = preference.setMap(KEY, MAP_VALUE);
        assertTrue(result);

        String value = new Gson().toJson(OBJECT_VALUE);
        verify(editor).putString(KEY, value);
        verify(editor).commit();
    }

    //--------------------------------------------------------//

    // GET //
    @Test
    public void getStringTest() {
        preference.getString(KEY);
        verify(sharedPreferences).getString(KEY, "");
    }

    @Test
    public void getIntTest() {
        preference.getInt(KEY);
        verify(sharedPreferences).getInt(KEY, 0);
    }

    @Test
    public void getFloatTest() {
        preference.getFloat(KEY);
        verify(sharedPreferences).getFloat(KEY, 0);
    }

    @Test
    public void getLongTest() {
        preference.getLong(KEY);
        verify(sharedPreferences).getLong(KEY, 0);
    }

    @Test
    public void getDoubleTest() {
        double expected = 0;
        when(sharedPreferences.getString(KEY, "")).thenReturn("");
        double result = preference.getDouble(KEY);
        Assert.assertEquals(expected, result, 0);
        verify(sharedPreferences).getString(KEY, "");
    }

    @Test
    public void getBooleanTest() {
        preference.getBoolean(KEY);
        verify(sharedPreferences).getBoolean(KEY, false);
    }

    @Test
    public void getObjectTest() {
        Object result = preference.getObject(KEY, Object.class);
        verify(sharedPreferences).getString(KEY, "");
        assertNull(result);
    }

    @Test
    public void getMapTest() {
        MapStructure structure = MapStructure.create(HashMap.class, Object.class, Object.class);
        HashMap result = preference.getMap(KEY, structure);

        verify(sharedPreferences).getString(KEY, "");
        assertNull(result);
    }

    //--------------------------------------------------------//

    // GET - With Default //
    @Test
    public void getStringWithDefaultTest() {
        preference.getString(KEY, STRING_VALUE);
        verify(sharedPreferences).getString(KEY, STRING_VALUE);
    }

    @Test
    public void getIntWithDefaultTest() {
        preference.getInt(KEY, INT_VALUE);
        verify(sharedPreferences).getInt(KEY, INT_VALUE);
    }

    @Test
    public void getFloatWithDefaultTest() {
        preference.getFloat(KEY, FLOAT_VALUE);
        verify(sharedPreferences).getFloat(KEY, FLOAT_VALUE);
    }

    @Test
    public void getLongWithDefaultTest() {
        preference.getLong(KEY, LONG_VALUE);
        verify(sharedPreferences).getLong(KEY, LONG_VALUE);
    }

    @Test
    public void getDoubleWithDefaultTest() {
        double result = preference.getDouble(KEY, DOUBLE_VALUE);
        verify(sharedPreferences).getString(KEY, "");
        Assert.assertEquals(DOUBLE_VALUE, result, 0);
    }

    @Test
    public void getObjectWithDefaultTest() {
        Object result = preference.getObject(KEY, Object.class, OBJECT_VALUE);
        verify(sharedPreferences).getString(KEY, "");
        Assert.assertEquals(OBJECT_VALUE, result);
    }

    @Test
    public void getBooleanWithDefaultTest() {
        preference.getBoolean(KEY, BOOLEAN_VALUE);
        verify(sharedPreferences).getBoolean(KEY, BOOLEAN_VALUE);
    }


}