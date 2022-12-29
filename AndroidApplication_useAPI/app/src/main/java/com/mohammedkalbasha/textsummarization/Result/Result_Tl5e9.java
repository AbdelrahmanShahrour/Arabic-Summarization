package com.mohammedkalbasha.textsummarization.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mohammedkalbasha.textsummarization.R;

public class Result_Tl5e9 extends AppCompatActivity {

    String textRuseltTl5e9;
    TextView texttl5e9;
    SharedPreferences tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_tl5e9);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        texttl5e9 = findViewById(R.id.texttl5e9);

        tx = getSharedPreferences("MySharedPrefData", MODE_PRIVATE);

        textRuseltTl5e9 = tx.getString("tl5e9_Text_Url", "");


        texttl5e9.setText(textRuseltTl5e9);

    }

    public void CopyText(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("تلخيص نصوص", textRuseltTl5e9);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(), "تم نسخ النص", Toast.LENGTH_SHORT).show();

    }

    public void ShareText(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textRuseltTl5e9);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void again(View view) {
        finish();
    }
}