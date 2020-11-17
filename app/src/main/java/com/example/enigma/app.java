package com.example.enigma;

import android.app.Application;

import com.example.enigma_sharedpreference.Enigma;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Enigma.InitHelper(this);
    }
}
