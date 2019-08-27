package com.preference;

import androidx.annotation.Nullable;

public class SampleObject {
    private int id = 123;

    @Override
    public boolean equals(@Nullable Object obj) {
        SampleObject other = (SampleObject) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
