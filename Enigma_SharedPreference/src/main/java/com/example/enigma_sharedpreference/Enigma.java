package com.example.enigma_sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Enigma {
    private static Enigma instance;
    private SharedPreferences sharedPreferences;

    private static final boolean DEFAULT_BOOLEAN_VAL = false;
    private static final float DEFAULT_FLOAT_VAL = 0.0F;
    private static final int DEFAULT_INT_VAL = -1;
    private static final long DEFAULT_LONG_VAL = -1L;
    private static final double DEFAULT_DOUBLE_VAL = 0.0;
    private static final String DEFAULT_STRING_VAL = "";
    private static final Set<String> DEFAULT_STRINGSET_VAL = null;


    private Enigma(Context context) {
        try {
            MasterKey masterKey = new MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            sharedPreferences = EncryptedSharedPreferences.create(
                    context,
                    context.getPackageName() + "_preferences",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Enigma getInstance() {

        return instance;
    }

    //use only application context to avoid memory leaks
    public static Enigma InitHelper(Context appContext) {
        if (instance == null)
            instance = new Enigma(appContext.getApplicationContext());
        return instance;
    }

    /**
     * use this to retrieve Boolean values
     *
     * @param key of the Boolean value that is going to be retrieved
     */

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, DEFAULT_BOOLEAN_VAL);
    }

    /**
     * use this to retrieve Boolean values with defaultValue
     *
     * @param key          of the Boolean value that is going to be retrieved
     * @param defaultValue in case that the key is not stored
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * use this to retrieve float values
     *
     * @param key of the float value that is going to be retrieved
     */

    public float getFloat(String key) {

        return sharedPreferences.getFloat(key, DEFAULT_FLOAT_VAL);
    }

    /**
     * use this to retrieve float values with defaultValue
     *
     * @param key          of the float value that is going to be retrieved
     * @param defaultValue in case that the key is not stored
     */
    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    /**
     * use this to retrieve Integer values
     *
     * @param key of the Integer value that is going to be retrieved
     */

    public int getInt(String key) {

        return sharedPreferences.getInt(key, DEFAULT_INT_VAL);
    }

    /**
     * use this to retrieve Integer values with defaultValue
     *
     * @param key          of the Integer value that is going to be retrieved
     * @param defaultValue in case that the key is not stored
     */
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * use this to retrieve Long values
     *
     * @param key of the Long value that is going to be retrieved
     */

    public long getLong(String key) {
        return sharedPreferences.getLong(key, DEFAULT_LONG_VAL);
    }

    /**
     * use this to retrieve Long values with defaultValue
     *
     * @param key          of the Long value that is going to be retrieved
     * @param defaultValue in case that the key is not stored
     */
    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    /**
     * use this to retrieve Double values
     *
     * @param key of the Double value that is going to be retrieved
     */
    public double getDouble(String key) {
        if (!contains(key))
            return DEFAULT_DOUBLE_VAL;

        return Double.longBitsToDouble(getLong(key));
    }

    /**
     * use this to retrieve Double values
     *
     * @param key of the String value that is going to be retrieved
     */

    public String getString(String key) {
        return sharedPreferences.getString(key, DEFAULT_STRING_VAL);
    }

    /**
     * use this to retrieve String values with defaultValue
     *
     * @param key          of the String value that is going to be retrieved
     * @param defaultValue in case that the key is not stored
     */
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    /**
     * use this to retrieve StringSet values
     *
     * @param key of the StringSet value that is going to be retrieved
     */
    public Set<String> getStringSet(String key) {
        return sharedPreferences.getStringSet(key, DEFAULT_STRINGSET_VAL);
    }

    /**
     * use this to retrieve StringSet values
     *
     * @param key          of the StringSet value that is going to be retrieved
     * @param defaultValue in case that the key is not stored
     */

    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        return sharedPreferences.getStringSet(key, defaultValue);
    }

    /**
     * use this to retrieve ArrayList values
     *
     * @param key of the ArrayList value that is going to be retrieved
     */

    public ArrayList getArrayList(String key) {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, DEFAULT_STRING_VAL);
        Type type = new TypeToken<List<?>>() {
        }.getType();
        return gson.fromJson(json, type);

    }

    /**
     * use this to retrieve HashMap values
     *
     * @param key of the HashMap value that is going to be retrieved
     */
    public HashMap<String, ?> getHashMap(String key) {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, "");
        java.lang.reflect.Type type = new TypeToken<HashMap<String, ?>>() {
        }.getType();
        return gson.fromJson(json, type);
    }



    /**
     * use this to retrieve all Shared Preference values in storage
     */
    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }

    /**
     * use this to store Boolean values
     *
     * @param key   of the Boolean value that is going to be stored
     * @param value you want to store
     */
    public void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    /**
     * use this to store Boolean values and retrieve true/false if succeed.
     *
     * @param key   of the Boolean value that is going to be stored
     * @param value you want to store
     */
    public boolean putBooleanSync(String key, boolean value) {
        return sharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * use this to store float values
     *
     * @param key   of the float value that is going to be stored
     * @param value you want to store
     */
    public void putFloat(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    /**
     * use this to store float values and retrieve true/false if succeed.
     *
     * @param key   of the float value that is going to be stored
     * @param value you want to store
     */
    public boolean putFloatSync(String key, float value) {
        return sharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * use this to store Integer values.
     *
     * @param key   of the Integer value that is going to be stored
     * @param value you want to store
     */
    public void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    /**
     * use this to store Integer values and retrieve true/false if succeed.
     *
     * @param key   of the Integer value that is going to be stored
     * @param value you want to store
     */
    public boolean putIntSync(String key, int value) {
        return sharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * use this to store Long values.
     *
     * @param key   of the Long value that is going to be stored
     * @param value you want to store
     */
    public void putLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    /**
     * use this to store Long values and retrieve true/false if succeed.
     *
     * @param key   of the Long value that is going to be stored
     * @param value you want to store
     */
    public boolean putLongSync(String key, long value) {
        return sharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * use this to store Double values.
     *
     * @param key   of the Double value that is going to be stored
     * @param value you want to store
     */
    public void putDouble(String key, double value) {
        putLong(key, Double.doubleToRawLongBits(value));
    }

    /**
     * use this to store Double values and retrieve true/false if succeed.
     *
     * @param key   of the Double value that is going to be stored
     * @param value you want to store
     */
    public boolean putDoubleSync(String key, double value) {
        return putLongSync(key, Double.doubleToRawLongBits(value));
    }

    /**
     * use this to store String values.
     *
     * @param key   of the String value that is going to be stored
     * @param value you want to store
     */
    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * use this to store String values and retrieve true/false if succeed.
     *
     * @param key   of the String value that is going to be stored
     * @param value you want to store
     */
    public boolean putStringSync(String key, String value) {
        return sharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * use this to store StringSet values.
     *
     * @param key   of the StringSet value that is going to be stored
     * @param value you want to store
     */
    public void putStringSet(String key, Set<String> value) {
        sharedPreferences.edit().putStringSet(key, value).apply();
    }

    /**
     * use this to store StringSet values and retrieve true/false if succeed.
     *
     * @param key   of the StringSet value that is going to be stored
     * @param value you want to store
     */
    public boolean putStringSetSync(String key, Set<String> value) {
        return sharedPreferences.edit().putStringSet(key, value).commit();
    }

    /**
     * use this to store ArrayList values.
     *
     * @param key   of the ArrayList value that is going to be stored
     * @param value you want to store
     */
    public void putArrayList(String key, ArrayList value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString(key, json).apply();
    }

    /**
     * use this to store ArrayList values and retrieve true/false if succeed.
     *
     * @param key   of the ArrayList value that is going to be stored
     * @param value you want to store
     */
    public boolean putArrayListSync(String key, ArrayList value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return editor.putString(key, json).commit();
    }

    /**
     * use this to store HashMap values.
     *
     * @param key   of the ArrayList value that is going to be stored
     * @param value you want to store
     */
    public void putHashMap(String key, HashMap<String, ?> value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString(key, json).apply();
    }

    /**
     * use this to store HashMap values and retrieve true/false if succeed.
     *
     * @param key   of the ArrayList value that is going to be stored
     * @param value you want to store
     */
    public boolean putHashMapSync(String key, HashMap<String, ?> value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return editor.putString(key, json).commit();
    }

    /**
     * use this to remove a value by key from storage
     *
     * @param key you want to remove
     */
    public void remove(String key) {

        sharedPreferences.edit().remove(key).apply();
    }

    /**
     * use this to remove a value by key from storage Synchronously
     *
     * @param key you want to remove
     */
    public boolean removeSync(String key) {

        return sharedPreferences.edit().remove(key).commit();
    }

    /**
     * use this to remove all values from storage.
     */

    public void removeAll() {

        sharedPreferences.edit().clear().apply();
    }

    /**
     * use this to remove all values from storage Synchronously
     */
    public boolean removeAllSync() {

        return sharedPreferences.edit().clear().commit();
    }

    /**
     * check if the storage contains a certain key
     *
     * @param key you want to find
     * @return true/false
     */
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }
}
