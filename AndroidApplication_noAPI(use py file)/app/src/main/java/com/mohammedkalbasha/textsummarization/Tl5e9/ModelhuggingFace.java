package com.mohammedkalbasha.textsummarization.Tl5e9;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.mohammedkalbasha.textsummarization.R;
import com.mohammedkalbasha.textsummarization.Result.Result_Tl5e9_and_translate;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class ModelhuggingFace extends AppCompatActivity {

    EditText txt;
    Spinner spinner_model2;
    Button summ;
    String name_model;
    int numModel = 1;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_model_hugging_face);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        txt = findViewById(R.id.editText_Text_);
        summ = findViewById(R.id.button_sum);
        spinner_model2 = findViewById(R.id.spinner_model2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.model_name_HuggingFace,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_model2.setAdapter(adapter);
        spinner_model2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name_model = parent.getItemAtPosition(position).toString();
                if (name_model.equals("bert2bert")) {
                    numModel = 1;
                } else if (name_model.equals("arabartsummarization")) {
                    numModel = 2;
                } else if (name_model.equals("xlmroberta2xlmroberta")) {
                    numModel = 3;
                } else if (name_model.equals("AraBART-summ")) {
                    numModel = 4;
                } else if (name_model.equals("auto-arabic-summarization")) {
                    numModel = 5;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        summ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt.getText().toString().equals("")) {
                    PopupDialog.getInstance(ModelhuggingFace.this)
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
                    dialog = new Dialog(ModelhuggingFace.this);
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
                    Python.start(new AndroidPlatform(ModelhuggingFace.this));

                Python py = Python.getInstance();
                final PyObject script = py.getModule("script");

                Intent intent = new Intent(ModelhuggingFace.this, Result_Tl5e9_and_translate.class);

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefData", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                Toast.makeText(getApplicationContext(), "لحظات الانتظار .. املأها بالاستغفار", Toast.LENGTH_SHORT).show();
                PyObject obj = script.callAttr("_model", txt.getText().toString(), numModel);
                myEdit.putString("tl5e9_Text_Url", obj.toString());
                myEdit.apply();
                dialog.dismiss();

                startActivity(intent);
            }
        });
    }

    public void useWebhuggingFace(View view) {
        String url = "https://abdalrahmanshahrour-summarization.hf.space/";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}