package com.mohammedkalbasha.textsummarization.Other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mohammedkalbasha.textsummarization.R;
import com.mohammedkalbasha.textsummarization.Tl5e9.Tl5e9_SoundToText;
import com.mohammedkalbasha.textsummarization.Tl5e9.Tl5e9_Url;
import com.mohammedkalbasha.textsummarization.Tl5e9.Tl5e9_n9;
import com.mohammedkalbasha.textsummarization.Tl5e9.ModelhuggingFace;
import com.mohammedkalbasha.textsummarization.Tl5e9.openAi;

public class HomeScreen extends AppCompatActivity {

    TextView textView, numberST;
    Button buttonST;

    String str1,str2, name;
    int num = 5;
    HorizontalScrollView hsv;

    SharedPreferences sh, prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onStart() {
        chek();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        hsv = findViewById(R.id.HsV);
        numberST = findViewById(R.id.numberSoundText);
        buttonST = findViewById(R.id.buttonSoundText);
        textView = findViewById(R.id.nameUser);

        //name
        sh = getSharedPreferences("MySharedPrefName", MODE_PRIVATE);
        name = sh.getString("nameUser", "");
        textView.setText(name);

        editor = getSharedPreferences("numberTextSound", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("numberTextSound", MODE_PRIVATE);
        num = prefs.getInt("scoreNumber", 5);
        str2 = Integer.toString(num);
        numberST.setText(str2);



        hsv.postDelayed(new Runnable() {
            public void run() {
                hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        }, 100L);
    }

    public void goTo_Tl5e9_n9(View view) {
        Intent intent = new Intent(HomeScreen.this, Tl5e9_n9.class);
        startActivity(intent);
    }

    public void goTo_Tl5e9_Url(View view) {
        Intent intent = new Intent(HomeScreen.this, Tl5e9_Url.class);
        startActivity(intent);
    }



    public void rate(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + this.getPackageName())));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }

    public void soundText(View view) {
        chek();
        Intent intent = new Intent(HomeScreen.this, Tl5e9_SoundToText.class);
        num -= 1;
        str1 = Integer.toString(num);

        editor.putInt("scoreNumber", num);
        editor.apply();

        numberST.setText(str1);

        startActivity(intent);

    }

    private void chek() {
        if (num <= 0) {
            buttonST.setVisibility(View.GONE);
        } else {
            buttonST.setVisibility(View.VISIBLE);
        }

        if (num <= 0) {
            numberST.setText("0");
        }
    }

    public void test(View view) {
        Toast.makeText(this,"سيتم وضع المعلومات قريبا",Toast.LENGTH_SHORT).show();
    }

    public void goTo_Tl5e9_openAi(View view) {
        Intent intent = new Intent(HomeScreen.this, openAi.class);
        startActivity(intent);
    }

    public void goTo_Tl5e9_huggingface(View view) {
        Intent intent = new Intent(HomeScreen.this, ModelhuggingFace.class);
        startActivity(intent);
    }
}