package com.example.opd.ui.Calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.opd.R;
public class Calculator_activity extends AppCompatActivity {
    float res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calc1);
    }
    public void NextQuestion(View view){
        View v1 = findViewById(R.id.FirstQuestion);
        if( v1 != null && view.getId()==v1.getId()){
            EditText editText = (EditText)findViewById(R.id.homessquare);
            int fuelUse = Integer.valueOf(editText.getText().toString());
            res = (float) (res + (fuelUse * 0.45));
            setContentView(R.layout.calc2);
        }

        if(findViewById(R.id.SecondQuestion) != null && view.getId()==findViewById(R.id.SecondQuestion).getId()){
            EditText editText = (EditText)findViewById(R.id.homessquare);
            int road = Integer.valueOf(editText.getText().toString());
            res = (float) (res + (road*0.2879*2.58));
            setContentView(R.layout.calc3);
        }

        if(findViewById(R.id.ThirdQestion) != null && view.getId()==findViewById(R.id.ThirdQestion).getId()){
            EditText editText = (EditText)findViewById(R.id.homessquare);
            int road = Integer.valueOf(editText.getText().toString());
            res = (float) (res + (road*0.2879*2.58*30));

            setContentView(R.layout.calc_end);
            TextView FinalValText = findViewById(R.id.textView4);
            String finalVal = "Ваш Результат: " + String.valueOf(res) + " кг";
            FinalValText.setText(finalVal);
        }

        if(findViewById(R.id.CalcEnd) != null && view.getId()==findViewById(R.id.CalcEnd).getId()){
            finish();
        }
    }
}