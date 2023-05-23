package com.example.opd.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.opd.R;

import java.util.Locale;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLang();
        setContentView(R.layout.activity_about_us);
    }

    private void setLang(){
        SharedPreferences sp = this.getSharedPreferences("language", Context.MODE_PRIVATE);

        String languageToLoad  = sp.getString("language","ru"); // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }
}