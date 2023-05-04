package com.example.opd.ui.Calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.opd.PageFragment;
import com.example.opd.R;

public class CalcFragment1 extends Fragment {
    public static CalcFragment1 newInstance() {
        CalcFragment1 fragment = new CalcFragment1();
        return fragment;
    }

    public CalcFragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.calc_fragment_1, container, false);

        return result;
    }
}
