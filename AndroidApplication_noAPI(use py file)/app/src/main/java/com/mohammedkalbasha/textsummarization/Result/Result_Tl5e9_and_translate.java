package com.mohammedkalbasha.textsummarization.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.mohammedkalbasha.textsummarization.R;

public class Result_Tl5e9_and_translate extends AppCompatActivity {

    String textRuseltTl5e9;
    TextView texttl5e9;
    SharedPreferences tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_tl5e9_and_translate);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        texttl5e9 = findViewById(R.id.texttl5e9_and_translate);

        tx = getSharedPreferences("MySharedPrefData", MODE_PRIVATE);

        textRuseltTl5e9 = tx.getString("tl5e9_Text_Url", "");


        texttl5e9.setText(textRuseltTl5e9);

    }

    public void CopyText_and_translate(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("تلخيص نصوص", textRuseltTl5e9);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(), "تم نسخ النص", Toast.LENGTH_SHORT).show();

    }

    public void ShareText_and_translate(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textRuseltTl5e9);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void again_and_translate(View view) {
        finish();
    }

    public void translate_Text(View view) {
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py = Python.getInstance();
        final PyObject script = py.getModule("translate");

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_translate);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        Button ar =  dialog.findViewById(R.id.button_ar_translate);
        Button en = dialog.findViewById(R.id.button_en_translate);

        ar.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "لحظات الانتظار .. املأها بالاستغفار", Toast.LENGTH_SHORT).show();
            PyObject obj = script.callAttr("translate_M_S",textRuseltTl5e9,"ar");
            texttl5e9.setText(obj.toString());
            dialog.dismiss();
        });


        en.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "لحظات الانتظار .. املأها بالاستغفار", Toast.LENGTH_SHORT).show();
            PyObject obj = script.callAttr("translate_M_S",textRuseltTl5e9,"en");
            texttl5e9.setText(obj.toString());
            dialog.dismiss();
        });

    }
}