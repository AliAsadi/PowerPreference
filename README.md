
# Power Preference

A Powerful library to control and simplify the usage of shared preference in Android.

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-PowerPreference-green.svg?style=flat )]( https://android-arsenal.com/details/1/7353 ) 
![Travis](https://travis-ci.com/AliAsadi/PowerPreference.svg?branch=master)
[ ![Download](https://jitpack.io/v/AliAsadi/PowerPreference.svg)](https://jitpack.io/#AliAsadi/PowerPreference) 



# Download

Step 1. Add the JitPack repository to your build file
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Step 2. Add the dependency
```gradle
implementation 'com.github.AliAsadi:PowerPreference:2.0.0'
```

# Getting started

Initialize the library in your `Application.onCreate()` method:
```java
PowerPreference.init(this);
```

There are two ways to access the preference file:

1. Default File

This is the default file provided by the library.

```java
Preference preference = PowerPreference.getDefaultFile();
```
2. Custom File

When you choose a file name, a new file with that name will be created.
```java
Preference preference = PowerPreference.getFileByName("preferenceName");
```

# Save Data

The library can store data in two ways. **asynchronously** and **synchronously**.

Also, The library can store any type of data.

**Integer, Long, Float, Double, String, ArrayList, Map, Object** are all valid data types.

## Asynchronous

To write data to a preference file **asynchronously**, use methods that begin with the **put** prefix. 

The thread you're working on will **not** be blocked.

* Insert single value
```java
PowerPreference.getDefaultFile().putString("key",value);
```

* Insert multiple values

```java
PowerPreference.getDefaultFile()
        .putString("key", value)
        .putObject("key", value)
              .
              .
        .putMap("key", value);
```

## Synchronous

To write data to a preference file **synchronous**, use methods that begin with the **set** prefix. 

Until the save operation's result is received, the thread you're working on will be blocked. 


```java
boolean result = PowerPreference.getDefaultFile().setString("key",value);
```

Set can also be called with other types, such as `setBoolean()` and `setObject()`.

# Read Data

To retrieve data from a preference file, use methods that begin with the **get** prefix. 

1. **String**
```java
String value = PowerPreference.getDefaultFile().getString("key", defValue);
```

2. **Object**
```java
Object value = PowerPreference.getDefaultFile().getObject("key", Object.class, defValue);
```

3. **Array**
```java
ArrayList<Object> value = PowerPreference.getDefaultFile().getObject("key", Object[].class, defValue);
```

4. **Map**
```java
MapStructure structure = MapStructure.create(HashMap.class, String.class, Object.class);
HashMap<String, Object> value = PowerPreference.getDefaultFile().getMap("key", structure);
```

### Note:
If you don't specify a default value when calling get and the key you're looking for doesn't exist, the library will return default value from the list below.

**For Example:**
```java
String value = PowerPreference.getDefaultFile().getString("key");
```
If you call get string without specifying a default value and the key does not exist, the library will return an empty string as a default value.


| Type | Default |
| --- | --- |
| Integer, Long, Float, Double | 0 |
| String | "" |
| Object | null |

You also can choose a default value for each key in you preference file by ``seDefaults()`` method see the defaults section for more.

# Remove Data

* Synchronous
```java
PowerPreference.getDefaultFile().remove("key");
```
* Asynchronous
```java
PowerPreference.getDefaultFile().removeAsync("key");
```

# Clear Data

#### 1. Clear data from specefic file

* Synchronous
```java
PowerPreference.getDefaultFile().clear();
```
* Asynchronous
```java
PowerPreference.getDefaultFile().clearAsync();
```

#### 2. Clear data from all files

* Synchronous
```java
PowerPreference.clearAllData();
```
* Asynchronous
```java
PowerPreference.clearAllDataAsync();
```

# Get Data

1. Get all data for a specefic file
```java
Map<String, ?> data = PowerPreference.getDefaultFile().getData();
```

2. Get all data for all files in the app.
```java
List<PreferenceFile> data = PowerPreference.getAllData()
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
Using the preference debugger, you can easily see and edit all of your app's preferences data.

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
