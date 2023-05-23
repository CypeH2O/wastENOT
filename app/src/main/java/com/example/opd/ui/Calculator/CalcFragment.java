package com.example.opd.ui.Calculator;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.opd.R;

import java.util.Locale;

public class CalcFragment extends Fragment {

    private int pageNumber;

    public static CalcFragment newInstance(int page) {
        CalcFragment fragment = new CalcFragment();
        return fragment;
    }

    public CalcFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLang();
        View result=inflater.inflate(R.layout.calc_start, container, false);


        return result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sp = this.getContext().getSharedPreferences("lastres", Context.MODE_PRIVATE);
        TextView lastres = view.findViewById(R.id.lastres);
        lastres.setText(Float.toString( sp.getFloat("result",0))+"кг CO2");
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sp = this.getContext().getSharedPreferences("lastres", Context.MODE_PRIVATE);
        TextView lastres = this.getView().findViewById(R.id.lastres);
        lastres.setText(Float.toString( sp.getFloat("result",0))+"кг CO2");
    }
    private void setLang(){
        SharedPreferences sp = this.getContext().getSharedPreferences("language", Context.MODE_PRIVATE);

        String languageToLoad  = sp.getString("language","ru"); // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
    }

}