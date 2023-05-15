package com.example.opd.ui.Calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.opd.R;

import java.util.ArrayList;

public class Calculator_activity extends AppCompatActivity {
    float res;
    ArrayList<CalcFragmentToOneValuesData> fragments = new ArrayList<CalcFragmentToOneValuesData>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main);
        setInitialData();
        countriesList =findViewById(R.id.countriesList);
        CalcFragmentAdapter adapter = new CalcFragmentAdapter(this,R.layout.calc_fragment,fragments);
        countriesList.setAdapter(adapter);
        Button calcButton = findViewById(R.id.calc_button);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View clacValueView=countriesList.getChildAt(0);
                EditText editText=clacValueView.findViewById(R.id.homessquare);
                short fuelUse;
                if (editText.getText().toString().equals(""))
                {fuelUse=0;}
                else
                {fuelUse = Short.valueOf(editText.getText().toString());}
                res = (float) (res + (fuelUse * 0.45));

                clacValueView=countriesList.getChildAt(1);
                editText=clacValueView.findViewById(R.id.homessquare);
                short road;
                if (editText.getText().toString().equals(""))
                    road=0;
                else
                    road = Short.valueOf(editText.getText().toString());
                res = (float) (res + (road*0.2879*2.58));

                clacValueView=countriesList.getChildAt(2);
                editText=clacValueView.findViewById(R.id.homessquare);
                if (editText.getText().toString().equals(""))
                    road=0;
                else
                    road = Short.valueOf(editText.getText().toString());
                res = (float) (res + (road*0.2879*2.58*30));

                clacValueView=countriesList.getChildAt(3);
                editText=clacValueView.findViewById(R.id.homessquare);
                short Metrsqr;
                if (editText.getText().toString().equals("")){
                    Metrsqr = 0;
                    res = (float) (res + (Metrsqr * 3.405));}
                else{
                    Metrsqr = Short.valueOf(editText.getText().toString());
                    res = (float) (res + (Metrsqr * 3.405 + 67.848));}

                clacValueView=countriesList.getChildAt(4);
                editText=clacValueView.findViewById(R.id.homessquare);
                short money = 0;
                if (editText.getText().toString().equals("")){
                    money = 0;
                    }
                else{
                    Metrsqr = Short.valueOf(editText.getText().toString());
                    res = (float) (res + (money *  0.000008507  + 0.001525719));}

                clacValueView=countriesList.getChildAt(5);
                editText=clacValueView.findViewById(R.id.homessquare);
                road=0;
                if (editText.getText().toString().equals("")){
                    road = 0;
                    }
                else{
                    Metrsqr = Short.valueOf(editText.getText().toString());
                    res = (float) (res + (road * 0.0742 + 0.0661));}

                setContentView(R.layout.calc_end);
                TextView lastValues = findViewById(R.id.textView4);
                lastValues.setText(Float.toString(res)+"кг CO2");
            }
        });
    }

    private void setInitialData(){
        String[] mainTexts = getResources().getStringArray(R.array.calc_main_text);
        String[] leftTexts = getResources().getStringArray(R.array.calc_left_text);
        String[] units = getResources().getStringArray(R.array.calc_unit);
        for (int i =  0;i<units.length;i++ ){
            fragments.add(new CalcFragmentToOneValuesData(mainTexts[i],leftTexts[i],units[i]));
        }
    }
}