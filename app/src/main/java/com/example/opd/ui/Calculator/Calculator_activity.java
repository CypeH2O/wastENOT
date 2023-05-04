package com.example.opd.ui.Calculator;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.opd.R;
public class Calculator_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc1);
        //ViewPager2 pager = findViewById(R.id.pager);
        //CalcAdapter adapter =new CalcAdapter(this);
        //pager.setAdapter(adapter);
        //pager.setUserInputEnabled(false);
    }

    public void NextQuestion(View view){
        View v1 = findViewById(R.id.FirstQuestion);
        if( v1 != null && view.getId()==v1.getId()){
            setContentView(R.layout.calc2);
        }

        if(findViewById(R.id.SecondQuestion) != null && view.getId()==findViewById(R.id.SecondQuestion).getId()){
            setContentView(R.layout.calc3);
        }

        if(findViewById(R.id.ThirdQestion) != null && view.getId()==findViewById(R.id.ThirdQestion).getId()){
            setContentView(R.layout.calc_end);
        }

        if(findViewById(R.id.CalcEnd) != null && view.getId()==findViewById(R.id.CalcEnd).getId()){
            finish();
        }
    }
}