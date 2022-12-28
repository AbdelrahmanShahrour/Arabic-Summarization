package com.mohammedkalbasha.textsummarization.Other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mohammedkalbasha.textsummarization.R;

public class WelcomeScreen extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        name = findViewById(R.id.editTextYourName);

    }

    public void goHomeScreen(View view) {

        Intent intent = new Intent(WelcomeScreen.this, HomeScreen.class);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefName", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("nameUser", name.getText().toString());
        myEdit.apply();

        startActivity(intent);
        finish();
    }


}