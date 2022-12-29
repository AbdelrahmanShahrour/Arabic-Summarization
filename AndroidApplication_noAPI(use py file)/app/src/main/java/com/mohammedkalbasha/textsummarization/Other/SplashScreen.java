package com.mohammedkalbasha.textsummarization.Other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.mohammedkalbasha.textsummarization.R;

public class SplashScreen extends AppCompatActivity {

    Boolean flag;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }



        loadSavedPreferences();

        Thread SplashScreen = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                    if(flag){
                        myIntent = new Intent(com.mohammedkalbasha.textsummarization.Other.SplashScreen.this, WelcomeScreen.class);
                        savePreferences();
                    }else{
                        myIntent = new Intent(com.mohammedkalbasha.textsummarization.Other.SplashScreen.this, HomeScreen.class);
                    }
                    startActivity(myIntent);
                    finish();
                } catch (Exception e) {
                }}};

        SplashScreen.start();

    }



    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        flag = sharedPreferences.getBoolean("FirstLaunch", true);
    }

    private void savePreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("FirstLaunch", false);
        editor.apply();
    }


}