package com.example.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static final String SHARED_PREF_FILE = "MyApp";
    static final String SHARED_PREF_EDITOR_TEXT_KEY = "textInTheEditor";

    EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
    }

    @Override
    protected void onStop() {
        super.onStop();

        String text = editText.getText().toString();
        SharedPreferences sharedPreferences = getPref();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SHARED_PREF_EDITOR_TEXT_KEY, text);
        editor.commit();
    }

    protected SharedPreferences getPref() {
        return getSharedPreferences(SHARED_PREF_FILE, MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPref();

        String savedText = sharedPreferences.getString(SHARED_PREF_EDITOR_TEXT_KEY, null);
        editText.setText(savedText);
    }
}
