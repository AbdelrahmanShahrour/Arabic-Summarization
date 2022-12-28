package com.mohammedkalbasha.textsummarization.Tl5e9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.Map;

public class Tl5e9_Url extends AppCompatActivity {

    String name_model, language = "arabic";
    EditText text_before, num_line_summ;
    Spinner spinner_model;
    private ProgressBar loadingPB;

    String url_web = "http://mohammedalbasha.pythonanywhere.com/analyze_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tl5e9_url);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        text_before = findViewById(R.id.text_before_summarization_URL);
        num_line_summ = findViewById(R.id.num_line_URL);
        spinner_model = findViewById(R.id.spinner_URL);
        loadingPB = findViewById(R.id.progressBar_URL);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.model_name, android.R.layout.simple_spinner_item);
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

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton_ar_lung:
                if (checked)
                    language = "arabic";
                break;
            case R.id.radioButton_en_lung:
                if (checked)
                    language = "english";
                break;
        }
    }


    public void goToSummUrl(View view) {
        if (text_before.getText().toString().equals("") || num_line_summ.getText().toString().equals("")) {
            PopupDialog.getInstance(Tl5e9_Url.this)
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
        } else {
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
        RequestQueue queue = Volley.newRequestQueue(Tl5e9_Url.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url_web, response -> {
            // inside on response method we are
            // hiding our progress bar
            // and setting data to edit text as empty
            loadingPB.setVisibility(View.GONE);

            // on below line we are displaying a success toast message.
            Toast.makeText(Tl5e9_Url.this, "تم جلب البيانات بعد معالجتها", Toast.LENGTH_SHORT).show();
            try {
                // on below line we are parsing the response
                // to json object to extract data from it.
                JSONObject respObj = new JSONObject(response);


                // below are the strings which we
                // extract from our json object.
                String text_summary = respObj.getString("text_summary_URL_json");
//                String text_category = respObj.getString("text_category_URL_json");

                // on below line we are setting this string s to our text view.
//                t1.setText(text_summary);
//                t2.setText(text_category);
//                String t = text_before.getText().toString()+ num_line_summ.getText().toString() + name_model+language;

                Intent intent = new Intent(Tl5e9_Url.this, Result_Tl5e9.class);
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefData", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("tl5e9_Text_Url", text_summary);
                myEdit.apply();
                startActivity(intent);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(Tl5e9_Url.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
                PopupDialog.getInstance(Tl5e9_Url.this)
                        .setStyle(Styles.FAILED)
                        .setHeading("الرجاء التحقق من الأتصال والمحاولة مرة أخرى")
                        .setCancelable(false)
                        .setDismissButtonText("رجوع")
                        .setDismissButtonTextColor(R.color.white)
                        .setDismissButtonBackground(R.drawable.border5)
                        .showDialog(new OnDialogButtonClickListener() {
                            @Override
                            public void onDismissClicked(Dialog dialog) {
                                super.onDismissClicked(dialog);
                            }
                        });
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("url_input_text", textBefore);
                params.put("url_sentences_number", numberLine);
                params.put("url_classifier", nameModel);
                params.put("url_language", Language);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

}

