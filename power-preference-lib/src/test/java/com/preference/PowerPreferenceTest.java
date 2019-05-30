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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PowerPreferenceTest {

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

    @Before
    public void setUp() {

        mockContext();
        mockEditor();

        PowerPreference.setSingletonInstance(new PowerPreference.Builder(context).build());

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
        preference.put(KEY, STRING_VALUE);

        verify(editor, times(2)).putString(KEY, STRING_VALUE);
        verify(editor, times(2)).apply();
    }

    @Test
    public void putIntTest() {
        preference.putInt(KEY, INT_VALUE);
        preference.put(KEY, INT_VALUE);

        verify(editor, times(2)).putInt(KEY, INT_VALUE);
        verify(editor, times(2)).apply();
    }

    @Test
    public void putFloatTest() {
        preference.putFloat(KEY, FLOAT_VALUE);
        preference.put(KEY, FLOAT_VALUE);

        verify(editor, times(2)).putFloat(KEY, FLOAT_VALUE);
        verify(editor, times(2)).apply();
    }

    @Test
    public void putDoubleTest() {
        preference.putDouble(KEY, DOUBLE_VALUE);
        preference.put(KEY, DOUBLE_VALUE);

        verify(editor, times(2)).putString(KEY, String.valueOf(DOUBLE_VALUE));
        verify(editor, times(2)).apply();
    }

    @Test
    public void putLongTest() {
        preference.putLong(KEY, LONG_VALUE);
        preference.put(KEY, LONG_VALUE);

        verify(editor, times(2)).putLong(KEY, LONG_VALUE);
        verify(editor, times(2)).apply();
    }

    @Test
    public void putBooleanTest() {
        preference.putBoolean(KEY, BOOLEAN_VALUE);
        preference.put(KEY, BOOLEAN_VALUE);

        verify(editor, times(2)).putBoolean(KEY, BOOLEAN_VALUE);
        verify(editor, times(2)).apply();
    }

    @Test
    public void putObjectTest() {
        preference.putObject(KEY, OBJECT_VALUE);
        preference.put(KEY, OBJECT_VALUE);

        String value = new Gson().toJson(OBJECT_VALUE);
        verify(editor, times(2)).putString(KEY, value);
        verify(editor, times(2)).apply();
    }

    //--------------------------------------------------------//

    /// SET ///
    @Test
    public void setStringTest() {
        when(editor.commit()).thenReturn(true);
        boolean b = preference.setString(KEY, STRING_VALUE);
        boolean b2 = preference.set(KEY, STRING_VALUE);

        verify(editor, times(2)).putString(KEY, STRING_VALUE);
        verify(editor, times(2)).commit();
    }

    @Test
    public void setIntTest() {
        boolean b = preference.setInt(KEY, INT_VALUE);
        boolean b2 = preference.set(KEY, INT_VALUE);

        verify(editor, times(2)).putInt(KEY, INT_VALUE);
        verify(editor, times(2)).commit();
    }

    @Test
    public void setFloatTest() {
        boolean b = preference.setFloat(KEY, FLOAT_VALUE);
        boolean b2 = preference.set(KEY, FLOAT_VALUE);

        verify(editor, times(2)).putFloat(KEY, FLOAT_VALUE);
        verify(editor, times(2)).commit();
    }

    @Test
    public void setDoubleTest() {
        boolean b = preference.setDouble(KEY, DOUBLE_VALUE);
        boolean b2 = preference.set(KEY, DOUBLE_VALUE);

        verify(editor, times(2)).putString(KEY, String.valueOf(DOUBLE_VALUE));
        verify(editor, times(2)).commit();
    }

    @Test
    public void setLongTest() {
        boolean b = preference.setLong(KEY, LONG_VALUE);
        boolean b2 = preference.set(KEY, LONG_VALUE);

        verify(editor, times(2)).putLong(KEY, LONG_VALUE);
        verify(editor, times(2)).commit();
    }

    @Test
    public void setBooleanTest() {
        boolean b = preference.setBoolean(KEY, BOOLEAN_VALUE);
        boolean b2 = preference.set(KEY, BOOLEAN_VALUE);

        verify(editor, times(2)).putBoolean(KEY, BOOLEAN_VALUE);
        verify(editor, times(2)).commit();
    }

    @Test
    public void setObjectTest() {
        boolean b = preference.setObject(KEY, OBJECT_VALUE);
        boolean b2 = preference.set(KEY, OBJECT_VALUE);

        String value = new Gson().toJson(OBJECT_VALUE);
        verify(editor, times(2)).putString(KEY, value);
        verify(editor, times(2)).commit();
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
    public void getObjectTest() {
        Object result = preference.getObject(KEY, Object.class);
        verify(sharedPreferences).getString(KEY, "");
        assertNull(result);
    }

    @Test
    public void getBooleanTest() {
        preference.getBoolean(KEY);
        verify(sharedPreferences).getBoolean(KEY, false);
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