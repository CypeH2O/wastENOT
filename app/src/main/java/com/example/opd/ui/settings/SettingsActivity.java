package com.example.opd.ui.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opd.R;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {
    String[] countries = { "Русский", "Английский"};
    Context context = this;
    boolean first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        first = true;
        setLang();
        setContentView(R.layout.activity_settings);
        View ClearButton = findViewById(R.id.ClearButton);
        ClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("lastres", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putFloat("result",0);
                e.commit();
            }
        });

        View DisplayButton = findViewById(R.id.DisplayButton);
        DisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("firstStart", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putBoolean("hasVisited", false);
                e.commit();
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

    @Override
    protected void onStart() {
        super.onStart();
        Spinner sp = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(first){
                    first=false;
                }else {
                    Toast toast = Toast.makeText(context, "Смена языка произойдет после перезагрузки", Toast.LENGTH_LONG);
                    // Получаем выбранный объект
                    String item = (String) parent.getItemAtPosition(position);

                    SharedPreferences sp = getSharedPreferences("language", Context.MODE_PRIVATE);
                    SharedPreferences.Editor e = sp.edit();

                    switch (item) {
                        case "Английский":

                            e.putString("language", "en");
                            e.commit();
                            break;
                        case "Русский":

                            e.putString("language", "ru");
                            e.commit();
                            break;
                    }

                    toast.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        sp.setOnItemSelectedListener(itemSelectedListener);
    }
}