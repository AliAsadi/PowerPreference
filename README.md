
# Android Power Preference

A Powerful library to control and simplify the usage of shared preference in Android.

<p align="center">
  <img src="https://i.imgur.com/hjMxQo1.png" title="screen">
</p>

# Download

```gradle
implementation 'com.aliassadi:power-preference-lib:1.3.0'
```

## Getting started

To accsess shared preference there is two option using:

1. Default share preference.
2. Specefic shared preference file by name.

```java
PowerPreference.defult();
```
OR
```java
PowerPreference.name("sampleName");
```



## PUT - Write to shared preferences

To Write data to shared preference 

### Support 
* int, long, float, double, String, Object.


```java
PowerPreference.defult().put("key",value);
```
OR
```java
PowerPreference.name("sampleName").put("key",value);
```

Also 

```java
PowerPreference.defult()
        .put("boolean", true)
        .put("string", "Hello World!")
        .put("int", 123)
        .put("long", 111L)
        .put("float", 1.1f)
        .put("double", 1.111d)
        .put("object", new Object());
              
```

The library support the default implementation of shared preference
```java
PowerPreference.defult()
        .putBoolean("boolean", true)
        .putString("string", "Hello World!")
        .putInt("int", 123)
        .putLong("long", 111L)
        .putFloat("float", 1.1f)
        .putDouble("double", 1.111d)
        .putObject("object", new Object());
              
```

## DEFAUTLS - Set  default parameter values

Set Default value to be used when reading from shared preference,
You can use a different defaults value for every preference file.

There is two option using:
1. XML

```java
PowerPreference.defult().setDefaults(R.xml.preferences_defaults)
```

2. HashMap
```java
PowerPreference.defult().setDefaults(hashMap);
```

## Examples:

### XML:

```xml
<?xml version="1.0" encoding="utf-8"?>
<defaultMap>
    <entry>
        <key>boolean</key>
        <value>true</value>
    </entry>

    <entry>
        <key>string</key>
        <value>Hello World!</value>
    </entry>
    
    <entry>
        <key>int</key>
        <value>5</value>
    </entry>
    
    //...etc
    
</defaultMap>
```

### HashMap:

```java
Map<String, Object> defaults = new HashMap<>();
defaults.put("boolean", true);
defaults.put("string", "Hello World!");
defaults.put("int", 123);
defaults.put("long", 111L);
defaults.put("float", 1.1f);
defaults.put("double", 1.111d);
defaults.put("object", new Object());
```

# GET - Read from shared preferences

Getting value by key if the value dosn't exist the library will get the value from our defaults that we have declere in `seDefaults`,
otherwise the library will return a default value from the library defaults.

#### library default values
* int, long, float, double -> 0
* String -> ""
* Object -> null

```java
PowerPreference.defult().getBoolean("boolean");
PowerPreference.defult().getString("string");
PowerPreference.defult().getInt("int");
PowerPreference.defult().getLong("long");
PowerPreference.defult().getFloat("float");
PowerPreference.defult().getDouble("double");
PowerPreference.defult().getObject("object", Object.class);
```

Or you can use it as usual with a default value.
```java
PowerPreference.defult().getBoolean("boolean", defaultValue);
PowerPreference.defult().getString("string", defaultValue);
PowerPreference.defult().getInt("int", defaultValue);
PowerPreference.defult().getLong("long", defaultValue);
PowerPreference.defult().getFloat("float", defaultValue);
PowerPreference.defult().getDouble("double", defaultValue);
PowerPreference.defult().getObject("object", Object.class, defaultValue);
```

# Other

```java
PowerPreference.defult().clear(); //OR - PowerPreference.name("sampleName").clear();
PowerPreference.defult().remove("key");
PowerPreference.defult().contains("key");
PowerPreference.defult().getData(");
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
Copyright 2017 Ali Esa Assadi.

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
