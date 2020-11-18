# Enigma - SharedPreference
[![](https://jitpack.io/v/Dtabaja/Enigma-SharedPreference.svg)](https://jitpack.io/#Dtabaja/Enigma-SharedPreference)


<img src="https://github.com/Dtabaja/Enigma-SharedPreference/blob/master/enigma3.jpg" width="500">




Enigma is a library that encrypt your Shared Sreference with 256AES Encryption.

## Setup
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:

```
dependencies {
	        implementation 'com.github.Dtabaja:Enigma-SharedPreference:1.00.01'
}
```
## Usage
Step 1. open a new class: 

<img src="https://github.com/Dtabaja/Enigma-SharedPreference/blob/master/Application2.JPG" width="500">

Step 2. implement the initHelper Function:

<img src="https://github.com/Dtabaja/Enigma-SharedPreference/blob/master/Application.JPG" width="600">

Step 3. Add your class in the manifest:

<img src="https://github.com/Dtabaja/Enigma-SharedPreference/blob/master/manifest.JPG" width="600">

## Functions

 	Store an Integer value
        Enigma.getInstance().putInt("6",6);
        Enigma.getInstance().putIntSync("6",6);

        retrieve an Integer Value
        Enigma.getInstance().getInt("6");
	
        retrieve an Integer Value with a default value that i choose
        Enigma.getInstance().getInt("7",7);



        Store an Double value
        Enigma.getInstance().putDouble("1.4", 2.87);
        Enigma.getInstance().putDoubleSync("1.4", 2.87);

        retrieve a Double Value
        Enigma.getInstance().getDouble("1.4");



        Store a Boolean Value
        Enigma.getInstance().putBoolean("office", true);
        Enigma.getInstance().putBooleanSync("office", true);

        retrieve a Boolean Value
        Enigma.getInstance().getBoolean("office");
	
        retrieve n Boolean Value with a default value that i choose
        Enigma.getInstance().getBoolean("office", false);



        Store a Float Value
        Enigma.getInstance().putFloat("1.6", 1.6f);
        Enigma.getInstance().putFloatSync("1.6", 1.6f);

        retrieve a Float Value
        Enigma.getInstance().getFloat("1.6");
	
        retrieve a Float Value with a default value that i choose
        Enigma.getInstance().getFloat("1.8",1.8f);



        Store a String Value
        Enigma.getInstance().putString("name", "daniel");
        Enigma.getInstance().putStringSync("name", "daniel");

        retrieve a String Value
        Enigma.getInstance().getString("name");
	
	retrieve a String Value with a default value that i choose
        Enigma.getInstance().getString("name","avraham");



        Store a StringSet Values
        Enigma.getInstance().putStringSet("Club", set);
        Enigma.getInstance().putStringSetSync("Club", set);
	
        retrieve a StringSet Value
        Enigma.getInstance().getStringSet("club");
	
	retrieve a StringSet Value with a default value that i choose
        Enigma.getInstance().getStringSet("club",defulat);
	
	
	
        Store a HashMap Values
        Enigma.getInstance().putHashMap("cities", capitalCities);
        Enigma.getInstance().putHashMapSync("cities", capitalCities);

        retrieve a HashMap Values
        Enigma.getInstance().getHashMap("cities");



        Store a ArrayList Values
        Enigma.getInstance().putArrayList("Stam",arr);
        Enigma.getInstance().putArrayListSync("Stam",arr);

        retrieve a ArrayList Values
        Enigma.getInstance().getArrayList("Stam");
	
	

        retrieve ALL the key:value that are in the Shared Preference.
        Enigma.getInstance().getAll();
	
	

        Removes All the key:value in the Shared Preference.
        Enigma.getInstance().removeAll();
        Enigma.getInstance().removeAllSync();
	
	

        Giving a key, removes the value
        Enigma.getInstance().remove("cities");
        Enigma.getInstance().removeSync("cities");
	
	

        Giving a key, retrieve true/false if the value in the Shared Preference.
        Enigma.getInstance().contains("cities");



## Credits

Enigma picture: https://wordpandit.com/, https://pluviolover.com/2016/10/07/are-you-an-enigma/
