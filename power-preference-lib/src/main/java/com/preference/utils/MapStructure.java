package com.preference.utils;

/**
 * Created by Ali Asadi on 19/08/2019.
 */
public class MapStructure {

    private Class type;
    private Class key;
    private Class value;

    private MapStructure(Class type, Class key, Class value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    /**
     * For example HashMap<String,Object>
     *
     * type  = HashMap.class
     * key   = String.class
     * value = Object.class
     *
     * @param type  - map type (HashMap, TreeMap...etc)
     * @param key   - map key
     * @param value - map value
     */
    public static MapStructure create(Class type, Class key, Class value) {
        return new MapStructure(type, key, value);
    }

    public Class getType() {
        return type;
    }

    public Class getKey() {
        return key;
    }

    public Class getValue() {
        return value;
    }
}
