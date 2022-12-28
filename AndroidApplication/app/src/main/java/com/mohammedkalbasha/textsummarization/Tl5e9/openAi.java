package com.mohammedkalbasha.textsummarization.Tl5e9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.mohammedkalbasha.textsummarization.R;
import com.mohammedkalbasha.textsummarization.Result.Result_Tl5e9_and_translate;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class openAi extends AppCompatActivity {

    EditText txt;
    Button summ;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_ai);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        txt = findViewById(R.id.editText_Text_openai);
        summ = findViewById(R.id.button_openai);


        summ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt.getText().toString().equals("")) {
                    PopupDialog.getInstance(openAi.this)
                            .setStyle(Styles.ALERT)
                            .setHeading("الرجاء تعبئة المعلومات وعدم ترك الخانة فارغة")
                            .setCancelable(false)
                            .setDismissButtonText("رجوع")
                            .setDismissButtonTextColor(R.color.black)
                            .setDismissButtonBackground(R.drawable.border2)
                            .showDialog(new OnDialogButtonClickListener() {
                                @Override
                                public void onDismissClicked(Dialog dialog) {
                                    super.onDismissClicked(dialog);
                                }
                            });
                } else {
                    dialog = new Dialog(openAi.this);
                    dialog.setContentView(R.layout.dialog_loading);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.show();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            play();
                        }
                    }, 500);


                }
            }

            private void play() {
                if (!Python.isStarted())
                    Python.start(new AndroidPlatform(openAi.this));

                Python py = Python.getInstance();
                final PyObject script = py.getModule("openaiGpt3");

                Intent intent = new Intent(openAi.this, Result_Tl5e9_and_translate.class);

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefData", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                Toast.makeText(getApplicationContext(), "لحظات الانتظار .. املأها بالاستغفار", Toast.LENGTH_SHORT).show();
                PyObject obj = script.callAttr("api_openai_gpt3", txt.getText().toString());
                myEdit.putString("tl5e9_Text_Url", obj.toString());
                myEdit.apply();
                dialog.dismiss();

                startActivity(intent);
            }
        });


    }
}
