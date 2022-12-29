package com.mohammedkalbasha.textsummarization.Tl5e9;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mohammedkalbasha.textsummarization.R;
import com.mohammedkalbasha.textsummarization.Result.Result_Tl5e9;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tl5e9_SoundToText extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private static final Integer RecordAudioRequestCode = 1;
    String name_model, language = "arabic";
    EditText text_before, num_line_summ;
    Spinner spinner_model;
    private ProgressBar loadingPB;

    String url_txt = "http://mohammedalbasha.pythonanywhere.com/analyze_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tl5e9_sound_to_text);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED))
        {
            chechPermission();
        }


        text_before = findViewById(R.id.text_before_summarization_SoundToText);
        num_line_summ = findViewById(R.id.num_line_SoundToText);
        spinner_model = findViewById(R.id.spinner_SoundToText);
        loadingPB = findViewById(R.id.progressBar_SoundToText);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.model_name, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_model.setAdapter(adapter);
        spinner_model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name_model = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void chechPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}
                    , RecordAudioRequestCode);
        }
    }


    public void goToSummText_SoundToText(View view) {

        if(text_before.getText().toString().equals("") || num_line_summ.getText().toString().equals("")){
            PopupDialog.getInstance(Tl5e9_SoundToText.this)
                    .setStyle(Styles.ALERT)
                    .setHeading("الرجاء تعبئة المعلومات وعدم ترك خانات فارغة")
                    .setCancelable(false)
                    .setDismissButtonText("رجوع")
                    .setDismissButtonTextColor(R.color.black)
                    .setDismissButtonBackground(R.drawable.border2)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            finish();
                            super.onDismissClicked(dialog);
                        }
                    });
        }else{
            postDataUsingVolley(text_before.getText().toString(),
                    num_line_summ.getText().toString(),
                    name_model,
                    language
            );
        }
    }

    private void postDataUsingVolley(String textBefore, String numberLine, String nameModel, String Language) {

        // url to post our data
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(Tl5e9_SoundToText.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url_txt, response -> {
            // inside on response method we are
            // hiding our progress bar
            // and setting data to edit text as empty
            loadingPB.setVisibility(View.GONE);

            // on below line we are displaying a success toast message.
            Toast.makeText(Tl5e9_SoundToText.this, "تم جلب البيانات بعد معالجتها", Toast.LENGTH_SHORT).show();
            try {
                // on below line we are parsing the response
                // to json object to extract data from it.
                JSONObject respObj = new JSONObject(response);


                // below are the strings which we
                // extract from our json object.
                String text_summary = respObj.getString("text_summary_json");
                String text_category = respObj.getString("text_category_json");

                // on below line we are setting this string s to our text view.

                Intent intent = new Intent(Tl5e9_SoundToText.this, Result_Tl5e9.class);
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefData", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("tl5e9_Text_Url", text_summary);
//                myEdit.putString("tl5e9_Text_Url", text_summary + "\n" + text_category);
                myEdit.apply();
                startActivity(intent);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
//                Toast.makeText(Tl5e9_SoundToText.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
                PopupDialog.getInstance(Tl5e9_SoundToText.this)
                        .setStyle(Styles.FAILED)
                        .setHeading("الرجاء التحقق من الأتصال والمحاولة مرة أخرى")
                        .setCancelable(false)
                        .setDismissButtonText("رجوع")
                        .setDismissButtonTextColor(R.color.white)
                        .setDismissButtonBackground(R.drawable.border5)
                        .showDialog(new OnDialogButtonClickListener() {
                            @Override
                            public void onDismissClicked(Dialog dialog) {
                                finish();
                                super.onDismissClicked(dialog);
                            }
                        });
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("text_input_text", textBefore);
                params.put("text_sentences_number", numberLine);
                params.put("text_classifier", nameModel);
                params.put("text_language", Language);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }


    public void speechRecognition(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_lung_sound);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        Button ar =  dialog.findViewById(R.id.button_ar);
        Button en = dialog.findViewById(R.id.button_en);

        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                language = "arabic";
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-JO");
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "الرجاء التكلم ...");

                try {
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                } catch (Exception e) {
                    Toast.makeText(Tl5e9_SoundToText.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language = "english";
                dialog.dismiss();
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please Talk ...");

                try {
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                } catch (Exception e) {
                    Toast.makeText(Tl5e9_SoundToText.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                text_before.setText(result.get(0));
            }
        }
    }
}