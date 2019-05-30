
# Power Preference

A Powerful library to control and simplify the usage of shared preference in Android.

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Android--Power--Preference-green.svg?style=flat )]( https://android-arsenal.com/details/1/7353 ) [ ![Download](https://api.bintray.com/packages/aliassadi/maven/power-preference-lib/images/download.svg) ](https://bintray.com/aliassadi/maven/power-preference-lib/_latestVersion)

# Download

```gradle
implementation 'com.aliassadi:power-preference-lib:1.4.1'
```

# Getting started

To accsess preference file there is two option:

1. Default file.

```java
Preference preference = PowerPreference.getDefaultFile();
```
2. Specefic file.
```java
Preference preference = PowerPreference.getFileByName("preferenceName");
```

## Save Data - Asynchronous(PUT)

To write data to preference file **asynchronous**.

1. Insert single value
```java
PowerPreference.getDefaultFile().put("key",value);
```

2. Insert multiple values

```java
PowerPreference.getDefaultFile()
        .put("key", value)
        .put("key", value)
              .
              .
        .put("key", value);
```

Put will asynchronously save the preferences without holding the current thread.

The library support the default implementation of shared preference such as `putBoolean()` and `putString()`.

### Note:
You can write any type of data **Integer, Long, Float, Double, String, ArrayList, Map, Object**


## Save Data - Synchronous(SET)
To write data to preference file **synchronous**.

Set will synchronously save the preference while holding the current 
thread until done and returning a success flag.

```java
boolean result = PowerPreference.getDefaultFile().set("key",value);
```

You can also call set with the type such as `setBoolean()` and `setString()`.

## Read Data

To retrieve values from a preference file, call methods such as `getInt()` and `getString()`, 

1. **String**
```java
String value = PowerPreference.getDefaultFile().getString("key", defaultValue);
```

2. **Object**
```java
Object value = PowerPreference.getDefaultFile().getObject("key", Object.class, defaultValue);
```

3. **Array**
```java
ArrayList<Object> value = PowerPreference.getDefaultFile().getObject("key", Object[].class, defaultValue);
```

4. **Map**
```java
HashMap<String, Object> value = PowerPreference.getDefaultFile().getMap("key", HashMap.class, String.class, Object.class);
```

### Note:

You can getting a value with out pass a `defaultValue` the library well return a default from the list if the key not exist.

```java
String value = PowerPreference.getDefaultFile().getString("key");
```
If the key dosn't exist the library will return an empty string.

| Type | Default |
| --- | --- |
| Integer, Long, Float, Double | 0 |
| String | "" |
| Object | null |

You also can choose a default value for each key in you preference file by ``seDefaults()`` method see the defaults section for more.

## Clear Data
1. Clear data from specefic file
```java
PowerPreference.getDefaultFile().clear();
```
2. Clear data from all files
```java
PowerPreference.getAllData()
```

## Remove Data
```java
PowerPreference.getDefaultFile().remove("key");
```

## Get Data

1. Get all data from specefic file
```java
Map<String, ?> fileData = PowerPreference.getDefaultFile().getData();
```

2. Get all data from all files in the app.
```java
List<PreferenceObject> appData = PowerPreference.getAllData()
```


# Default Values

Set Default value to be used when reading from shared preference,
You can use a different defaults value for every preference file.

There is two option using:
1. XML
```xml
<?xml version="1.0" encoding="utf-8"?>
<defaultMap>
    <entry>
        <key>key</key>
        <value>true</value>
    </entry>

    <entry>
        <key>key</key>
        <value>Hello World!</value>
    </entry>
    
    <entry>
        <key>key</key>
        <value>5</value>
    </entry>
    
    //...etc
    
</defaultMap>
```

```java
PowerPreference.getDefaultFile().setDefaults(R.xml.preferences_defaults)
```

2. HashMap

```java
Map<String, Object> defaults = new HashMap<>();
defaults.put("key", true);
defaults.put("key", "Hello World!");
defaults.put("key", 123);
defaults.put("key", 111L);
defaults.put("key", 1.1f);
defaults.put("key", 1.111d);
defaults.put("key", new Object());
```


```java
PowerPreference.getDefaultFile().setDefaults(hashMap);
```


# Preference Debbuger 

By preference debugger you can show all the preference in all the file in your app simply by calling.

```java
PowerPreference.showDebugScreen();
```

<p align="center">
  <img src="https://github.com/AliAsadi/PowerPreference/blob/master/screenshot/debug-screen.png" width="300" title="screen">
  <img src="https://github.com/AliAsadi/PowerPreference/blob/master/screenshot/edit-value.png" width="300" title="edot">
</p>


### License
```
Copyright 2018 Ali Asadi.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
