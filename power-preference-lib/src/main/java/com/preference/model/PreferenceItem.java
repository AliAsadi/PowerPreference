package com.preference.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ali Asadi on 19/11/2018.
 */
public class PreferenceItem implements Parcelable {

    public String fileName;
    public String key;
    public Object value ="";
    public PreferenceType type;

    /**
     * @param key - The key of the preference.
     * @param value - The value of the preference
     * @param fileName - In which file the preference exist (defaultFile, Users ...etc)
     * @param type - the type of the preference (Boolean, String, Long ...etc)
     */
    public PreferenceItem(String key, Object value, String fileName, PreferenceType type) {
        this.key = key;
        this.value = value;
        this.fileName = fileName;
        this.type = type;
    }

    protected PreferenceItem(Parcel in) {
        key = in.readString();
    }

    public static final Creator<PreferenceItem> CREATOR = new Creator<PreferenceItem>() {
        @Override
        public PreferenceItem createFromParcel(Parcel in) {
            return new PreferenceItem(in);
        }

        @Override
        public PreferenceItem[] newArray(int size) {
            return new PreferenceItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
    }
}