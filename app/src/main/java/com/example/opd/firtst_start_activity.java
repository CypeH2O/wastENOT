package com.example.opd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class firtst_start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLang();
        setContentView(R.layout.activity_firtst_start);
        SharedPreferences sp = getSharedPreferences("lastres",Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putFloat("result",0);
        e.commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        View butView = findViewById(R.id.button);
        Context con = this;
        butView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con, MainActivity.class);
                startActivity(intent);
            }
        });
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