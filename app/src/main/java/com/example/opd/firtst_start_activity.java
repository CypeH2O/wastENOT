package com.example.opd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class firtst_start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firtst_start);
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
}