
# Android Power Preference

A Powerful library to control and simplify the usage of shared preference in Android.

<p align="center">
  <img src="https://i.imgur.com/hjMxQo1.png" title="screen">
</p>

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Android--Power--Preference-green.svg?style=flat )]( https://android-arsenal.com/details/1/7353 ) [ ![Download](https://api.bintray.com/packages/aliassadi/maven/power-preference-lib/images/download.svg) ](https://bintray.com/aliassadi/maven/power-preference-lib/_latestVersion)

# Download

```gradle
implementation 'com.aliassadi:power-preference-lib:1.3.3'
```

## Getting started

To accsess preference there is two option using:

1. Default share preference.

```java
Preference defult = PowerPreference.defult();
```
2. Specefic preference file by name.
```java
Preference preferenceName = PowerPreference.name("preferenceName");
```


## PUT - Write to shared preferences

To Write data to shared preference 

* Support -> Int, Long, Float, Double, String, ArrayList, Map, Object.


```java
PowerPreference.defult().put("key",value);
```

Inserting multiple values

```java
PowerPreference.defult()
        .put("key", value)
        .put("key", value)
              .
              .
        .put("key", value);
```

The library support the default implementation of shared preference such as `putBoolean()` and `putString()`.

# GET - Read from shared preferences

To retrieve values from a shared preferences file, call methods such as `getInt()` and `getString()`, 

```java
String value = PowerPreference.defult().getString("key", defaultValue);
```

Retrive Object:
```java
Object value = PowerPreference.defult().getObject("key", Object.class, defaultValue);
```

Retrive Array Of Objects:
```java
Object value = PowerPreference.defult().getObject("key", Object[].class, defaultValue);
```

Retrive Map:
```java
HashMap<String, Object> value = PowerPreference.defult().getMap("key", HashMap.class, String.class, Object.class);
```

You can getting a value with out pass a `defaultValue` the library well retrive a default see the example above

#### Library default values
* Int, Long, Float, Double = 0
* String = ""
* Object = null

```java
String value = PowerPreference.defult().getString("key");
//If the key dosn't exist the library will return a default value from list in this case an empty string.
```

You also can choose a default value for each key in you preference file by ``seDefaults()`` method see the defaults section for more.

## DEFAUTLS - Set  default parameter values

Set Default value to be used when reading from shared preference,
You can use a different defaults value for every preference file.

There is two option using:
1. XML
2. HashMap

## Examples:

### XML:

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
PowerPreference.defult().setDefaults(R.xml.preferences_defaults)
```

### HashMap:

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
PowerPreference.defult().setDefaults(hashMap);
```

# Other

```java
PowerPreference.defult().clear();
PowerPreference.defult().remove("key");
PowerPreference.defult().contains("key");
PowerPreference.defult().getData("key");
```

For all preference in the app.
```java
PowerPreference.getData()
PowerPreference.clearAll()
```


# Preference Debbuger 

By preference debugger you can show all the preference in all the file in your app simply by calling.

```java
PowerPreference.showPreferenceScreen(true) //true - describe if the value is editable
```

<p align="center">
  <img src="https://i.imgur.com/OGUmLzW.png" width="300" title="screen">
  <img src="https://i.imgur.com/FEVCtrK.png" width="300" title="edot">
</p>


### License
```
Copyright 2018 Ali Esa Assadi.

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
